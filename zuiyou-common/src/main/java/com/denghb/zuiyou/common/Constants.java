package com.denghb.zuiyou.common;

/**
 * Created by denghb on 2017/4/11.
 */
public class Constants {

    public static class Server {


        public static final String HOST = "zuiyou.bid";

        public static final int PORT = 1235;

        /**
         * 获取投标规则
         */
        public static final String RULE_LIST_URL = "https://gateway." + Constants.Server.HOST + "/rule/list";

        /**
         * 创建投标记录
         */
        public static final String INVEST_HISTORY_CREATE_URL = "https://gateway." + Constants.Server.HOST + "/invest/history/create";

        /**
         * 借款标的
         */
        public static final String LOAN_RECEIVE_URL = "https://gateway." + Constants.Server.HOST + "/loan/receive";

        /**
         * PDU信息
         */
        public static final String PDU_RECEIVE = "https://gateway." + Constants.Server.HOST + "/pdu/receive";
    }

    public static class Web {
        public static final String CURRENT_USER = "CURRENT_USER";

    }
}
