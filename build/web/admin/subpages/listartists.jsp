<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.radio.svc.serviceinterface.IAlbumServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.AlbumEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.radio.entity.hibernate.ArtistEntity" %>
<%@ page import="com.radio.svc.serviceinterface.IArtistServiceProvider" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.CommonUI" %>
<%{ %>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">List Artists</h3>
                </div>

                <%
                    String msg = (String)request.getAttribute("msg");
                    String controller = (String)request.getAttribute("controller");
                    if( controller != null && controller.equals("deleteartist") ){
                        if( msg != null && msg.equals("success") ){
                %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Succes!</b>
                        Artist Deleted Successfully.
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
                                <th>Artist Name</th>
                                <th>Artist Artwork</th>
                                <th>Artist Information</th>
                                <th>Delete Artist</th>
                            </tr>
                            <%
                                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                IArtistServiceProvider artistServiceProvider = (IArtistServiceProvider)context.getBean("artistFacede");
                                CommonFile commonFile = (CommonFile)context.getBean("commonFile");
                                CommonUI commonUI = (CommonUI)context.getBean("commonUI");
                                System.out.println( artistServiceProvider );
                                List<ArtistEntity> list = artistServiceProvider.getAllArtists();
                                Iterator itr = list.iterator();
                                int counter = 1;
                                while( itr.hasNext() ){
                                    ArtistEntity temp = (ArtistEntity)itr.next();
                                    System.out.println( counter + " " + temp.getArtistName() + " " + temp.getArtistInfo() );
                            %>
                            <tr>
                                <th><%=counter%>.</th>
                                <th><%=temp.getArtistName()%></th>
                                <th><img src=<%="\""+commonFile.getDomain()+ commonFile.getArtistaArtworksaAlias() + commonFile.getSeparator() + temp.getArtistArtworkPath()+"\"" %> width=<%="\"" + commonUI.getAdminImageWidth() + "\""%>  height=<%="\"" + commonUI.getAdminImageHeight() + "\""%>/></th>
                                <th><%=temp.getArtistInfo()%></th>
                                <th><button class="btn btn-danger btn-flat" onclick="location.href='/deleteArtistController.htm?artistname=<%=temp.getArtistName()%>'">Delete</button></th>
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