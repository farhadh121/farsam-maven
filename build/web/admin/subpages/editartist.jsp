<%@ page import="com.radio.entity.hibernate.ArtistEntity" %>
<!-- Main row
<div class="row">   -->
<!-- Left col -->

<script src="../js/custom/editartist.js"></script>

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
                        <h3 class="box-title">Edit Artist</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("editartist") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Artist Edited Successfully!
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
                    <form role="form" method="post" action="/searchArtistController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="artistname">Artist Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="artistname" id="artistname" placeholder="Artist Name">
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
                        ArtistEntity artistEntity = (ArtistEntity)request.getAttribute("artistobject");
                        if( artistEntity == null )
                            System.out.print( "artist is empty!" );
                        if( artistEntity != null ){

                    %>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <th>Artist ID</th>
                                <th>Artist Name</th>
                                <th>Artist Information</th>
                            </tr>
                            <tr>
                                <th>
                                    <div class="input-group margin">
                                        <%=artistEntity.getArtistID()%>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editartistname" id="editartistname" value="<%=artistEntity.getArtistName()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editArtistName(<%=artistEntity.getArtistID()%>, document.getElementById('editartistname').value);">Change!</button>
                                        </span>
                                    </div>
                                </th>
                                <th>
                                    <div class="input-group margin">
                                        <input type="text" class="form-control" name="editartistinfo" id="editartistinfo" value="<%=artistEntity.getArtistInfo()%>">
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="editArtistInfo(<%=artistEntity.getArtistID()%>, document.getElementById('editartistinfo').value)">Change!</button>
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