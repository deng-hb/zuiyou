<?php
    echo 'loading..';
    $code = $_GET['code'];
    if (empty($code)) {
        header("Location: https://ac.ppdai.com/oauth2/login?AppID=3d45717f69064d7ea54d1d3ea1d5c685&ReturnUrl=http://zuiyou.bid.denghb.com/");
        exit;
    } else {
        // 发送到服务器 TODO 后续操作确认百分比成功
        send_code('https://gateway.zuiyou.bid/code='+$code);
    }

    /**
     * 发送post请求
     * @param string $url 请求地址
     * @param array $post_data post键值对数据
     * @return string
     */
    function send_code($url) {

        $options = array(
            'http' => array(
                'method' => 'GET',
                'header' => "X-Client:don't touch me for auth",
                'timeout' => 15 * 60 // 超时时间（单位:s）
            )
        );
        $context = stream_context_create($options);
        $result = file_get_contents($url, false, $context);

        return $result;
    }
?>