<!DOCTYPE html>
<html lang="en">
<head>
    <?php $title = '规则'; require_once '_/head.php' ?>
</head>

<body class="theme-white">
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <?php require_once '_/header.php' ?>
        <!-- 侧边导航栏 -->
        <?php $active = 'rule'; require_once '_/sidebar.php' ?>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

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
            $('#data-table').DataTable({
              responsive: true,
              dom: 'ti'
            });
        });
    </script>
</body>
</html>