<%@ page import="com.radio.entity.hibernate.GenreEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IGenreServiceProvider" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IRoleServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.RoleEntity" %>
<%@ page import="com.radio.svc.serviceinterface.IUserServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.UserEntity" %>
<!-- If I don't use this, Then I possibly get duplicated variable errors -->
<%{ %>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">List Users</h3>
                </div>

                <%
                    String msg = (String)request.getAttribute("msg");
                    String controller = (String)request.getAttribute("controller");
                    if( controller != null && controller.equals("deleteuser") ){
                        if( msg != null && msg.equals("success") ){
                %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Succes!</b>
                        User Deleted Successfully.
                    </div>
                <%
                        }else if( msg != null && msg.equals("failed") ){
                %>
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Failed!</b>
                            <%=request.getAttribute("msgbody").toString()%>
                    </div>
                <%
                        }
                    }
                %>

                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <th style="width: 10px">#</th>
                                <th>User Email</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Born Date</th>
                                <th>Roles</th>
                                <th>Delete</th>
                            </tr>
                            <%
                                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                IUserServiceProvider userServiceProvider = (IUserServiceProvider)context.getBean("userFacade");
                                List<UserEntity> list = userServiceProvider.getAllUsers();
                                Iterator itr = list.iterator();
                                int counter = 1;
                                while( itr.hasNext() ){
                                    UserEntity temp = (UserEntity)itr.next();
                            %>
                            <tr>
                                <th><%=counter%>.</th>
                                <th><%=temp.getEmail()%></th>
                                <th><%=temp.getFirstName()%></th>
                                <th><%=temp.getLastName()%></th>
                                <th><%=temp.getBornDate()%></th>
                                <th>
                                    <%
                                        List<RoleEntity> userRoles = userServiceProvider.getUserRoles( temp.getUserID() );
                                        Iterator itr2 = userRoles.iterator();
                                        while( itr2.hasNext() ){
                                            RoleEntity roleEntity = (RoleEntity)itr2.next();
                                    %>
                                        <p><%=roleEntity.getName()%></p>
                                    <%
                                        }
                                    %>
                                </th>
                                <th><button class="btn btn-danger btn-flat" onclick="location.href='/deleteUserController.htm?userid=<%=temp.getUserID()%>'">Delete</button></th>
                            </tr>

                            <%
                                    counter++;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<% } %>