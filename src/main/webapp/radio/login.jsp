<!DOCTYPE html>

<html lang="en" class="app">
<%@ include file="singin-header.jsp" %>

<body class="bg-info dker">
<section id="content" class="m-t-lg wrapper-md animated fadeInUp">
    <div class="container aside-xl">
        <a class="navbar-brand block" href="../front/index.jsp"><span class="h1 font-bold">Musik</span></a>
        <section class="m-b-lg">
            <header class="wrapper text-center">
                <strong>Sign in to get in touch</strong>
            </header>
            <form action="/perform_login" method="POST">
                <div class="form-group">
                    <input type="email" name="j_username" placeholder="Email" class="form-control rounded input-lg text-center no-border">
                </div>
                <div class="form-group">
                    <input type="password" name="j_password" placeholder="Password" class="form-control rounded input-lg text-center no-border">
                </div>
                <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">Sign in</span></button>
                <div class="text-center m-t m-b"><a href="#"><small>Forgot password?</small></a></div>
                <div class="line line-dashed"></div>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a href="register.jsp" class="btn btn-lg btn-info btn-block rounded">Create an account</a>
            </form>
            <!-- Facebook authetication-->
            <div id="fb-root"></div>
            <a onclick="Login();" class="btn btn-rounded btn-sm btn-primary" style="margin-top: 5%; float: right; margin-right:38%;"><i class="fa fa-fw fa-facebook"></i> Facebook</a>
            <div id="status"></div>
            <br/><br/><br/><br/><br/>
           <!-- <div id="message">
                Logs:<br/>
            </div>-->
        </section>
    </div>
</section>
<!-- footer -->
<footer id="footer">
    <div class="text-center padder">
        <p>
            <small>Web app framework base on Bootstrap<br>© 2014</small>
        </p>
    </div>
</footer>
<!-- / footer -->
<script src="../front/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../front/js/bootstrap.js"></script>
<!-- App -->
<script src="../front/js/app.js"></script>
<script src="../front/js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="../front/js/app.plugin.js"></script>
<script type="text/javascript" src="../front/js/jPlayer/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="../front/js/jPlayer/add-on/jplayer.playlist.min.js"></script>


</body>



<!--    <div class="form-box" id="login-box">
        <div class="header">Sign In</div>
        <form action="/perform_login" method="POST">
            <div class="body bg-gray">
                <div class="form-group">
                    <input type="text" name="j_username" class="form-control" placeholder="User Name" value=""/>
                </div>
                <div class="form-group">
                    <input type="password" name="j_password" class="form-control" placeholder="Password"/>
                </div>
                <div class="form-group">
                    <input type="checkbox" name="remember_me"/> Remember me
                </div>
            </div>
            <div class="footer">
                <button type="submit" name="submit" value="submit" class="btn bg-olive btn-block">Sign me in</button>

                <p><a href="#">I forgot my password</a></p>

                <a href="register.jsp" class="text-center">Register a new membership</a>
            </div>
        </form>

        <div class="margin text-center">
            <span>Sign in using social networks</span>
            <br/>
            <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
            <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
            <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

        </div>
    </div>

         -->
<!-- jQuery 2.0.2 -->
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
<!-- Bootstrap -->
<!--<script src="../../js/bootstrap.min.js" type="text/javascript"></script> -->

<!-- </body> -->
</html>