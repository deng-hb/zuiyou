package com.denghb.zuiyou.client;

import com.denghb.zuiyou.common.Constants;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Netty 客户端代码 (只要一个实例)
 */
@Component
public class NioClient {
    /**
     * 日志对象
     */
    private Logger log = LoggerFactory.getLogger(NioClient.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    private Channel channel;

    public NioClient() {
        log.info("NioClient start");

        connect();
    }

    private void connect() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                NioEventLoopGroup workerGroup = new NioEventLoopGroup();
                Bootstrap bootstrap = new Bootstrap(); // (1)
                bootstrap.group(workerGroup); // (2)
                bootstrap.channel(NioSocketChannel.class); // (3)
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true); // (4)
                bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("encode", new StringEncoder());
                        ch.pipeline().addLast("decode", new StringDecoder());
                        ch.pipeline().addLast(new NioClientHandler());
                        ch.pipeline().addLast("ping", new IdleStateHandler(25, 15, 10, TimeUnit.SECONDS));

                        channel = ch;
                    }
                });
                try {
                    // Start the client.
                    ChannelFuture future = bootstrap.connect(Constants.Server.HOST, Constants.Server.PORT);
                    // Wait until the connection is closed.
                    future.channel().closeFuture().sync();
                    log.info("connect to server ...");
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    workerGroup.shutdownGracefully();
                }
            }

        });

    }

    // 重连
    @Scheduled(fixedRate = 5000)
    public void reconnect() {
        log.info("Checking connect to server ...");
        if (channel != null && channel.isActive()) {
            log.info("server connected");
            return;
        }

        connect();
    }
}
