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
<%@ page import="java.text.ParseException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.radio.entity.hibernate.StationFeatureEntity" %>
<%@ page import="java.text.DateFormat" %>
<section class="col-sm-4 no-padder bg">
<section class="vbox">
<section class="scrollable hover">
<ul class="list-group list-group-lg no-bg auto m-b-none m-t-n-xxs">
<li class="list-group-item clearfix">
    <h3 class="font-thin m-b">Your Favorite Stations <span class="musicbar animate inline m-l-sm" style="width:20px;height:20px">
                    <span class="bar1 a1 bg-primary lter"></span>
                    <span class="bar2 a2 bg-info lt"></span>
                    <span class="bar3 a3 bg-success"></span>
                    <span class="bar4 a4 bg-warning dk"></span>
                    <span class="bar5 a5 bg-danger dker"></span>
                  </span></h3>
</li>




<%

    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
    IUserServiceProvider userFacade = (IUserServiceProvider)context.getBean("userFacade");
    IStationServiceProvider stationFacade = (IStationServiceProvider)context.getBean("stationFacade");
    CommonFile commonFile = (CommonFile)context.getBean("commonFile");
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = null;


    if( !( authentication instanceof AnonymousAuthenticationToken) ){
        user = (User)authentication.getPrincipal();
    }

    UserEntity loggedInUser = userFacade.getUserByUsername( user.getUsername() );


    List<StationEntity> stationEntityList = stationFacade.getAllStationsByUsername(loggedInUser.getEmail());

    Iterator itr = stationEntityList.iterator();

    while( itr.hasNext() ){

        StationEntity  station = (StationEntity)itr.next();

%>


<li class="list-group-item clearfix" onclick= "window.location.href = '<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"listen.jsp?"+"stationid="+station.getStationID()%>'">

    <a href="<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"listen.jsp?"+"stationid="+station.getStationID()%>" class="pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="<%=commonFile.getDomain()+commonFile.getStationArtworkAlias()+commonFile.getSeparator()+station.getStationArtwork()%>" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis"><%=station.getStationName()%></span>
        <!-- No candidate for this part right now. -->
        <%

            //String stationLastAccessDate = station.getLastAccessDate().toString();
            String stationLastAccessDate = station.getCreationDate().toString();

            SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfmt2= new SimpleDateFormat("dd-MMM");
            java.util.Date dDate = sdfmt1.parse( stationLastAccessDate );
            String strOutput = sdfmt2.format( dDate );


            String str = "salam";
            //Mizhoo
            Set<StationFeatureEntity> stationFeatureEntities = station.getFeatures();
            Iterator itr2 = stationFeatureEntities.iterator();
            while(itr2.hasNext()){
                StationFeatureEntity featureEntity = (StationFeatureEntity)itr2.next();
                str =featureEntity.getFeatureValue();
            }


        %>
        <small class="text-muted"><%=str%></small>
    </a>

</li>


<%
    }
%>

<!-- Here is not really wanted  -->
<!--
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a1.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Get lacinia odio sem nec elit</span>
        <small class="text-muted">by Filex</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a2.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Donec sed odio du</span>
        <small class="text-muted">by Dan Doorack</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a3.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Curabitur blandit tempu</span>
        <small class="text-muted">by Foxes</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a4.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Urna mollis ornare vel eu leo</span>
        <small class="text-muted">by Chris Fox</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a5.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Faucibus dolor auctor</span>
        <small class="text-muted">by Lauren Taylor</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a6.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Praesent commodo cursus magn</span>
        <small class="text-muted">by Chris Fox</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a7.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Vestibulum id</span>
        <small class="text-muted">by Milian</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a8.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Blandit tempu</span>
        <small class="text-muted">by Amanda Conlan</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a9.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Vestibulum ullamcorpe quis malesuada augue mco rpe</span>
        <small class="text-muted">by Dan Doorack</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a10.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Natis ipsum ac feugiat</span>
        <small class="text-muted">by Hamburg</small>
    </a>
</li>
<li class="list-group-item clearfix">
    <a href="#" class="jp-play-me pull-right m-t-sm m-l text-md">
        <i class="icon-control-play text"></i>
        <i class="icon-control-pause text-active"></i>
    </a>
    <a href="#" class="pull-left thumb-sm m-r">
        <img src="images/a0.png" alt="...">
    </a>
    <a class="clear" href="#">
        <span class="block text-ellipsis">Sec condimentum au</span>
        <small class="text-muted">by Amanda Conlan</small>
    </a>
</li>
-->
</ul>
</section>
</section>
</section>