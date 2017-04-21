package com.denghb.zuiyou.server;

import com.denghb.zuiyou.common.Constants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Netty 服务端代码
 */
@Component
public class NioServer {

    /**
     * 日志对象
     */
    protected static Logger log = LoggerFactory.getLogger(NioServer.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static List<Channel> channelList = new ArrayList<Channel>();

    public NioServer() {
        log.info("NioServer start");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Server服务启动器
                ServerBootstrap bootstrap = new ServerBootstrap();
                EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
                EventLoopGroup workerGroup = new NioEventLoopGroup();
                try {
                    bootstrap.group(bossGroup, workerGroup)
                            .channel(NioServerSocketChannel.class)
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                public void initChannel(SocketChannel channel) throws Exception {
                                    channel.pipeline().addLast("encode", new StringEncoder());
                                    channel.pipeline().addLast("decode", new StringDecoder());
                                    channel.pipeline().addLast("ping", new IdleStateHandler(25, 15, 10, TimeUnit.SECONDS));
                                    channel.pipeline().addLast(new NioServerHandler());

                                    //
                                    channelList.add(channel);
                                }
                            }).option(ChannelOption.SO_BACKLOG, 128)
                            .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
                    // Bind and start to accept incoming connections.
                    ChannelFuture future = bootstrap.bind(Constants.Server.PORT).sync();

                    log.info("server started ,listen {}", Constants.Server.PORT);
                    // Wait until the server socket is closed.
                    // In this example, this does not happen, but you can do that to gracefully
                    // shut down your server. 调用实现优雅关机
                    future.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                } finally {
                    bossGroup.shutdownGracefully();
                    workerGroup.shutdownGracefully();
                }
            }
        });
    }

    public static void sendCommand(String cmd) {
        if (channelList.isEmpty()) {
            log.error("client empty send:{}", cmd);
            return;
        }
        log.info("client size:{} send:{}", channelList.size(), cmd);
        for (Channel channel : channelList) {
            if (null == channel || !channel.isActive()) {
                channelList.remove(channel);
                continue;
            }
            channel.writeAndFlush(cmd);
        }
    }
}  