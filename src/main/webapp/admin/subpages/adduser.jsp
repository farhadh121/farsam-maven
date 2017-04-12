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
                        <h3 class="box-title">Add User</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("adduser") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                User Added Successfully!
                            </div>
                    <%
                            }else if( msg != null && msg.equals("failed") ){
                    %>
                            <div class="alert alert-danger alert-dismissable">
                                <i class="fa fa-ban"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Failed!</b>
                                <%=(request.getAttribute("msgbody")).toString()%>
                            </div>
                    <%
                            }
                        }
                    %>

                    <!-- /.box-header -->
                    <!-- form start -->
                    <form role="form" method="post" action="/addUserController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="email" id="email" placeholder="Email">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="borndate">Born Date</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="borndate" id="borndate" placeholder="MM/DD/YYYY">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="firstname">First Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="First Name">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname">Last Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last Name">
                                    </div>
                                </div>
                            </div>
                            <script>
                                <%@ include file="../../js/addrolebox.js" %>
                            </script>

                            <div class="form-group">
                                <label for="userrole0">Role</label>
                                <div class="row" >
                                    <div class="col-xs-3">
                                        <div class="input-group" id="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-male"></i>
                                            </div>

                                            <input type="text" class="form-control" name="userrole0" id="userrole0" placeholder="User Role "/>
                                                <span class="input-group-btn" id="addButton">
                                                    <button class="btn btn-info btn-flat" type="button" onclick="loadAdd()" href="#">Add!</button>
                                                </span>

                                        </div>
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