<%@ page import="com.radio.svc.serviceinterface.IRecordLabelServiceProvider" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.entity.hibernate.RecordLabelEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
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
                            <h3 class="box-title">Add Album</h3>
                        </div>

                        <%
                            String msg = (String)request.getAttribute("msg");
                            String controller = (String)request.getAttribute("controller");

                            System.out.println( controller );

                            if( controller != null && controller.equals("addalbum") ){
                                if( msg != null && msg.equals("success") ){
                        %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Album Added Successfully!
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
                        <form method="post" enctype="multipart/form-data" action="/addAlbumController.htm">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="albumname">Album Name</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" name="albumname"  id="albumname" placeholder="Album Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!-- adding more artist box-->
                                    <script>
                                        <%@ include file="../../js/addinputbox.js" %>
                                    </script>
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
                                    <label for="albumupload">Album Artwork</label>
                                    <input class="btn btn-lg" type="file" name="albumupload" id="albumupload">
                                    <p class="help-block">By clicking upload you agree the terms and conditions</p>
                                </div>
                                <div class="form-group">
                                    <label for="recordlabelname">Record Label</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <select class="form-control" name="recordlabelname" id="recordlabelname">
                                                <option>None</option>
                                                <%
                                                    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                                    IRecordLabelServiceProvider recordLabelServiceProvider = ( IRecordLabelServiceProvider )context.getBean("recordLabelFacade");
                                                    List<RecordLabelEntity> list = recordLabelServiceProvider.getAllRecordLabels();
                                                    Iterator itr = list.iterator();
                                                    while( itr.hasNext() ){
                                                        RecordLabelEntity temp = (RecordLabelEntity)itr.next();
                                                %>
                                                    <option><%=temp.getName()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="recordlabelreleasedate">Release Date( MM/DD/YYYY )</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <div class="input-group">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" name="recordlabelreleasedate" id="recordlabelreleasedate" class="form-control focus.inputmask" data-inputmask="'alias': 'mm/dd/yyyy'" data-mask/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- add more features-->
                                <script>
                                    <%@ include file="../../js/addfeatureboxalbum.js" %>
                                </script>
                                <label>Album Features</label>
                                <div class="row" id="input-group2">
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-key">
                                                    </i>
                                                </span>
                                            <input type="text" class="form-control" name="albumfeaturekey0"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="fa fa-vimeo-square">
                                                    </i>
                                                </span>
                                            <input type="text" class="form-control" name="albumfeaturevalue0"/>
                                            <span class="input-group-btn" name="featurealbum">
                                                <button class="btn btn-info btn-flat" type="button" onclick="loadAddfeature()">+</button>
                                            </span>
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
