<%@ page import="com.radio.entity.hibernate.ArtistEntity" %>
<%@ page import="com.radio.entity.hibernate.AlbumEntity" %>
<!-- Main row
<div class="row">   -->
<!-- Left col -->

<script src="../js/custom/editalbum.js"></script>

<% { %>
<section class="col-lg-12 connectedSortable">
    <!-- Box (with bar chart) -->
    <div class="box-body no-padding">
        <div class="row">
            <!-- left column -->
            <div class="col-lg-12">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Edit Album</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("editalbum") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Success!</b>
                        Album Edited Successfully!
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
                    <form role="form" method="post" action="/searchAlbumController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="albumname">Album Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="albumname" id="albumname" placeholder="Album Name">
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
                        AlbumEntity albumEntity = (AlbumEntity)request.getAttribute("albumobject");
                        if( albumEntity != null ){
                            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                    %>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th>Album ID</th>
                                <th>Album Name</th>
                                <th>Record Label Name</th>
                                <th>Album artist Name</th>
                                <th>Album Release Date</th>
                            </tr>
                            <tr>
                                <th>
                                    <div class="input-group margin">
                                        <%=albumEntity.getAlbumID()%>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editalbumname" id="editalbumname" value="<%=albumEntity.getName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editAlbumName(<%=albumEntity.getAlbumID()%>, document.getElementById('editalbumname').value);">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editalbumrecordlabel" id="editalbumrecordlabel" value="<%=albumEntity.getRecordLabelEntity().getName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editAlbumRecordLabel(<%=albumEntity.getAlbumID()%>, document.getElementById('editalbumrecordlabel').value)">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editalbumartist" id="editalbumartist" value="<%=((ArtistEntity)(albumEntity.getArtists().toArray()[0])).getArtistName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editAlbumArtist(<%=albumEntity.getAlbumID()%>, document.getElementById('editalbumartist').value)">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editalbumreleasedate" id="editalbumreleasedate" value="<%=formatter.format(albumEntity.getReleaseDate())%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editAlbumReleaseDate(<%=albumEntity.getAlbumID()%>, document.getElementById('editalbumreleasedate').value)">Change!</button>
                                        </span>
                                    </div>
                                </th>
                            </tr>

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
<% } %>