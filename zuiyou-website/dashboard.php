<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '看板'; require_once '_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'index'; require_once '_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 部件首页 <small>Amaze UI</small></div>
                        <p class="page-header-description">Amaze UI 含近 20 个 CSS 组件、20 余 JS 组件，更有多个包含不同主题的 Web 组件。</p>
                    </div>
                </div>
            </div>

            <div class="row-content am-cf">
                <div class="row  am-cf">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">借款信息数目</div>
                            </div>
                            <div class="widget-body am-fr">
                                <div class="am-fl">
                                    <div id="loan-count" class="widget-fluctuation-period-text">

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                        <div class="widget widget-primary am-cf">
                            <div class="widget-title am-fl">
                                <div class="widget-title am-fl">借款人信息数</div>
                            </div>
                            <div class="widget-body am-fr">
                                <div id="pdu-count" class="widget-statistic-value">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                        <div class="widget widget-purple am-cf">
                            <div class="widget-title am-fl">
                                <div class="widget-title am-fl">借款金额数</div>
                            </div>
                            <div class="widget-body am-fr">
                                <div id="loan-amount" class="widget-statistic-value">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="row-content am-cf">

                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">用户列表</div>

                    </div>
                    <div class="widget-body am-fr">

                        <table width="100%" class="am-table am-table-striped am-table-bordered am-table-compact am-text-nowrap" id="data-table">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>pdu</th>
                              <th>余额</th>
                              <th>状态</th>
                              <th>操作</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <?php require_once '_/scripts.php' ?>
    <script>
       $(function(){
            // 信息公开
            jq.ajax(zuiyou.data,{},function(res){
                $('#loan-count').text(res.loanCount);
                $('#pdu-count').text(res.pduCount);
                $('#loan-amount').text('¥'+res.totalAmount);
            });


            $('#data-table').DataTable({
              responsive: true,
              dom: 'ti'
            });
        });
    </script>
</body>

</html>