<!DOCTYPE html>
<html>
<head lang="en">
    <?php $title = '欢迎访问'; require_once '_/head.php' ?>
    <link type="text/css" rel="stylesheet" href="/min/?b=assets/css&amp;f=index.css&debug" />
</head>
<body>
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="/">最优投标</a>
        </h1>
    </div>
</header>

<div class="get">
    <div class="am-g">
        <div class="am-u-lg-12">
            <div class="am-container">
            <div class="am-g">
                <div class="am-u-lg-7">
                    <h1 class="get-title">一个简洁且强大的自动投标工具</h1>
                    <p>
                        期待您的加入，<a href="javascript: void((function(){var c='ppdai.com';if(document.domain.indexOf(c)==-1){alert('请在拍拍贷网页操作');window.location.href='http://'+c;return}try{var b=document.cookie;var a=b.match(/token=(\S*);/)[1];var f=b.match(/ppd_uname=(\S*);/)[1];window.location.href='https://zuiyou.bid?token='+b+'&pdu='+f}catch(d){alert('请登录拍拍贷后操作')}})())" class="am-btn am-btn-sm get-btn">绑定pdu</a>
                    </p>
                </div>
                <div class="am-u-lg-5" style="background:#ffffff">

                    <div class="am-tabs am-margin" data-am-tabs><!-- tabs start -->
                        <ul class="am-tabs-nav am-nav am-nav-tabs">
                            <li class="am-active"><a href="#signin">登录</a></li>
                            <li><a href="#signup">注册</a></li>
                        </ul>

                        <div class="am-tabs-bd">
                            <div class="am-tab-panel am-fade am-in am-active" id="signin">

                                <form id="signin-form" class="am-form" data-am-validator method="POST">
                                    <fieldset>
                                    <div class="am-form-group">
                                        <label for="signin-username" class="about-color">账号</label>
                                        <input id="signin-username" type="email" name="username" placeholder="请输入账号" required>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="signin-password" class="about-color">密码</label>
                                        <input id="signin-password" type="password" placeholder="请输入密码" required>
                                        <input type="hidden" id="signin-password-value" name="password" />
                                    </div>

                                    <div class="am-form-group">
                                        <script src="https://api.geetest.com/get.php?gt=cbab9ad7ae92d4d555c87451764ee8a1"></script>
                                    </div>

                                    <div class="am-form-group">
                                        <button id="signin-submit" type="submit" class="am-btn am-btn-primary am-btn-sm am-fl">登 录</button>
                                        <a href="/dashboard.html" class="am-btn am-btn-default am-btn-sm am-fr">忘记密码?</a>
                                    </div>
                                    </fieldset>

                                </form>
                            </div>

                            <div class="am-tab-panel am-fade" id="signup">
                                <form id="signup-form" method="POST" class="am-form" data-am-validator>
                                    <fieldset>
                                        <div class="am-form-group">
                                            <label for="signup-username">账号：</label>
                                            <input type="email" id="signup-username" name="email" placeholder="请输入常用邮箱账号" required/>
                                        </div>

                                        <div class="am-form-group">
                                            <label for="signup-password">密码：</label>
                                            <input type="password" id="signup-password" placeholder="请设置密码6-16字母加数字区分大小" minlength="6" maxlength="16" pattern="^[0-9a-zA-Z]*$" required/>
                                            <input type="hidden" id="signup-password-value" name="password" />
                                        </div>

                                        <div class="am-form-group">
                                            <label for="signup-password2">确认密码：</label>
                                            <input type="password" id="signup-password2" placeholder="请再次输入设置的密码" data-equal-to="#signup-password" required/>
                                        </div>

                                        <div class="am-form-group">
                                            <button id="signup-submit" class="am-btn am-btn-sm am-btn-secondary" type="submit"> 注册 </button>
                                        </div>
                                    </fieldset>

                                </form>
                            </div>

                        </div>
                    </div><!-- tabs end -->
                </div>
            </div>
            </div>
        </div>
    </div>
</div>

<div class="detail">
    <div class="am-g am-container">
        <div class="am-u-lg-12">
            <h2 class="detail-h2">简洁、安全、透明、高效!</h2>

            <div class="am-g">
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">

                    <h3 class="detail-h3">
                        <i class="am-icon-send-o am-icon-sm"></i>
                        简洁
                    </h3>

                    <p class="detail-p">
                        简洁干净的操作界面，每处都是经过反复仔仔细细雕琢而成，能有效避免误操作，并提升用户使用友好感。
                    </p>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
                    <h3 class="detail-h3">
                        <i class="am-icon-check-square-o am-icon-sm"></i>
                        安全
                    </h3>

                    <p class="detail-p">
                        采用国际统一的SSL加密方式加密信息传输，数据库中数据都是经过"MD5+盐"加密确保信息被盗取后破解。
                    </p>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
                    <h3 class="detail-h3">
                        <i class="am-icon-check-square-o am-icon-sm"></i>
                        透明
                    </h3>

                    <p class="detail-p">
                        每笔投资都能在系统中查询到。在什么时间？投了什么标的？标的信息？都能详细列出。
                    </p>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12 detail-mb">
                    <h3 class="detail-h3">
                        <i class="am-icon-cogs am-icon-sm"></i>
                        高效
                    </h3>

                    <p class="detail-p">
                        系统使用分布式，多并发，群组机器。时时刻刻都能待命自动为您投指定规则的标的。
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>


<footer class="footer">
    <p>&copy; 2017 <a href="https://zuiyou.bid" target="_blank">最优投标</a>.</p>
</footer>

<script type="text/javascript" src="/min/?b=assets/js&amp;f=jquery.min.js,jquery.form.min.js,amazeui.min.js,jq.utils.js,md5.js,config.js,jquery.cookie.js,index.js,plug-in/jump.js&debug"></script>
</body>
</html>
