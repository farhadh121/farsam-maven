<header class="bg-black header header-md navbar navbar-fixed-top-xs">
    <div class="navbar-header aside bg-info nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
            <i class="icon-list"></i>
        </a>
        <a href="../front/index.jsp" class="navbar-brand text-lt">
            <i class="icon-earphones"></i>
            <img src="../front/images/GoodRadio.png" alt="." class="hide">
            <span class="hidden-nav-xs m-l-sm">Listen on...</span>
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
            <i class="icon-settings"></i>
        </a>
    </div>

    <!-- TODO: Temporarily it is off -->

    <!--
    <ul class="nav navbar-nav hidden-xs">
    <li>
        <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
            <i class="fa fa-indent text"></i>
            <i class="fa fa-dedent text-active"></i>
        </a>
    </li>
</ul>
    -->


    <div class="navbar-right ">
        <ul class="nav navbar-nav m-n hidden-xs nav-user user">

            <!--
            <li class="hidden-xs">
                <a href="#" class="dropdown-toggle lt" data-toggle="dropdown">
                    <i class="icon-bell"></i>
                    <span class="badge badge-sm up bg-danger count">2</span>
                </a>
                <section class="dropdown-menu aside-xl animated fadeInUp">
                    <section class="panel bg-white">
                        <div class="panel-heading b-light bg-light">
                            <strong>You have <span class="count">2</span> notifications</strong>
                        </div>
                        <div class="list-group list-group-alt">
                            <a href="#" class="media list-group-item">
                    <span class="pull-left thumb-sm">
                      <img src="./images/a0.png" alt="..." class="img-circle">
                    </span>
                    <span class="media-body block m-b-none">
                      Use awesome animate.css<br>
                      <small class="text-muted">10 minutes ago</small>
                    </span>
                            </a>
                            <a href="#" class="media list-group-item">
                    <span class="media-body block m-b-none">
                      1.0 initial released<br>
                      <small class="text-muted">1 hour ago</small>
                    </span>
                            </a>
                        </div>
                        <div class="panel-footer text-sm">
                            <a href="#" class="pull-right"><i class="fa fa-cog"></i></a>
                            <a href="#notes" data-toggle="class:show animated fadeInRight">See all the notifications</a>
                        </div>
                    </section>
                </section>
            </li>
            -->
            <%
                Authentication frontAuthentication = SecurityContextHolder.getContext().getAuthentication();
                if( !(frontAuthentication instanceof AnonymousAuthenticationToken) ){
                    //UserEntity currentLoggedInUser = (UserEntity)authentication.getPrincipal();
                    User frontUser = (User)frontAuthentication.getPrincipal();


            %>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle bg clear" data-toggle="dropdown">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">

                <!-- TODO: Here we place the default profile picture, until add profile picture support for the system -->
                <img src="./images/a3.png" alt="...">
              </span>
                    <%= frontUser.getUsername()%> <b class="caret"></b>
                </a>
                <%
                }else{
                %>
                <span>User<i class="caret"></i></span>
                <%
                    }
                %>
                <ul class="dropdown-menu animated fadeInRight">
                    <li>
                        <span class="arrow top"></span>
                        <a href="#">Settings</a>
                    </li>
                    <li>
                        <a href="./profile.jsp">Profile</a>
                    </li>
                    <!--<li>
                        <a href="#">
                            <span class="badge bg-danger pull-right">3</span>
                            Notifications
                        </a>
                    </li>
                    <li>
                        <a href="./docs.html">Help</a>
                    </li>    -->
                    <li class="divider"></li>
                    <li>
                        <a href="/perform_logout" class="btn btn-default btn-flat" >Sign out</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</header>