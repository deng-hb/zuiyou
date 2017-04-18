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
        xhrFields: {withCredentials: true},
        beforeSubmit:function(formData, jqForm, options){
            var res = pre();
        	if(res){
        		// TODO 进度条
        	}else{
            	return res;
        	}
        },
        success:function(data){
			if(!jq.error(data)){
				success(data);
			}
		},
		error:function(xhr, textStatus, errorThrown){
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

	// ajax 执行
	$.ajax({
		type: "POST",
		url: url,
		data: params,
		dataType : 'json',
        xhrFields: {withCredentials: true},
		success: function(data){
			if(!jq.error(data)){
				success(data);
			}
			
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('服务器遇到错误，请稍候重试！');
		}
	});
};

// 错了返回true
jq.error = function(data){

	// 2 超时、3 没有权限
	if(2 == data.code || 3 == data.code){
		window.location.href = data.object;
		return true;
	}
	return false;
}
