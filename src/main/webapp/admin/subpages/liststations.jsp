<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IStationServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.StationEntity" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.CommonUI" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="com.radio.entity.hibernate.StationFeatureEntity" %>
<%{ %>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">List Stations</h3>
                </div>

                <%
                    String msg = (String)request.getAttribute("msg");
                    String controller = (String)request.getAttribute("controller");
                    if( controller != null && controller.equals("deletestation") ){
                        if( msg != null && msg.equals("success") ){
                %>
                <div class="alert alert-success alert-dismissable">
                    <i class="fa fa-check"></i>
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                    <b>Succes!</b>
                    Station Deleted Successfully.
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
                            <th>Station ID</th>
                            <th>Station Owner</th>
                            <th>Creation Date</th>
                            <th>Station Features</th>
                            <th>Delete Station</th>
                        </tr>
                        <%
                            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                            IStationServiceProvider stationServiceProvider = (IStationServiceProvider)context.getBean("stationFacade");
                            List<StationEntity> list = stationServiceProvider.getAllStations();
                            CommonFile commonFile = (CommonFile)context.getBean("commonFile");
                            CommonUI commonUI = (CommonUI)context.getBean("commonUI");
                            Iterator itr = list.iterator();
                            int counter = 1;
                            while( itr.hasNext() ){
                                StationEntity temp = (StationEntity)itr.next();
                        %>
                        <tr>
                            <th><%=counter%>.</th>
                            <th><%=temp.getStationID()%></th>
                            <th><%=temp.getOwner().getEmail()%></th>
                            <th><%=temp.getCreationDate()%></th>
                            <th>
                                <%
                                    Iterator itr1 = temp.getFeatures().iterator();
                                    while( itr1.hasNext() ){
                                        StationFeatureEntity featureEntity = (StationFeatureEntity)itr1.next();


                                %>
                                <p><%=featureEntity.getFeatureKey()%> = <%=featureEntity.getFeatureValue()%></p>
                                <%
                                    }
                                %>
                            </th>
                            <th><button class="btn btn-danger btn-flat" onclick="location.href='/deleteStationController.htm?stationid=<%=temp.getStationID()%>'">Delete</button></th>
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