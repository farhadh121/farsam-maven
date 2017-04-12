<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IUserServiceProvider" %>
<%@ page import="com.radio.svc.serviceinterface.IStationServiceProvider" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.ImageFormat" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>
<%@ page import="com.radio.entity.hibernate.UserEntity" %>
<%@ page import="com.radio.entity.hibernate.StationEntity" %>
<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<% { %>
<%
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
    IUserServiceProvider userFacade = (IUserServiceProvider)context.getBean("userFacade");
    IStationServiceProvider stationFacade = (IStationServiceProvider)context.getBean("stationFacade");
    CommonFile commonFile = (CommonFile)context.getBean("commonFile");
    ImageFormat imageFormat = (ImageFormat)context.getBean("imageFormat");
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = null;

    if( !( authentication instanceof AnonymousAuthenticationToken) ){
        user = (User)authentication.getPrincipal();
    }

    UserEntity loggedInUser = userFacade.getUserByUsername( user.getUsername() );

    List<StationEntity> stations = null;

    try{
        stations = stationFacade.getAllStationsByUsername( loggedInUser.getEmail() );
    }catch (Exception e ){
        e.printStackTrace();
    }


%>
<section id="content">
    <section class="vbox">
        <section class="scrollable">
            <section class="hbox stretch">
                <aside class="aside-lg bg-light lter b-r">
                    <section class="vbox">
                        <section class="scrollable">
                            <div class="wrapper">
                                <div class="text-center m-b m-t">
                                    <a href="#" class="thumb-lg">
                                        <img src="images/a0.png" class="img-circle">
                                    </a>
                                    <div>
                                        <div class="h3 m-t-xs m-b-xs"><%=loggedInUser.getFirstName()%></div>
                                        <small class="text-muted"><i class="fa fa-map-marker"></i> London, UK</small>
                                    </div>
                                </div>
                                <!--
                                <div class="panel wrapper">
                                    <div class="row text-center">
                                        <div class="col-xs-6">
                                            <a href="#">
                                                <span class="m-b-xs h4 block">245</span>
                                                <small class="text-muted">Followers</small>
                                            </a>
                                        </div>
                                        <div class="col-xs-6">
                                            <a href="#">
                                                <span class="m-b-xs h4 block">55</span>
                                                <small class="text-muted">Following</small>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                -->
                                <!--
                                <div class="btn-group btn-group-justified m-b">
                                    <a class="btn btn-success btn-rounded" data-toggle="button">
                                        <span class="text">
                                            <i class="fa fa-eye"></i> Follow
                                        </span>
                                        <span class="text-active">
                                            <i class="fa fa-eye"></i> Following
                                        </span>
                                    </a>
                                    <a class="btn btn-dark btn-rounded">
                                        <i class="fa fa-comment-o"></i> Chat
                                    </a>
                                </div>
                                -->
                                <!--
                                <div>
                                    <small class="text-uc text-xs text-muted">about me</small>
                                    <p>Artist</p>
                                    <small class="text-uc text-xs text-muted">info</small>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin venenatis ipsum ac feugiat.</p>

                                    <div class="line"></div>
                                    <small class="text-uc text-xs text-muted">connection</small>
                                    <p class="m-t-sm">
                                        <a href="#" class="btn btn-rounded btn-twitter btn-icon"><i class="fa fa-twitter"></i></a>
                                        <a href="#" class="btn btn-rounded btn-facebook btn-icon"><i class="fa fa-facebook"></i></a>
                                        <a href="#" class="btn btn-rounded btn-gplus btn-icon"><i class="fa fa-google-plus"></i></a>
                                    </p>

                                </div>
                                -->
                            </div>
                        </section>
                    </section>
                </aside>
                <aside class="bg-white">
                    <section class="vbox">
                        <header class="header bg-light lt">
                            <ul class="nav nav-tabs nav-white">
                                <li class="active"><a href="#stations" data-toggle="tab">Stations</a></li>
                                <li class=""><a href="#info" data-toggle="tab">Information</a></li>
                                <!--
                                <li class=""><a href="#interaction" data-toggle="tab">Interaction</a></li>
                                -->
                            </ul>
                        </header>
                        <section class="scrollable">
                            <div class="tab-content">
                                <div class="tab-pane active" id="stations">
                                    <ul class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">

                                        <%
                                            Iterator itr = stations.iterator();
                                            while( itr.hasNext() ){

                                                StationEntity stationEntity = (StationEntity)itr.next();
                                        %>
                                        <li class="list-group-item" id="userstations" style="height: 3%">
                                            <a href="#"  class="thumb-sm pull-left m-r-sm">
                                                <img src="<%=commonFile.getDomain()+commonFile.getStationArtworkAlias()+commonFile.getSeparator()+stationEntity.getStationArtwork()%>" class="img-circle">
                                            </a>
                                            <a href="#" class="clear">
                                                <small class="pull-right" onclick="deleteStationForUser( '<%=stationEntity.getStationID()%>','<%=loggedInUser.getEmail()%>' );">Delete</small>
                                                <strong class="block"><%=stationEntity.getStationName()%></strong>
                                                <!-- <small>Wellcome and play this web application template ... </small> -->
                                            </a>
                                        </li>
                                        <%
                                            }
                                        %>
                                    </ul>
                                </div>

                                <div class="tab-pane" id="info">
                                    <div class="text-center wrapper">
                                        <section class="panel panel-default">
                                            <header class="panel-heading font-bold">
                                                Profile Information
                                            </header>
                                            <div class="panel-body">
                                                <form class="form-horizontal" method="post">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Username</label>
                                                        <div class="col-sm-7">
                                                            <input type="text" id="username" class="form-control rounded parsley-validated" data-type="email" data-required="true" placeholder="email" value="<%=loggedInUser.getEmail()%>">
                                                        </div>
                                                        <a hgref="#" class="btn btn-s-md btn-danger btn-rounded" onclick="editProfileUsername( <%=loggedInUser.getUserID()%>, document.getElementById('username').value );">Update!</a>
                                                    </div>
                                                    <div class="line line-dashed b-b line-lg pull-in"></div>

                                                    <!--

                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Birthday</label>
                                                        <div class="col-sm-7">
                                                            <input type="text" id="birthday" class="form-control rounded parsley-validated" data-type="dateIso" placeholder="YYYY-MM-DD" data-required="true" value="<%=loggedInUser.getBornDate()%>">
                                                        </div>
                                                        <a hgref="#" class="btn btn-s-md btn-danger btn-rounded" onclick="editProfileBirthday( <%=loggedInUser.getUserID()%>, document.getElementById('birthday') );">Update!</a>
                                                    </div>
                                                    <div class="line line-dashed b-b line-lg pull-in"></div>
                                                    -->
                                                    <%
                                                        java.text.SimpleDateFormat sdf =
                                                                new java.text.SimpleDateFormat("yyyy-MM-dd");
                                                        String loggedInUserDOB = sdf.format(loggedInUser.getBornDate());
                                                    %>
                                                    <!-- <div class="form-group">
                                                        <label class="col-sm-2 control-label">Birthday</label>
                                                        <div class="col-sm-7">
                                                            <input class="input-sm input-s datepicker-input form-control" size="16" type="text" value="<%=loggedInUserDOB%>" data-date-format="yyyy-mm-dd">
                                                        </div>
                                                        <a hgref="#" class="btn btn-s-md btn-danger btn-rounded" onclick="editProfileBirthday( <%=loggedInUser.getUserID()%>, document.getElementById('birthday') );">Update!</a>
                                                    </div>

                                                     -->


                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">First Name</label>
                                                        <div class="col-sm-7">
                                                            <input type="text" id="firstname" class="form-control rounded"  data-required="true" value="<%=loggedInUser.getFirstName()%>">
                                                        </div>
                                                        <a hgref="#" class="btn btn-s-md btn-danger btn-rounded" onclick="editProfileFirstName( <%=loggedInUser.getUserID()%>, document.getElementById('firstname').value );">Update!</a>
                                                    </div>
                                                    <div class="line line-dashed b-b line-lg pull-in"></div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Last Name</label>
                                                        <div class="col-sm-7">
                                                            <input type="text" id="lastname" class="form-control rounded"  data-required="true" value="<%=loggedInUser.getLastName()%>">
                                                        </div>
                                                        <a hgref="#" class="btn btn-s-md btn-danger btn-rounded" onclick="editProfileLastName( <%=loggedInUser.getUserID()%>, document.getElementById('lastname').value );">Update!</a>
                                                    </div>
                                                </form>
                                            </div>
                                        </section>
                                    </div>
                                </div>
                                <!-- Alert message-->
                                <div id="success">

                                </div>
                                <div class="tab-pane" id="interaction">
                                    <div class="text-center wrapper">
                                        <i class="fa fa-spinner fa fa-spin fa fa-large"></i>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </section>
                </aside>
            </section>
        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
</section>

<% } %>