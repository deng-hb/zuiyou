<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '投标记录'; require_once '../../_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '../../_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'history'; require_once '../../_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="row-content am-cf">

                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">投标记录</div>

                    </div>
                    <div class="widget-body am-fr">

                        <table width="100%" class="am-table am-table-striped am-table-bordered am-table-compact am-text-nowrap" id="data-table">
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>借款信息</th>
                              <th>备注</th>
                              <th>操作时间</th>
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
                url:zuiyou.historyList,
                fields:["id","loanId","remarks","createdTime"],
                columnDefs: [{
                     targets: 1,
                     createdCell: function (td, cellData, rowData, row, col) {
                         if(cellData)
                             $(td).html('<a href="http://invest.ppdai.com/loan/info?id='+cellData+'" target="_blank" >'+cellData+'</a>');
                     }
                },{
                    targets: 3,
                    createdCell: function (td, cellData, rowData, row, col) {
                        if(cellData)
                        $(td).text(Common.Date.format(new Date(cellData),'yyyy-MM-dd HH:mm'));
                    }
                }]
            });

/*
            $data_table.on('order.dt search.dt', function () {
                $data_table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                    cell.innerHTML = i+1;
                });
            }).draw();
*/

        });
    </script>
</body>
</html>