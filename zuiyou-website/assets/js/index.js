$(function(){

    var $signin_form = $('#signin-form');
    $signin_form.attr('action',zuiyou.signin);
    jq.form($signin_form, function(){
        var geetest_challenge = $('.geetest_challenge').val();
        var geetest_validate = $('.geetest_validate').val();
        var geetest_seccode = $('.geetest_seccode').val();

        if('' == geetest_challenge || '' == geetest_validate || '' == geetest_seccode){
            alert('请滑动滑块验证');
            return false;
        }
        return true;
    }, function(data){
        $('.gt_refresh_button').click();
        console.log(data);
        if(data.code){
            // 保存
            var token = $.cookie('auth-token');
            var pdu = $.cookie('auth-pdu');
            if (token && pdu){
                jq.ajax(zuiyou.bind,{'token':token,'pdu':pdu},function(data){
                    $.removeCookie('auth-token');
                    $.removeCookie('auth-pdu');
                    alert("授权成功");
                    window.location.href = '/dashboard';
                });
            } else {
                window.location.href = '/dashboard';
            }

        }
    });

    $('#signin-password').blur(function(){

        var $password = $('#signin-password');
        if('' == $password.val()){
            return false;
        }
        $('#signin-password-value').val(md5($password.val()));

    });

    var $signup_form = $('#signup-form');
    $signup_form.attr('action',zuiyou.signup);
    jq.form($signup_form, function(){return true}, function(data){
        if(data.code){

            alert("注册成功");

            window.location.href = '/dashboard';
        }
    });

    $('#signup-password').blur(function(){

        var $password = $('#signup-password');
        if('' == $password.val()){
            return false;
        }
        $('#signup-password-value').val(md5($password.val()));

    });

    var token = $.getUrlParam('token');
    var pdu = $.getUrlParam('pdu');
    if (token && pdu){
        // 保存
        $.cookie('auth-token',token, { expires: 7 });
        $.cookie('auth-pdu',pdu, { expires: 7 });
        jq.ajax(zuiyou.bind,{'token':token,'pdu':pdu},function(data){
            $.removeCookie('auth-token');
            $.removeCookie('auth-pdu');
            console.log(data);
            alert("授权成功");
            window.location.href = '/dashboard';

        });
    }


    jq.ajax("https://gateway.zuiyou.bid/cmd",{'value':'SYSTEM_EXIT'},function(res){

    });
});