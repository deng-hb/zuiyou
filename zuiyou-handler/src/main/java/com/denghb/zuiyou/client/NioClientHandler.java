package com.denghb.zuiyou.client;

import com.denghb.zuiyou.common.Constants;
import com.denghb.zuiyou.data.RuleVoData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * client处理类
 */
public class NioClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(NioClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String cmd)
            throws Exception {
        logger.info("client----->收到服务器端消息：{}", cmd);

        execute(cmd);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        try {
            super.exceptionCaught(ctx, cause);
        } catch (Exception e) {
            logger.info("client exception ....关闭连接");
            ctx.close();
        }
    }


    /**
     * 执行指令
     *
     * @param cmd
     */
    private void execute(String cmd) {

        switch (cmd) {
            case Constants.Command.UPDATE_RULE:
                RuleVoData.pull();
                break;

            case Constants.Command.SYSTEM_EXIT:
                System.exit(1);
                break;
        }
    }
}
