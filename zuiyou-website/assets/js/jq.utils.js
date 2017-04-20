/**
 * <pre>
 * jQuery 简单封装，更方便使用
 * author : denghb.com 
 * date   : 2016-03-16 PM
 * version: 1.0
 * </pre>
 */
window.jq = {};
/**
 * @param selecter jQuery form 对象
 * @param pre 提交前执行的函数
 * @param success 成功后回调函数
 */
jq.form = function(select,pre,success){
	select.ajaxForm({
		dataType:'json',
		headers: {"X-Client": "don't touch me for website"},
        xhrFields: {withCredentials: true},
        beforeSubmit:function(formData, jqForm, options){
            var res = pre();
        	if(res){
        		// TODO 进度条
                $.AMUI.progress.start();
        	}
            return res;

        },
        success:function(res){
            $.AMUI.progress.done();
			if(!jq.error(res)){
				success(res);
			}
		},
		error:function(xhr, textStatus, errorThrown){
		    $.AMUI.progress.done();
			alert('服务器遇到错误，请稍候重试！');
		}
    });
};
/**
 * @param url 请求路径
 * @param params 参数
 * @param success 成功后回调函数
 */
jq.ajax = function(url,params,success){
	// 参数拼接随机数 防止缓存
	if(!params){
		params = {};
	}
	if(params._r){
		alert('r is internal paramter');
		return;
	}
	params._r = new Date().getTime();

    // TODO 进度条
    $.AMUI.progress.start();

	// ajax 执行
	$.ajax({
		type: "POST",
		url: url,
		data: params,
		dataType : 'json',
		headers: {"X-Client": "don't touch me for website"},
        xhrFields: {withCredentials: true},
		success: function(res){
            $.AMUI.progress.done();
			if(!jq.error(res)){
				success(res);
			}
			
		},
		error: function(xhr, textStatus, errorThrown) {
            $.AMUI.progress.done();
			alert('服务器遇到错误，请稍候重试！');
		}
	});
};

// 错了返回true
jq.error = function(res){

	// 2 超时、3 没有权限
	if(2 == res.code || 3 == res.code){
	    alert(res.msg);
		window.location.href = res.data;
		return true;
	}
	return false;
}

$.getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}