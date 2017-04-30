<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '新增规则'; require_once '../../../_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '../../../_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'rule'; require_once '../../../_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="row-content am-cf">

                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">新增规则</div>

                    </div>
                    <div class="widget-body am-fr">
                        <form id="rule-form" class="am-form " method="post" data-am-validator>
                            <div class="am-g am-margin-top">

                                <!--  -->
                                <div class="am-u-sm-2 am-text-right">
                                    <label for="doc-ipt-3-a" class="am-form-label">单笔金额：</label>
                                </div>
                                <div class="am-u-sm-4">
                                    <input id="doc-ipt-3-a" name="amount" type="number" class=" am-input-sm" placeholder="单笔金额"
                                           min="50" value="50" required/>
                                </div>
                                <!--  -->
                                <div class="am-u-sm-2 am-text-right">保留余额：</div>
                                <div class="am-u-sm-4">
                                    <input type="number" value="0" class=" am-input-sm" placeholder="保留余额" required/>
                                </div>
                            </div>

                            <div class="am-g am-margin-top">
                                <div class="am-u-sm-2 am-text-right">利率：</div>
                                <div class="am-u-sm-4">
                                    <div class="am-g">
                                        <div class="am-u-sm-5">
                                            <input type="number" name="rateMin" value="0" class=" am-input-sm" placeholder="最少"
                                                   required/>
                                        </div>
                                        <div class="am-u-sm-2">
                                            ～
                                        </div>
                                        <div class="am-u-sm-5">
                                            <input type="number" name="rateMax" value="36" class=" am-input-sm" placeholder="最大"
                                                   required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-u-sm-2 am-text-right">期限：</div>
                                <div class="am-u-sm-4">
                                    <div class="am-g">
                                        <div class="am-u-sm-5">
                                            <input type="number" name="limitMin" value="0" class=" am-input-sm" placeholder="最少"
                                                   required/>
                                        </div>
                                        <div class="am-u-sm-2">
                                            ～
                                        </div>
                                        <div class="am-u-sm-5">
                                            <input type="number" name="limitMax" value="24" class=" am-input-sm"
                                                   placeholder="最大" required/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-g am-margin-top">

                                <!-- 学历 -->
                                <div class="am-u-sm-2 am-text-right">级别：</div>
                                <div class="am-u-sm-4">
                                    <select multiple data-am-selected="{btnWidth: '100%', btnSize: 'sm'}" required>
                                        <option value="AAA" selected>AAA</option>
                                        <option value="AA" selected>AA</option>
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                        <option value="C">C</option>
                                        <option value="D">D</option>
                                        <option value="E">E</option>
                                        <option value="F">F</option>
                                    </select>
                                </div>

                                <!-- 性别 -->
                                <div class="am-u-sm-2 am-text-right">性别：</div>
                                <div class="am-u-sm-4">
                                    <label class="am-checkbox-inline">
                                        <input type="checkbox" value="1" data-am-ucheck checked name="sexIsMen" > 男
                                    </label>
                                    <label class="am-checkbox-inline">
                                        <input type="checkbox" value="1" data-am-ucheck checked name="sexIsWomen"> 女
                                    </label>
                                </div>
                            </div>
                            <div class="am-g am-margin-top">
                                <!-- 学历 -->
                                <div class="am-u-sm-2 am-text-right">学历：</div>

                                <div class="am-u-sm-4">
                                    <select multiple data-am-selected="{btnWidth: '100%', btnSize: 'sm'}" required>
                                        <option value="无" selected>无</option>
                                        <option value="高中">高中</option>
                                        <option value="大专">大专</option>
                                        <option value="本科">本科</option>
                                        <option value="研究生">研究生</option>
                                    </select>
                                </div>
                                <div class="am-u-sm-2 am-text-right">年龄：</div>
                                <div class="am-u-sm-4">
                                    <div class="am-g">
                                        <div class="am-u-sm-5">
                                            <input type="number" name="ageMin" value="18" class=" am-input-sm" placeholder="最少" required/>
                                        </div>
                                        <div class="am-u-sm-2">
                                            ～
                                        </div>
                                        <div class="am-u-sm-5">
                                            <input type="number" name="ageMax" value="60" class=" am-input-sm" placeholder="最大" required/>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="am-g am-margin-top">
                                <div class="am-u-sm-2 am-text-right">借款金额：</div>
                                <div class="am-u-sm-4">
                                    <div class="am-g">
                                        <div class="am-u-sm-5">
                                            <input type="number" name="loanAmountMin" value="10" class=" am-input-sm" placeholder="最少" required/>
                                        </div>
                                        <div class="am-u-sm-2">
                                            ～
                                        </div>
                                        <div class="am-u-sm-5">
                                            <input type="number" name="loanAmountMax" value="500000" class=" am-input-sm" placeholder="最大" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="am-u-sm-2 am-text-right">待还金额：</div>
                                <div class="am-u-sm-4">
                                    <div class="am-g">
                                        <div class="am-u-sm-5">
                                            <input type="number" name="waitRepayMin" value="0" class=" am-input-sm" placeholder="最少" required/>
                                        </div>
                                        <div class="am-u-sm-2">
                                            ～
                                        </div>
                                        <div class="am-u-sm-5">
                                            <input type="number" name="waitRepayMax" value="100000" class=" am-input-sm" placeholder="最大" required/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-g am-margin-top">
                                <div class="am-u-sm-2 am-text-right">&nbsp;</div>
                                <div class="am-u-sm-4 am-text-left">
                                    <button id="signup-submit" class="am-btn am-btn-primary am-btn-sm" type="submit"><span class="am-icon-save"></span> 保 存 </button>
                                </div>
                                <div class="am-u-sm-2"></div>
                                <div class="am-u-sm-4">
                                </div>
                            </div>

                            <div class="am-g am-margin-top">
                                <div class="am-u-sm-2 am-text-right"></div>
                                <div class="am-u-sm-4">
                                </div>
                                <div class="am-u-sm-2 am-text-right"></div>
                                <div class="am-u-sm-4">
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>

    </div>
    <?php require_once '../../../_/scripts.php' ?>
    <script>
       $(function(){
            /*
            var id = $.getUrlParam('id');
            jq.ajax(zuiyou.ruleQuery,{id:id},function(res){
                if(res.code){
                    var user = res.data;
                    $('#username').text(user.username);
                    // 表单赋值
                    var rule = res.data.rule;
                    for (var key in rule) {
                        var $el = $('[name="'+key+'"]');
                        if ($el) {
                            $el.val(rule[key]);
                        }
                    }
                }
            });
            */

            var $rule_form = $('#rule-form');
            $rule_form.attr('action',zuiyou.ruleCreate);
            jq.form($rule_form,function(){return true;},function(res){
                if (res.code){
                }
            })

        });
    </script>
</body>
</html>