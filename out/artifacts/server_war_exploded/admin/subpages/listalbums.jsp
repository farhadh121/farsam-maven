<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="com.radio.svc.serviceinterface.IAlbumServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.AlbumEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.radio.entity.hibernate.ArtistEntity" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.CommonUI" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%{ %>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">List Albums</h3>
                </div>

                <%
                    String msg = (String)request.getAttribute("msg");
                    String controller = (String)request.getAttribute("controller");
                    if( controller != null && controller.equals("deletealbum") ){
                        if( msg != null && msg.equals("success") ){
                %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Succes!</b>
                        Album Deleted Successfully.
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
                                <th>Album Name</th>
                                <th>Album Artwork</th>
                                <th>Record Label</th>
                                <th>Album Artists</th>
                                <th>Album Release Date</th>
                                <th>Delete Album</th>
                            </tr>
                            <%
                                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                IAlbumServiceProvider albumServiceProvider = (IAlbumServiceProvider)context.getBean("albumFacade");
                                CommonFile commonFile = (CommonFile)context.getBean("commonFile");
                                CommonUI commonUI = (CommonUI)context.getBean("commonUI");
                                List<AlbumEntity> list = albumServiceProvider.getAllAlbums();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                                Iterator itr = list.iterator();
                                int counter = 1;
                                System.out.println( counter );
                                while( itr.hasNext() ){
                                    AlbumEntity temp = (AlbumEntity)itr.next();
                            %>
                            <tr>
                                <th><%=counter%>.</th>
                                <th><%=temp.getName()%></th>
                                <%
                                    System.out.println( albumServiceProvider.getRecordLabel(temp.getName()).getName() );
                                %>
                                <th><img src=<%="\""+commonFile.getDomain() + commonFile.getAlbumArtworksAlias() + commonFile.getSeparator() + temp.getAlbumArtworkPath()+"\"" %> width=<%="\"" + commonUI.getAdminImageWidth() + "\""%>  height=<%="\"" + commonUI.getAdminImageHeight() + "\""%>/></th>
                                <th><%=albumServiceProvider.getRecordLabel(temp.getName()).getName()%></th>
                                <th>
                                    <%
                                        System.out.println( albumServiceProvider.getAllArtists(temp.getName()).size() );
                                        Iterator itrArtists = albumServiceProvider.getAllArtists(temp.getName()).iterator();
                                        System.out.println( "after iterator " + itrArtists );
                                        while( itrArtists.hasNext() ){
                                            System.out.println( "doodool" );
                                            ArtistEntity artistEntity = (ArtistEntity)itrArtists.next();
                                            System.out.println( "hello" );
                                            System.out.println( artistEntity );
                                            System.out.println( artistEntity.getArtistName() );

                                    %>
                                        <p><%=artistEntity.getArtistName()%></p>
                                    <%
                                        }
                                    %>
                                </th>
                                <%
                                    System.out.println( temp.getReleaseDate() );
                                %>
                                <th><%=simpleDateFormat.format(temp.getReleaseDate())%></th>
                                <th><button class="btn btn-danger btn-flat" onclick="location.href='/deleteAlbumController.htm?albumname=<%=temp.getName()%>'">Delete</button></th>
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