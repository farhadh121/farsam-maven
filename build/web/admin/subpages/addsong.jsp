<%@page import="java.util.Iterator"%>
<%@page import="com.radio.entity.hibernate.GenreEntity"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.radio.svc.serviceinterface.IGenreServiceProvider"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<!-- Main row
<div class="row">   -->
<!-- Left col -->

<%{%>

<section class="col-lg-12 connectedSortable">
    <!-- Box (with bar chart) -->
        <div class="box-body no-padding">
            <div class="row">
                <!-- left column -->
                <div class="col-lg-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Add Song</h3>
                        </div>

                        <%
                            String msg = (String)request.getAttribute("msg");
                            String controller = (String)request.getAttribute("controller");
                            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                            IGenreServiceProvider genreServiceProvider = (IGenreServiceProvider)context.getBean( "genreFacade" );

                            System.out.println( controller );

                            if( controller != null && controller.equals("addsong") ){
                                if( msg != null && msg.equals("success") ){
                        %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Song Added Successfully!
                            </div>
                        <%
                                }else if( msg != null && msg.equals("failed") ){
                        %>
                            <div class="alert alert-danger alert-dismissable">
                                <i class="fa fa-ban"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Failed!</b>
                                <%=((String)request.getAttribute("msgbody")).toString()%>
                            </div>
                        <%
                                }
                            }
                        %>

                        <!-- /.box-header -->
                        <!-- form start -->
                        <form method="post" enctype="multipart/form-data" action="/addSongController.htm">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="songname">Song Name</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" name="songname"  id="songname" placeholder="Song Name">
                                        </div>
                                    </div>
                                </div>
                                <!-- adding more artist box-->
                                <script>
                                    <%@ include file="../../js/addinputbox.js" %>
                                </script>

                                <div class="form-group">

                                    <label for="artistname">Artist Name</label>
                                    <div class="row" >
                                        <div class="col-xs-3">
                                            <div class="input-group" id="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-male"></i>
                                                </div>

                                                <input type="text" class="form-control" name="artistname" id="artistname" placeholder="Artist Name "/>
                                                <span class="input-group-btn" id="addButton">
                                                    <button class="btn btn-info btn-flat" type="button" onclick="loadAdd()" href="#">Add!</button>
                                                </span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <input type="hidden" name="artistscount" value="1"/>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <div class="input-group" id="input-group-1">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-archive"></i>
                                                </div>
                                                <input type="text" class="form-control" name="albumname" id="albumname" placeholder="Album Name" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="uploadsong">Upload Song</label>
                                    <input class="btn btn-flat" type="file" name="uploadsong" id="uploadsong">

                                    <p class="help-block">By clicking upload you agree the terms and conditions</p>
                                </div>
                                <div class="form-group">
                                    <label for="uploadartwork">Upload Artwork</label>
                                    <input class="btn btn-flat" type="file" name="uploadartwork" id="uploadartwork">

                                    <p class="help-block">By clicking upload you agree the terms and conditions</p>
                                </div>
                                <!-- textarea -->
                                <div class="form-group">
                                    <label>Lyrics</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <textarea class="form-control" rows="3" name="lyrics" placeholder="Type the lyrics here..."></textarea>
                                        </div>
                                    </div>
                                </div>
                                <!-- select genre dropdown -->
                                <div class="form-group">
                                    <label>Genre</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <select class="form-control" name="genre">
                                                <%
                                                    List<GenreEntity> list = genreServiceProvider.getAllGenres();
                                                    Iterator itr = list.iterator();
                                                    while( itr.hasNext() ){
                                                        GenreEntity genreEntity = (GenreEntity)itr.next();
                                                %>
                                                    <option><%=genreEntity.getName()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                            <!-- /.box-body -->
                                <!-- add more features to song-->
                                <script>
                                    <%@ include file="../../js/addfeatureboxsong.js" %>
                                </script>

                                <label>Song Features</label>
                                <div class="row" id="input-group2">
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-key">
                                            </i>
                                        </span>
                                            <input type="text" class="form-control" name="songfeaturekey0"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-vimeo-square">
                                            </i>

                                        </span>
                                            <input type="text" class="form-control" name="songfeaturevalue0"/>
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="loadAddfeature()" href="#">+</button>
                                        </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary" name="submitsong">Submit</button>
                            </div>
                        </form>
                    </div>

                    <!-- /.box -->
                </div>
                <!--/.col-md-6-->

            </div>
            <!-- /.box -->
        </div>
</section><!-- /.Left col -->

<%}%>