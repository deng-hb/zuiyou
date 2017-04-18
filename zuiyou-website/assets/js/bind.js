(function() {
    // 判断当前域名
    var domain = 'ppdai.com';
    if (document.domain.indexOf(domain) == -1) {
        alert('请在拍拍贷网页操作');
        window.location.href = 'http://' + domain;
        return;
    }
    try {
        // 判断ppd是否登陆
        var cookie = document.cookie;
        var token = cookie.match(/token=(\S*);/)[1];
        var pdu = cookie.match(/ppd_uname=(\S*);/)[1];
        // 获取cookie跳转到zuiyou
        window.location.href = 'https://zuiyou.bid?token=' + token + '&pdu=' + pdu;
    } catch (e) {
        alert('请登录拍拍贷后操作');
    }
})();

