<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IStationServiceProvider" %>
<%@ page import="com.radio.svc.serviceinterface.IRecordLabelServiceProvider" %>
<%@ page import="com.radio.svc.serviceinterface.IUserServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
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
                        <h3 class="box-title">Add Station</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                        IStationServiceProvider stationServiceProvider = (IStationServiceProvider)context.getBean( "stationFacade" );

                        System.out.println( controller );

                        if( controller != null && controller.equals("addstation") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Success!</b>
                        Station Added Successfully!
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
                    <form method="post" method="post" action="/addStationController.htm">
                        <div class="box-body">
                            <!-- adding more artist box-->

                            <div class="form-group">
                                <label for="username">User names</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <select class="form-control" name="username" id="username">
                                            <option>None</option>
                                            <%
                                                IUserServiceProvider userServiceProvider = ( IUserServiceProvider )context.getBean("userFacade");
                                                List<UserEntity> list = userServiceProvider.getAllUsers();
                                                Iterator itr = list.iterator();
                                                while( itr.hasNext() ){
                                                    UserEntity temp = (UserEntity)itr.next();
                                            %>
                                            <option><%=temp.getEmail()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="stationname">Station Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="stationname" id="stationname">
                                    </div>
                                </div>
                            </div>


                            <!-- /.box-body -->
                            <!-- add more features to song-->
                            <script>
                                <%@ include file="../../js/addfeatureboxstation.js" %>
                            </script>

                            <label>Station Features</label>
                            <div class="row" id="input-group2">
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-key">
                                            </i>
                                        </span>
                                        <input type="text" class="form-control" name="stationfeaturekey0"/>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="fa fa-vimeo-square">
                                            </i>

                                        </span>
                                        <input type="text" class="form-control" name="stationfeaturevalue0"/>
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-flat" type="button" onclick="loadAddfeature()" href="#">+</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary" name="submitstation">Submit</button>
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