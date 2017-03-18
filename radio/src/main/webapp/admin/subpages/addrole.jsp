<!-- Main row
<div class="row">   -->
<!-- Left col -->
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
                        <h3 class="box-title">Add Role</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("addrole") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Role Added Successfully!
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
                    <form role="form" method="post" action="/addRoleController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="rolename">Role Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="rolename" id="rolename" placeholder="Role Name">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" name="submit" class="btn btn-primary">Submit</button>
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