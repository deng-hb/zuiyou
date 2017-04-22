package com.denghb.zuiyou.common;

/**
 * Created by denghb on 2017/4/11.
 */
public class Constants {

    public static class Server {

        public static final String HOST = "zuiyou.bid";
        public static final int PORT = 1235;
        public static final String GATEWAY_HOST = "gateway.zuiyou.bid";
        public static final String PROTOCOL = "https://";

        /**
         * 获取投标规则
         */
        public static final String RULE_LIST_URL = PROTOCOL + GATEWAY_HOST + "/rule/list";

        /**
         * 创建投标记录
         */
        public static final String INVEST_HISTORY_CREATE_URL = PROTOCOL + GATEWAY_HOST + "/invest/history/create";

        /**
         * 借款标的
         */
        public static final String LOAN_RECEIVE_URL = PROTOCOL + GATEWAY_HOST + "/loan/receive";

        /**
         * PDU信息
         */
        public static final String PDU_RECEIVE = PROTOCOL + GATEWAY_HOST + "/pdu/receive";

        /**
         * 更新余额
         */
        public static final String UPDATE_BALANCE = PROTOCOL + GATEWAY_HOST + "/user/auth/updateBalance";

        /**
         * 授权已失效
         */
        public static final String AUTH_INVALID = PROTOCOL + GATEWAY_HOST + "/user/auth/invalid";
    }

    public static class Web {

        public static final String CURRENT_USER = "CURRENT_USER";


        /**
         * 会话状态检查
         */
        public static final String URL_SESSION = "/session";

    }

    /**
     * 指令
     */
    public static class Command {
        /**
         * 系统退出
         */
        public static final String SYSTEM_EXIT = "SYSTEM_EXIT";

        /**
         * 更新规则
         */
        public static final String UPDATE_RULE = "UPDATE_RULE";
    }
}
