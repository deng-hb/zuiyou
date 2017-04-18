package com.denghb.zuiyou.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 实际的业务处理类
 */
public class NioServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(NioServerHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        System.out.println(ctx);
        logger.info("--------server channelRegistered-------");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg)
            throws Exception {
        logger.info("--------from client----->{}", msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("--------server channelActive-------");
    }
}
