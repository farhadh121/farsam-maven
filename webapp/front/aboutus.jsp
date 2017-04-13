<!DOCTYPE html>
<html lang="en" class="app">
<%@ include file="subpages/head.jsp" %>
<body class="">
    <section class='vbox'>

    <!-- Top Bar-->
        <%@ include file="subpages/privacytopbar.jsp" %>
    <!-- /Top Bar-->


        <section class="hbox stretch">
            <!--left Nav-->
            <%@ include file="subpages/privacyleftbar.jsp"%>
            <!--/.left Nav-->
            <section id="content">
                <section class="hbox stretch">
                    <section>
                        <section class="vbox">
                            <!--Main content middle pane-->
                            <%@ include file="subpages/aboutusmain.jsp"%>
                        </section>
                    </section>
                </section>
            </section>

        </section>

    </section>

<%@ include file="subpages/javascript.jsp"%>

</body>
</html>