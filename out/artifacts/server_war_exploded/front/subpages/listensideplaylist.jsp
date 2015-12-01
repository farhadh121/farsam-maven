<!-- side content -->
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IUserServiceProvider" %>
<%@ page import="com.radio.svc.serviceinterface.IStationServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.StationEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="com.radio.entity.hibernate.UserEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.ImageFormat" %>
<%@ page import="com.radio.svc.facade.StationFacade" %>
<%@ page import = "java.util.*"%>
<%@ page import = "java.lang.*"%>
<%@ page import="com.radio.svc.serviceinterface.ISongServiceProvider" %>
<aside class="col-sm-5 no-padder" id="sidebar">
<section class="vbox animated fadeInUp">
<section class="scrollable">
<div class="m-t-n-xxs item pos-rlt">
    <div class="top text-right">
                        <span class="musicbar animate bg-success bg-empty inline m-r-lg m-t" style="width:25px;height:30px">
                          <span class="bar1 a3 lter"></span>
                          <span class="bar2 a5 lt"></span>
                          <span class="bar3 a1 bg"></span>
                          <span class="bar4 a4 dk"></span>
                          <span class="bar5 a2 dker"></span>
                        </span>
    </div>

    <%
        //FH added shit to the side so the picture will be the Station picture and name
        //This will get the station ID from URL
        String stationIdForPic = request.getParameter("stationid");
        //ParseInt the stationID
        int id = Integer.parseInt(stationIdForPic);
        WebApplicationContext sideContext = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        IUserServiceProvider sideUuserFacade = (IUserServiceProvider) sideContext.getBean("userFacade");
        IStationServiceProvider sideStationFacade = (IStationServiceProvider) sideContext.getBean("stationFacade");
        CommonFile sideCommonFile = (CommonFile) sideContext.getBean("commonFile");
        Authentication sideAuthentication = SecurityContextHolder.getContext().getAuthentication();
        User sideUser = null;


        if (!(sideAuthentication instanceof AnonymousAuthenticationToken)) {
            sideUser = (User) sideAuthentication.getPrincipal();
        }

        UserEntity sideLoggedInUser = sideUuserFacade.getUserByUsername(sideUser.getUsername());
        Long sideUserID = sideLoggedInUser.getUserID();
        String userName = sideLoggedInUser.getEmail();


        List<StationEntity> sideStationEntityList = sideStationFacade.getAllStationsByUsername(sideLoggedInUser.getEmail());

        Iterator sideItr = sideStationEntityList.iterator();
        while (sideItr.hasNext()) {

            StationEntity sideStation = (StationEntity) sideItr.next();
            //set the station ID according to URL
            if (sideStation.getStationID().equals((long) id)) {


    %>


    <div class="bottom gd bg-info wrapper-lg">
        <!--<span class="pull-right text-sm">101,400 <br>Followers</span> -->
        <span id="set-artist-name" class="h1 font-thin"></span>

    </div>

    <div class="pos-rlt">

            <div class="center text-center m-t-n">
                <div id = "likeLoader" style="display:none">
                    <img id = "picLoader" src = "images/spinner.gif" style="margin-bottom: 30%;">
                </div>
            </div>
        <div class="center text-center m-t-n">
            <div id = "pauseButton" style="display:none">
                <i class="icon-control-pause i-8x"></i>
            </div>
        </div>

        <img onclick="showPauseButton();" id="songArtworkSetter" class="img-full" src="<%=sideCommonFile.getDomain()+sideCommonFile.getStationArtworkAlias()+sideCommonFile.getSeparator()+sideStation.getStationArtwork()%>" alt="..." style="z-index: -1">

    </div>
        <script>
            function showPauseButton(){
                var myDiv = document.getElementById("pauseButton");

                var show = function(){
                    myDiv.style.display = "block";
                    setTimeout(hide, 1000);  // 5 seconds
                }

                var hide = function(){
                    myDiv.style.display = "none";
                }

                show();

            }
        </script>



    <!-- Like Dislike Button-->

        <div id="like-status" class="like-btn" onclick="passTheLikeButton();" style="background-color: #ffffff;">Like</div>
        <div class="dislike-btn" onclick="passTheDislikeButton();" style="background-color: #ffffff;"></div>
        <div class="share-btn">Share</div>
        <div class="stat-cnt">
            <div id="totalCount" class="rate-count">20</div>
            <div class="stat-bar">
                <div id="greenLine" class="bg-green" style="width:50%;"></div>
                <div id="redLine" class="bg-red" style="width:50%"></div>
            </div><!-- stat-bar -->
            <div id="dislikeCount" class="dislike-count fa fa-thumbs-o-down">10</div>
            <div id="likeCount" class="like-count fa fa-thumbs-o-up">20</div>

        </div>
    </div>

    <style>
        .tab-cnt{width: 600px; height:auto; min-height: 400px; margin: 40px auto; padding: 40px; background-color: #fafafa; border: #ccc 1px dotted; overflow: auto; }
        .bg-green{ background-color: #559900;}
        .bg-red{background-color: #c9231a;}
        .tab-cnt h1{font-size: 22px; font-family: arial; margin-bottom: 15px;}
        .tab-tr{
            width: 100%; height: 55px;
            border-bottom: #e6e6e6 1px solid; border-top: #e6e6e6 1px solid;
        }
        .like-btn, .dislike-btn{
            width: auto; height: 30px; padding: 0 15px 0 30px;
            float: left; margin-left: 10px; margin-top: 15px;
            cursor: pointer; color: #333333; font-size: 13px; line-height: 30px;
            border:#fff 1px solid;
            -webkit-border-radius: 2px;-moz-border-radius: 2px;border-radius: 2px; /* border radius */
        }
        .like-btn{background: url(images/like-ico.png) 5px 50% no-repeat; }
        .like-btn:hover, .like-h{
            background: url(images/like-ico-h.png) 5px 50% no-repeat; color: #0c6502;
            background-color: #f0f0f0;	border: #c6c6c6 1px solid;
        }
        .dislike-btn{background: url(images/dislike-ico.png) 50% 50% no-repeat; }
        .dislike-btn:hover, .dislike-h{
            background: url(images/dislike-ico-h.png) 50% 50% no-repeat;
            background-color: #f0f0f0;	border: #c6c6c6 1px solid;
        }

        .stat-cnt{ 	width: 120px; height: 60px; float: right;}
        .stat-bar{	width: 120px; height: 3px;	margin-bottom: 5px;}
        .rate-count{ font-size: 20px; color: #dcdcdc; text-align: right; font-weight: bold; }
        .stat-bar div{height: 3px; float: left;}
        .like-count{}
        .dislike-count{ margin-left: 15px;}
        .like-count, .dislike-count{
            width: auto; height: 18px;
            float: right;
            font-size: 12px; line-height: 18px; color: #666;
            margin-left: 2%;
            padding-left: 15px;
        }

        .share-btn{
            height: 52px; display: inline-block;
            float: left;  font-size: 13px; line-height: 55px;
            padding: 0 10px; margin-left: 30px;
            border-bottom: #fff 3px solid;
            cursor: pointer;
        }
        .share-btn:hover{ border-bottom: #c9231a 3px solid; }
        .share-cnt{
            height: 30px; padding: 20px 10px 10px 10px;
            border-bottom: #e6e6e6 1px solid; display: none;
        }
    </style>
    <input type="hidden" id="set-next-song-id">




<%

            break;
        }
    }
%>
<script>
    //This will return the logged in user that is used in JS/Custom/LikeUser.ajax
    function getUserID(){
        var userName = '<%=userName%>';
        return userName

    }
    //This function is being called in Demo.js after load song is completed




</script>



    <div class="pull-left m-6" style="margin-left: 2%;">

        <span id="set-artist-info" class="m-t"> </span>

    </div>


<!--
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Vestibulum id ligula porta</span>
            <span class="text-muted"> -- 04:15</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Praesent commodo cursus magna</span>
            <span class="text-muted"> -- 02:25</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Curabitur blandit tempus</span>
            <span class="text-muted"> -- 05:00</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Faucibus dolor auctor</span>
            <span class="text-muted"> -- 03:50</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Get lacinia odio sem nec elit cibus dolor auctor sed odio dui mollis ornare</span>
            <span class="text-muted"> -- 04:05</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Faucibus dolor auctor</span>
            <span class="text-muted"> -- 02:55</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Donec sed odio dui</span>
            <span class="text-muted"> -- 04:35</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Urna mollis ornare vel eu leo</span>
            <span class="text-muted"> -- 05:10</span>
        </div>
    </li>
    <li class="list-group-item">
        <div class="pull-right m-l">
            <a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>
            <a href="#"><i class="icon-plus"></i></a>
        </div>
        <a href="#" class="jp-play-me m-r-sm pull-left">
            <i class="icon-control-play text"></i>
            <i class="icon-control-pause text-active"></i>
        </a>
        <div class="clear text-ellipsis">
            <span>Vivamus sagittis lacus vel augue</span>
            <span class="text-muted"> -- 02:35</span>
        </div>
    </li>
</ul>

-->
</section>
</section>
</aside>