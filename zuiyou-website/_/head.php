    <?php
    $userAgent = $_SERVER['HTTP_USER_AGENT'];
    if(!empty($userAgent) && false == strpos($userAgent,'Chrome')){
    		echo '!Chrome';
    }

    ?>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><?php echo $title . ' | 最优投标' ?></title>
    <meta name="description" content="">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="icon" type="image/png" href="/assets/images/favicon.png" />
    <link rel="stylesheet" href="/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="/assets/css/app.css">

