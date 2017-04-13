<%@page import="com.radio.svc.controllers.common.SendEmail" %>

<section class="col-sm-3 lt">
    <section class="vbox">
        <section class="scrollable hover">
            <div id="container">
                <p class="heading">Contact Form</p>
                <form action="#" method="POST">
                    <div class="input">
                        <label for="fullname">Name:</label>
                        <input type="text" id="fullname" name="fullname" value="" />
                        <div id="fullname_warn" ></div>
                    </div>

                    <div class="input">
                        <label for="email" >Email:</label>
                        <input type="text" id="email" name="email" value="" />
                        <span id="email_warn" ></span>
                    </div>

                    <div class="input">
                        <label for="message" >Message:</label>
                        <textarea cols="10" rows="5" id="message" name="message"></textarea>
                    </div>

                    <input type="submit" name="send" value="send" id="send" />
                </form>

                <%
                    if (request.getParameter("fullname") != null) {
                        String fullname = request.getParameter("fullname");
                        String email = request.getParameter("email");
                        String message = request.getParameter("message");

                        if (com.radio.svc.controllers.common.SendEmail.run(email, fullname, message)) {
                %>
                <p class="goodtogo end">Mail Sent Successfully</p>
                <%            } else {
                %>
                <p class="warning end">Error Sending Mail</p>
                <%            }
                    }
                %>
                
            </div>
            <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
            <script type="text/javascript" src="assets/js/jscript.js"></script>
            <style>
                    div#container{
    max-width:578px;
    min-width:440px;
    border:1px solid #222;
    padding:20px;
    margin:100px auto;
    color:#222233;
    font-family:sans-serif;
    -moz-border-radius:20px;
}

p.heading{
    font-size:36px;
    font-weight:bold;
}

.input,#send{
    font-size:24px;
    margin-top:10px;
}

.input label{
    display:block;
    text-decoration:underline;
}

.input input, .input textarea{
    width:300px;
    padding:1px;
}

#send{
    font-size:16px;
    cursor:pointer;
    width:120px;
    height:50px;
}

.warning, .goodtogo{
    font-size:20px;
    padding-left:35px;
    width:225px;
    height:33px;
    float:right;
    clear:right;

}

.warning{
    background:transparent url(../images/warn.png) no-repeat -5px -33px scroll;
}

.goodtogo{
    background:transparent url(../images/warn.png) no-repeat 0px 0px scroll;
}

.end{
    position:relative;
    top:-40px;
}
                </style>
            <script>
                $(document).ready(function() {

    var fullname = $('#fullname');
    var fullname_warn = $('#fullname_warn');

    var email = $('#email');
    var email_warn = $('#email_warn');

    fullname.focus(function(){
        fullname_warn.removeClass('goodtogo');
        fullname_warn.addClass('warning');
        fullname_warn.html("Cannot be blank");

        fullname.blur(function(){
            fullname_warn.removeClass('warning');
            fullname_warn.addClass('goodtogo');
            fullname_warn.html("&nbsp;");
        });
    });

    email.focus(function(){
        email_warn.removeClass('goodtogo');
        email_warn.addClass('warning');
        email_warn.html("Cannot be blank");

        email.blur(function(){
            email_warn.removeClass('warning');
            email_warn.addClass('goodtogo');
            email_warn.html("&nbsp;");
        });
    });

});


            </script>    
        </section>
    </section>
</section>
                
