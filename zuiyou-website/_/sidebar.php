        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              管理员

                    <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
                <li class="sidebar-nav-link">
                    <a href="/dashboard" class="<?php echo $active == 'index'?'active':'' ?>">
                        <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/dashboard/rule" class="<?php echo $active == 'rule'?'active':'' ?>">
                        <i class="am-icon-calendar sidebar-nav-link-logo"></i> 投标规则
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/dashboard/history" class="<?php echo $active == 'history'?'active':'' ?>">
                        <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 投标记录
                    </a>
                </li>
            </ul>
        </div>