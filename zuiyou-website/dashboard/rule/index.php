<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '投标规则'; require_once '../../_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '../../_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'rule'; require_once '../../_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="row-content am-cf">

                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">规则列表</div>

                    </div>
                    <div class="widget-body am-fr">

                       <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                           <div class="am-form-group">
                               <div class="am-btn-toolbar">
                                   <div class="am-btn-group am-btn-group-xs">
                                       <a href="/dashboard/rule/create" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</a>
                                   </div>
                               </div>
                           </div>
                       </div>
                        <table width="100%" class="am-table am-table-striped am-table-bordered am-table-compact am-text-nowrap" id="data-table">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>名称</th>
                              <th>投标金额</th>
                              <th>利率范围</th>
                              <th>借款周期</th>
                              <th>年龄范围</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <?php require_once '../../_/scripts.php' ?>
    <script>
       $(function(){
            var $data_table = jq.table({
                url:zuiyou.ruleList,
                fields:["id","name","amount","rateMin","limitMin","ageMin"],
                columnDefs: [{
                     targets: 3,
                     createdCell: function (td, cellData, rowData, row, col) {
                         $(td).text(rowData.rateMin+"%~"+rowData.rateMax+"%");
                      }
                },{
                     targets: 4,
                     createdCell: function (td, cellData, rowData, row, col) {
                         $(td).text(rowData.limitMin+"月~"+rowData.limitMax+"月");
                     }
                },{
                    targets: 5,
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).text(rowData.ageMin+"岁~"+rowData.ageMax+"岁");
                    }
                }]
             });
        });
    </script>
</body>
</html>