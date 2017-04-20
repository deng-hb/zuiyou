(function(){
    var config = document.getElementById('loader.js').getAttribute("config");
    if (!config){throw 'config error:' + config;}
    try {
        config = eval("(" + config + ")");
    } catch (e){
        throw 'config error:' + config;
    }


    var items = config.items;
    var base = config.base;
    if (!base){
        base = "";
    }
    // 循环添加
    var parentElement = document.getElementsByTagName('head')[0];
    if (!parentElement) {
        parentElement = document.getElementsByTagName('html')[0];
    }

    var element;
    for (var i = 0,len = items.length;i < len; i++){

        var item = items[i],url = base + item;
        if (-1 != item.lastIndexOf(".css")) {
            element = document.createElement('link');
            element.rel = "stylesheet";
            element.href = url;
        } else if (-1 != item.indexOf(".js")){
            // js
            element = document.createElement('script');
            element.src = url;
        } else {throw 'items `.js` or `.css`'}
        parentElement.appendChild(element);

    }
})();