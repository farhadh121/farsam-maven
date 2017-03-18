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
                            <h3 class="box-title">Add Record Label</h3>
                        </div>
                        <%
                           String msg = (String)request.getAttribute("msg");
                           String controller = (String)request.getAttribute("controller");
                           if( controller != null && controller.equals("addrecordlabel") ){
                               if( msg != null && msg.equals("success") ){
                       %>
                               <div class="alert alert-success alert-dismissable">
                                   <i class="fa fa-check"></i>
                                   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                   <b>Success!</b>
                                   Record Label Added Successfully!
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
                        <form method="post" enctype="multipart/form-data" action="/addRecordLabelController.htm">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="recordlabelname">Record Label Name</label>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <input type="text" class="form-control" name="recordlabelname"  id="recordlabelname" placeholder="Record Label Name">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="recordlabelupload">Record Label Picture</label>
                                    <input class="btn btn-lg" type="file" name="recordlabelupload" id="recordlabelupload">
                                    <p class="help-block">By clicking upload you agree the terms and conditions</p>
                                </div>



                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary" name="submitrecordlabel">Submit</button>
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
