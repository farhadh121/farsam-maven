<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.facade.UserFacade" %>
<%@ page import="com.radio.svc.serviceinterface.IUserServiceProvider" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>
<%@ page import="com.radio.svc.serviceinterface.IStationServiceProvider" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.ImageFormat" %>
<%@ page import="com.radio.svc.serviceinterface.ISongServiceProvider" %>
<%@ page import="com.radio.svc.logic.SongLogic" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.util.*" %>
<%@ page import="com.radio.svc.exceptions.*" %>
<%@ page import="com.radio.entity.hibernate.*" %>


<section class="scrollable padder-lg w-f-md" id="bjax-target">

<form class="input-s-lg m-t m-l-n-xs" role="search" method="post" enctype="multipart/form-data" action="#">
    <h2>Search :</h2>
    <div class="form-group">
        <div class="input-group">

            <input style=" border: 5px solid ThreeDDarkShadow; width: 60%; height: 6%;" class="col-lg-4" id="searchbar" type="text" autocomplete="false"  autofocus="true" placeholder="Search songs, albums..." oninput="getSearchCandidates();">
            <div id='results' class="ac_results"></div>
        </div>

        <style>
                /* highlight results */
                /* CSS Document */


            .ui-menu-item > a.ui-corner-all {
                display: block;
                padding: 3px 15px;
                clear: both;
                font-weight: normal;
                line-height: 18px;
                color: #555555;
                white-space: nowrap;
                text-decoration: none;
            }



                /* loading - the AJAX indicator */
            .ui-autocomplete-loading {
                background: white url('../img/ajax-loader.gif') right center no-repeat;
            }

                /* scroll results */
            .ui-autocomplete {
                max-height: 500px;
                overflow-y: auto;
                /* prevent horizontal scrollbar */
                overflow-x: hidden;
                /* add padding for vertical scrollbar */
                padding-right: 5px;
            }




            .ui-autocomplete li {
                font-size: 16px;
                display: block;
            }

            #image-prop {

                height: 50px;
                width: 50px;
            }
            .ui-state-focus
            {
                color:White;
                background:#96B202;
                outline:none;
                display:block
            }
            #results{
                width:980px;
                margin:0 auto;
                text-align:center;
            }

                /* The Form*/


            #searchbar{
                font:17px Tahoma, Arial, Helvetica, sans-serif;
                padding:4px 7px;
                border:1px solid #ffffff;
                background-color: #ffffff;
                width:350px;
                vertical-align:middle;
                color:#3c3c3c;
            }

            input:focus {
                outline: none;
            }

                /* CSS Document */
            .ac_results{overflow:hidden;z-index:99999;margin:0;padding:0;}
            .ac_results ul{list-style-position:outside;list-style:none;background:#f5f5f5;margin:0;padding:5px 10px 10px}
            .ac_results li{cursor:pointer;display:block;overflow:auto;margin:0;padding:0;border-top:1px solid #e1e1e1;}
            .ac_results li:first-child{border:0;}
            .ac_loading{background-image:url(./images/loading.gif);background-position:97% center;background-repeat:no-repeat;}
            .ac_over{background-color:#FFFFF0;color:#fb0}
            .ac_over a:hover{color:#000}
            .ac_results li a{display:block; overflow:auto; padding:10px; color:#2c2c2c;}
            .ac_results li a img{width:80px; height:auto; max-height:80px;float:left; margin-right:15px;}



                /* Styling for Autocomplete */



                /* IE 6 doesn't support max-height
                * we use height instead, but this forces the menu to always be this tall
                */
            * html .ui-autocomplete {
                height: 250px;
            }
        </style>

    </div>

</form>
    
<!-- TODO: Refresh button is temporarily off -->
<!--
<a href="#" class="pull-right text-muted m-t-lg" data-toggle="class:fa-spin" ><i class="icon-refresh i-lg  inline" id="refresh"></i></a>
-->
<div id="error"></div>
<p>
    <a href="/front/mylike.jsp" class="btn btn-default btn-warning btn-app"><i class="fa icon-heart pull-right"></i>Favorite Songs Playlist</a>
    
</p>
<h2 class="font-thin m-b">Your Favorite Stations <span class="musicbar animate inline m-l-sm" style="width:20px;height:20px">
                    <span class="bar1 a1 bg-primary lter"></span>
                    <span class="bar2 a2 bg-info lt"></span>
                    <span class="bar3 a3 bg-success"></span>
                    <span class="bar4 a4 bg-warning dk"></span>
                    <span class="bar5 a5 bg-danger dker"></span>
                  </span></h2>


<!-- Here I'm going to write a java code which loads all stations related to the user who is logged in now! -->

<div class="row row-sm">

    <%

        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
        IUserServiceProvider userFacade = (IUserServiceProvider)context.getBean("userFacade");
        ISongServiceProvider songFacade = (ISongServiceProvider)context.getBean("songFacede");
        ISongServiceProvider songServiceProvider;
        IStationServiceProvider stationFacade = (IStationServiceProvider)context.getBean("stationFacade");
        CommonFile commonFile = (CommonFile)context.getBean("commonFile");
        ImageFormat imageFormat = (ImageFormat)context.getBean("imageFormat");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;

        if( !( authentication instanceof AnonymousAuthenticationToken) ){
            user = (User)authentication.getPrincipal();
        }

        UserEntity loggedInUser = userFacade.getUserByUsername( user.getUsername() );

        List<StationEntity> stations = null;//new ArrayList<StationEntity>();
        List<SongEntity> topSongs = null;

        try{
            stations = stationFacade.getAllStationsByUsername( loggedInUser.getEmail() );
            topSongs = songFacade.getTopSongs();
        }catch (Exception e ){
            e.printStackTrace();
        }


        if (stations!= null && stations.size()!=0){

            Iterator itr = stations.iterator();
            while( itr.hasNext() ){

                StationEntity stationEntity = (StationEntity)itr.next();


    %>
    
    <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
        <div class="item" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"listen.jsp?"+"stationid="+stationEntity.getStationID()%>'" >
            <div class="pos-rlt">
                <a href="#"><img src="<%=commonFile.getDomain()+commonFile.getStationArtworkAlias()+commonFile.getSeparator()+stationEntity.getStationArtwork()%>" alt="" class="r r-2x img-full"></a>
                <div class="item-overlay opacity r r-2x bg-black">
                    <div class="center text-center m-t-n">
                        <i class="icon-control-play i-2x"></i>
                    </div>
                </div>
            </div>
            <div class="padder-v">
                <a href="#" class="text-ellipsis text-xs text-muted"><%=stationEntity.getStationName()%></a>
            </div>
        </div>
    </div>

    <%
            }
        }

    %>
</div>
<script>
    //This will return the logged in user that is used in JS/Custom/LikeUser.ajax
    function getUserID(){
        var userName = '<%=loggedInUser.getEmail()%>';
        return userName

    }
    //This function is being called in Demo.js after load song is completed
</script>
<!--
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black active">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#" data-toggle="class">
                        <i class="icon-control-play i-2x text"></i>
                        <i class="icon-control-pause i-2x text-active"></i>
                    </a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right active" data-toggle="class">
                        <i class="fa fa-heart-o text"></i>
                        <i class="fa fa-heart text-active text-danger"></i>
                    </a>
                    <a href="#" data-toggle="class">
                        <i class="fa fa-plus-circle text"></i>
                        <i class="fa fa-check-circle text-active text-info"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p2.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Vivamus vel tincidunt libero</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Lauren Taylor</a>
        </div>
    </div>
</div>
<div class="clearfix visible-xs"></div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p3.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Morbi id neque quam liquam sollicitudin</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Allen JH</a>
        </div>
    </div>
</div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <div class="top">
                            <span class="pull-right m-t-n-xs m-r-sm text-white">
                              <i class="fa fa-bookmark i-lg"></i>
                            </span>
            </div>
            <a href="#"><img src="images/p4.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Tincidunt libero</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Amanda Conlan</a>
        </div>
    </div>
</div>
<div class="clearfix visible-xs"></div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p5.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Fermentum diam</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Nisa Colen</a>
        </div>
    </div>
</div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="top">
                <span class="pull-right m-t-sm m-r-sm badge bg-info">6</span>
            </div>
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p6.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Habitant</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Dan Doorack</a>
        </div>
    </div>
</div>
<div class="clearfix visible-xs"></div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <div class="top">
                <span class="pull-right m-t-sm m-r-sm badge bg-white">12</span>
            </div>
            <a href="#"><img src="images/p7.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Vivamus vel tincidunt libero</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Ligula H</a>
        </div>
    </div>
</div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p8.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Aliquam sollicitudin venenati</a>
            <a href="#" class="text-ellipsis text-xs text-muted">James East</a>
        </div>
    </div>
</div>
<div class="clearfix visible-xs"></div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p9.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Lementum ligula vitae</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Lauren Taylor</a>
        </div>
    </div>
</div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay r r-2x bg-light dker active">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#" data-toggle="class" class="active">
                        <i class="icon-control-play i-2x text"></i>
                        <i class="icon-control-pause i-2x text-active"></i>
                    </a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right" data-toggle="class">
                        <i class="fa fa-heart-o text"></i>
                        <i class="fa fa-heart text-active text-danger"></i>
                    </a>
                    <a href="#" class="active" data-toggle="class">
                        <i class="fa fa-plus-circle text"></i>
                        <i class="fa fa-check-circle text-active text-info"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p10.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Egestas dui nec fermentum </a>
            <a href="#" class="text-ellipsis text-xs text-muted">Chris Fox</a>
        </div>
    </div>
</div>
<div class="clearfix visible-xs"></div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p11.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Aliquam sollicitudin venenatis ipsum</a>
            <a href="#" class="text-ellipsis text-xs text-muted">Jack Jason</a>
        </div>
    </div>
</div>
<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
    <div class="item">
        <div class="pos-rlt">
            <div class="item-overlay opacity r r-2x bg-black">
                <div class="text-info padder m-t-sm text-sm">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o text-muted"></i>
                </div>
                <div class="center text-center m-t-n">
                    <a href="#"><i class="icon-control-play i-2x"></i></a>
                </div>
                <div class="bottom padder m-b-sm">
                    <a href="#" class="pull-right">
                        <i class="fa fa-heart-o"></i>
                    </a>
                    <a href="#">
                        <i class="fa fa-plus-circle"></i>
                    </a>
                </div>
            </div>
            <a href="#"><img src="images/p12.jpg" alt="" class="r r-2x img-full"></a>
        </div>
        <div class="padder-v">
            <a href="#" class="text-ellipsis">Vestibulum ullamcorper</a>
            <a href="#" class="text-ellipsis text-xs text-muted">MM &amp; DD</a>
        </div>
    </div>
</div>

</div>-->


<!-- TODO: definitely we need this section in the future, but not now -->
<hr>
<div class="row">
    <div class="col-md-7">
        <h3 class="font-thin">Feeling Lucky?</h3>
        <div class="row row-sm">
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"6/8"+" "+"Dance"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa fa-glass i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/party.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Party</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">6/8</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Fusion"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa fa-tint i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/fusion.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">New Age</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Fusion</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Slow"+" "+"Pop"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa icon-cup i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/slowpop.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Relaxing</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Slow Pop</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Rap"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa fa-music i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/rap.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Rap</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Hip Hop & Rap</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Traditional"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa icon-flag i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/traditional.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Traditional</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Persian Traditional music</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    
                        <div class="pos-rlt">
                            <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Electronic"%>'">
                                <div class="item-overlay opacity r r-2x bg-black">
                                    <div class="center text-center m-t-n">
                                        <i class="fa icon-energy i-2x" ></i>
                                    </div>
                                </div>
                            </a>
                            <a href="#"><img src="images/house.jpg" alt="" class="r r-2x img-full"></a>
                        </div>
						<div class="padder-v">
							<a href="#" class="text-ellipsis">Active</a>
							<a href="#" class="text-ellipsis text-xs text-muted">Electronics</a>
						</div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Classic"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa icon-diamond i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/classic.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Classical</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Classic Music</a>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div class="item">
                    <div class="pos-rlt">
                        <a href="#" onclick= "window.location.href ='<%=commonFile.getDomain()+commonFile.getSeparator()+"front"+commonFile.getSeparator()+"picklisten.jsp?"+"genre=Persian"+" "+"Pop"%>'">
                            <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                    <i class="fa fa-play-circle i-2x" ></i>
                                </div>
                            </div>
                        </a>
                        <a href="#"><img src="images/pop.jpg" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                        <a href="#" class="text-ellipsis">Pop Culture</a>
                        <a href="#" class="text-ellipsis text-xs text-muted">Pop Music</a>
                    </div>
                </div>
            </div>
        </div>
    </div>








<!-- TODO: Temporarily commented, but maybe useful in the future. -->
<!--
<div class="row m-t-lg m-b-lg">
   <div class="col-sm-6">
       <div class="bg-primary wrapper-md r">
           <a href="#">
               <span class="h4 m-b-xs block"><i class=" icon-user-follow i-lg"></i> Login or Create account</span>
               <span class="text-muted">Save and share your playlist with your friends when you log in or create an account.</span>
           </a>
       </div>
   </div>
   <div class="col-sm-6">
       <div class="bg-black wrapper-md r">
           <a href="#">
               <span class="h4 m-b-xs block"><i class="icon-cloud-download i-lg"></i> Download our app</span>
               <span class="text-muted">Get the apps for desktop and mobile to start listening music at anywhere and anytime.</span>
           </a>
       </div>
   </div>
</div>
-->


<% if ( topSongs!= null && topSongs.size()!=0){
%>

<div class="col-md-5">
    <h3 class="font-thin">Top Songs</h3>
    <div class="list-group bg-white list-group-lg no-bg auto">
        <%
            Iterator itr2 = topSongs.iterator();
            int counter = 1;
            while( itr2.hasNext() ){
                SongEntity songEntity  =(SongEntity)itr2.next();
                String s = commonFile.getDomain()+commonFile.getSongArtworksAlias()+commonFile.getSeparator()+songEntity.getArtworkPath();
                String path = commonFile.getDomain() + "/song-artwork/" + songEntity.getArtworkPath(); //commonFile.getDomain()+commonFile.getStationArtworkAlias()+commonFile.getSeparator()+songEntity.getArtworkPath();
                String artistNames = songEntity.getArtworkPath().substring(songEntity.getArtworkPath().indexOf("-") + 1);
                artistNames = artistNames.substring(0, artistNames.indexOf("."));
				//String songId = songEntity.getSongID();

        %>
		<style>
		a.kinda-link:hover { cursor: pointer;
			
			}
		
		</style>
        <a class="list-group-item clearfix kinda-link" onclick="createStation( {'name':'<%=songEntity.getName()%>', 'type':'song', 'id':'<%=songEntity.getSongID()%>', 'lyrics' : '<%=songEntity.getLyric()%>' } );">
            
			<span class="pull-right h2 text-muted m-l"><%=counter%></span>
                          <span class="pull-left thumb-sm avatar m-r">
                            <img src="<%=path%>" alt="...">
                          </span>
                          <span class="clear">
                            <span><%=songEntity.getName()%></span>
                            <small class="text-muted clear text-ellipsis"><%=artistNames%></small>
                          </span>
        </a>
        <%
                counter++;
            }
        %>
    </div>
</div>

<%
    }
%>

</div>
</section>