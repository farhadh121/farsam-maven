<%@ page import="com.radio.entity.hibernate.SongEntity" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.ISongServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.GenreEntity" %>
<!-- Main row
<div class="row">   -->
<!-- Left col -->
<% { %>

<script src="../js/custom/editsong.js"></script>

<section class="col-lg-12 connectedSortable">
    <!-- Box (with bar chart) -->
    <div class="box-body no-padding">
        <div class="row">
            <!-- left column -->
            <div class="col-lg-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Edit Song</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("editsong") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Success!</b>
                        Song Edited Successfully!
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
                    <form role="form" method="post" action="/searchSongController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="songname">Song Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="songname" id="songname" placeholder="Song Name">
                                    </div>
                                    <div class="col-xs-3">
                                        <button type="submit" name="submit" class="btn btn-success">Search</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->

                    </form>

                    <%
                        SongEntity songEntity = (SongEntity)request.getAttribute("songobject");
                        if( songEntity != null ){
                    %>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th>Song ID</th>
                                <th>Song Name</th>
                                <th>Song Album</th>
                                <th>Song Genre</th>
                                <th>Song Lyric</th>
                                <th>Song Artwork</th>
                            </tr>
                            <%
                                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                ISongServiceProvider songServiceProvider = (ISongServiceProvider)context.getBean("songFacede");
                            %>
                            <tr>
                                <th>
                                    <div class="input-group margin">
                                        <%=songEntity.getSongID()%>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editsongname" id="editsongname" value="<%=songEntity.getName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editSongName(<%=songEntity.getSongID()%>,document.getElementById('editsongname').value);">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editsongalbum" id="editsongalbum" value="<%=songEntity.getAlbum().getName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editSongAlbumName(<%=songEntity.getSongID()%>, document.getElementById('editsongalbum').value)">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editsonggenre" id="editsonggenre" value="<%=((GenreEntity)(songEntity.getGenres().toArray()[0])).getName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editSongGenreName(<%=songEntity.getSongID()%>, document.getElementById('editsonggenre').value)">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editsonglyric" id="editsonglyric" value="<%=songEntity.getLyric()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editSongLyric( <%=songEntity.getSongID()%>, document.getElementById('editsonglyric').value )">Change!</button>
                                        </span>
                                    </div>
                                </th>
                            </tr>

                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>

                    <%
                        }
                    %>

                </div>
                <!-- /.box -->
            </div>
            <!--/.col-md-6-->
        </div>
        <!-- /.box -->
    </div>
</section><!-- /.Left col -->