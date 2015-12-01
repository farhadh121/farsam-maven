<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <%@ include file="subpages/listenhead.jsp" %>
</head>
<body id="bodyWhole" class="">
<section class="vbox">
    <!-- Top Bar-->

    <!-- Top bar end-->
    <section>
        <section class="hbox stretch">
            <aside class="bg-black dk aside hidden-print" id="nav">
                <ul class="nav bg clearfix">
                    <li>
                        <a href="modal.html" data-toggle="ajaxModal" class="" >
                            <i class="fa fa-search text-success"></i>
                            <span class="font-bold" style="margin-left: 13%">Search</span>
                        </a>
                    </li>

                </ul>




                <!-- .aside -->
                <%@ include file="subpages/listenleftbar.jsp" %>
            </aside>
                <!-- /.aside -->
                <section id="content">
                    <section class="vbox">
                        <section class="w-f-md">
                            <section class="hbox stretch bg-black dker">
                                <%@ include file="subpages/listensideplaylist.jsp"%>
                                <!-- / side content -->
                                <!-- Middle section-->
                                <%@ include file="subpages/listenmiddlecontent.jsp"%>
                                <!-- / Middle section -->
                                <!-- right section-->
                                <%@ include file="subpages/listenrightcontent.jsp"%>
                                <!--/ right section-->
                            </section>
                        </section>
                        <%@include file="subpages/listenbottomplayer.jsp"%>
                    </section>
                    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
                </section>
        </section>
    </section>
</section>
<script src="js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.js"></script>
<!-- App -->

<script src="js/app.js"></script>
<script src="js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/app.plugin.js"></script>
<script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
<script type="text/javascript" src="js/jPlayer/demo.js"></script>
<script src="js/custom/search-ajax-listen.js"></script>
<script type="text/javascript" src="js/custom/like-ajax.js"></script>
<script type="text/javascript" src="js/custom/dislike-ajax.js"></script>
<!-- added for autocomplete-->
<script src="http://code.jquery.com/jquery-1.10.2.js">jQuery.noConflict()</script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js">jQuery.noConflict()</script>
<script src="js/jquery.min.js">jQuery.noConflict()</script>

</body>
</html>