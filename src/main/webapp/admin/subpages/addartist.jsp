<% { %>
<!-- Main row
<div class="row">   -->
<!-- Left col -->
<section class="col-lg-12 connectedSortable">
    <!-- Box (with bar chart) -->
        <div class="box-body no-padding">
            <div class="row">
                <!-- left column -->
                <div class="col-lg-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Add Artist</h3>
                        </div>

                        <%
                            String msg = (String)request.getAttribute("msg");
                            String controller = (String)request.getAttribute("controller");

                            System.out.println( controller );

                            if( controller != null && controller.equals("addartist") ){
                                if( msg != null && msg.equals("success") ){
                        %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Artist Added Successfully!
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
                        <form method="post" enctype="multipart/form-data" action="/addArtistController.htm">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="artistname">Artist Name</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" name="artistname"  id="artistname" placeholder="Artist Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="artistupload">Artist Picture</label>
                                    <input class="btn btn-lg" type="file" name="artistupload" id="artistupload">
                                    <p class="help-block">By clicking upload you agree the terms and conditions</p>
                                </div>
                                <!-- add more features-->
                                <script>
                                    <%@ include file="../../js/addfeatureboxartist.js" %>
                                </script>
                                <label>Artist Features</label>
                                <div class="row" id="input-group2">
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-key">
                                                    </i>
                                                </span>
                                            <input type="text" class="form-control" name="featureartistkey0"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-vimeo-square">
                                                    </i>
                                                </span>
                                            <input type="text" class="form-control" name="featureartistvalue0"/>
                                            <span class="input-group-btn">
                                                <button class="btn btn-info btn-flat" type="button" onclick="loadAddfeature()">+</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <br/>
                                <!-- textarea -->
                                <div class="form-group">
                                    <label>Artist Information</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <textarea class="form-control" rows="3" name="artistinformation" placeholder="Type the artist info here..."></textarea>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary" name="submitartist">Submit</button>
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

<% } %>
