<%@ page import="com.radio.svc.controllers.radio.EmailController" %>
<%@ page import="org.springframework.context.support.FileSystemXmlApplicationContext" %>
<%@ page import="org.springframework.beans.factory.BeanFactory" %>
<%@ page import="org.springframework.core.io.Resource" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.entity.hibernate.UserEntity" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8" />
    <title>Musik | Web Application</title>
    <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="../front/js/jPlayer/jplayer.flat.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/animate.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/simple-line-icons.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/font.css" type="text/css" />
    <link rel="stylesheet" href="../front/css/app.css" type="text/css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

    <!--[if lt IE 9]>
    <script src="../front/js/ie/html5shiv.js"></script>
    <script src="../front/js/ie/respond.min.js"></script>
    <script src="../front/js/ie/excanvas.js"></script>
    <![endif]-->
</head>
<body class="bg-info dker">
<!--      Mizhoo For messages Start      -->
<%
    String msg = (String)request.getAttribute("msg");
    String controller = (String)request.getAttribute("controller");
    if( controller != null && controller.equals("adduser") ){
        if( msg != null && msg.equals("success") ){
%>
<div class="alert alert-success alert-dismissable">
    <i class="fa fa-check"></i>
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
    <b>Success!</b>
    Your account was created Successfully! You will be directed to login page.
</div>
<script language="javascript">
   setTimeout(function() {
        window.location.assign(domain +'/radio/login.jsp');
    }, 3000);
    var email = document.getElementById('email');
    alert(email);
</script>
<%

    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
    EmailController emailController=(EmailController)context.getBean("emailController");
    String sender="info@taghcheh.com";//write here sender gmail id
    String receiver=request.getParameter("email");//write here receiver id
    emailController.sendMail(sender,receiver,"Your account has been created","Welcome," + " We are glad you are here!"+ "Your username is: "+request.getParameter("email")+"/n" +"Your password is: " +request.getParameter("password")+" Ahang Group");

    System.out.println("success");

}else if( msg != null && msg.equals("failed") ){
%>
<div class="alert alert-danger alert-dismissable">
    <i class="fa fa-ban"></i>
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
    <b>Failed!</b>
    <%=(request.getAttribute("msgbody")).toString()%>
</div>
<%
        }
    }
%>
<!--      Mizhoo For messages END      -->
<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
    <div class="container aside-xl">
        <a class="navbar-brand block" href="../front/index.jsp"><span class="h1 font-bold">Musik</span></a>
        <section class="m-b-lg">
            <header class="wrapper text-center">
                <strong>Sign up to find interesting things</strong>
            </header>
            <form action="/registerationController.htm" method="post">
                <div class="form-group">
                    <input placeholder="Name"  name="firstName" class="form-control rounded input-lg text-center no-border">
                </div>
                <div class="form-group">
                    <input placeholder="Last Name" name="lastName" class="form-control rounded input-lg text-center no-border">
                </div>
                <div class="form-group">
                    <input id='email' type="email" placeholder="Email" name="email" class="form-control rounded input-lg text-center no-border">
                </div>
                <div class="form-group">
                    <input type="text" name="dob"  value="Date of Birth" onfocus="(this.type='date')" onblur="(this.type='text')" class="form-control rounded input-lg text-center no-border"/>
                </div>
                    <div id = "likeLoader" style="display:none">
                        <img id = "picLoader" src = "../front/images/spinner.gif" style="margin-bottom: 30%;">
                    </div>

                <div class="form-group">
                    <input id='password' type="password" name="password"  placeholder="Password" class="form-control rounded input-lg text-center no-border"/>
                </div>
                <div class="form-group">
                    <input type="password" name="password2"  placeholder="Retype password" class="form-control rounded input-lg text-center no-border"/>
                </div>
                <div class="checkbox i-checks m-b">
                    <label class="m-l">
                        <%CommonFile commonFile = new CommonFile();%>
                        <input type="checkbox" checked=""><i></i> Agree the <a href=<%=commonFile.getDomain()%>"/front/privacypolicy.jsp" class="top_up"><u>terms and policy</u></a>
                    </label>
                </div>
                <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">Sign up</span></button>
                <div class="line line-dashed"></div>
                <p class="text-muted text-center"><small>Already have an account?</small></p>
                <a href="../radio/login.jsp" class="btn btn-lg btn-info btn-block btn-rounded">Sign in</a>
            </form>
        </section>
    </div>
</section>



<!--<div class="form-box" id="login-box" style="margin-top:4%">

    <div class="header">Register New Membership</div>
    <form action="/registerationController.htm" method="post">
        <div class="body bg-gray">
            <div class="form-group">
                <input type="text" name="firstName" class="form-control" placeholder="First name"/>
            </div>
            <div class="form-group">
                <input type="text" name="lastName" class="form-control" placeholder="Last name"/>
            </div>
            <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="Email"/>
            </div>
            <div class="form-group">
                <input type="date" name="dob" class="form-control" placeholder="Date of Birth"/>
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="Password"/>
            </div>
            <div class="form-group">
                <input type="password" name="password2" class="form-control" placeholder="Retype password"/>
            </div>
        </div>
        <div class="footer">

            <button type="submit" name="signup" class="btn bg-olive btn-block">Sign me up</button>

            <a href="login.html" class="text-center">I already have a membership</a>
        </div>
    </form>

    <div class="margin text-center">
        <span>Register using social networks</span>
        <br/>
        <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
        <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
        <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

    </div>
</div> -->


<!-- jQuery 2.0.2 -->
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
<!-- Bootstrap -->
<!--<script src="../js/bootstrap.min.js" type="text/javascript"></script>-->
        <!-- / footer -->
        <script src="../front/./js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../front/./js/bootstrap.js"></script>
        <!-- App -->
        <script src="../front/./js/app.js"></script>
        <script src="../front/./js/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="../front/./js/app.plugin.js"></script>
        <script type="text/javascript" src="../front/./js/jPlayer/jquery.jplayer.min.js"></script>
        <script type="text/javascript" src="../front/./js/jPlayer/add-on/jplayer.playlist.min.js"></script>
        <script type="text/javascript" src="../front/js/common.js"></script>

    </body>
</html>