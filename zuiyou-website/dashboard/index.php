<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '看板'; require_once '../_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '../_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'index'; require_once '../_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

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
                </div>
            </div>

            <div class="row-content am-cf">

                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">用户列表</div>

                    </div>
                    <div class="widget-body am-fr">
                       <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                           <div class="am-form-group">
                               <div class="am-btn-toolbar">
                                   <div class="am-btn-group am-btn-group-xs">
                                       <a href="https://ac.ppdai.com/oauth2/login?AppID=3d45717f69064d7ea54d1d3ea1d5c685&ReturnUrl=http://zuiyou.bid.denghb.com/" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</a>
                                   </div>
                               </div>
                           </div>
                       </div>
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
    <?php require_once '../_/scripts.php' ?>
    <script>
       $(function(){
            // 信息公开
            jq.ajax(zuiyou.data,{},function(res){
                $('#loan-count').text(res.loanCount);
                $('#pdu-count').text(res.pduCount);
                $('#loan-amount').text('¥'+res.totalAmount);
            });

            var $data_table = jq.table({
                url:zuiyou.userList,
                fields:["id","pdu","balance","status","createdTime"],
                columnDefs: [{
                     targets: 3,
                     createdCell: function (td, cellData, rowData, row, col) {
                         if (1 == cellData){
                            $(td).text('正常');
                         } else {
                            $(td).text('异常');

                         }
                     }
                },{
                    targets: 4,
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).html('<a href="">授权</a>');
                    }
                }]
            });

            // 定时检测登录状态
                setInterval(function() {
                    jq.ajax(zuiyou.session,{},function(res){});
                }, 30 * 1000);
        });
    </script>
</body>

</html>