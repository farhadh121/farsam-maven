<%@ page import="com.radio.entity.hibernate.GenreEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.IGenreServiceProvider" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.radio.svc.serviceinterface.ISongServiceProvider" %>
<%@ page import="com.radio.entity.hibernate.SongEntity" %>
<%@ page import="com.radio.entity.hibernate.AlbumEntity" %>
<%@ page import="com.radio.entity.hibernate.ArtistEntity" %>
<%@ page import="com.radio.svc.common.CommonFile" %>
<%@ page import="com.radio.svc.common.CommonUI" %>
<!-- If I don't use this, Then I possibly get duplicated variable errors -->
<%{ %>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">List Songs</h3>
                </div>

                <%
                    String msg = (String)request.getAttribute("msg");
                    String controller = (String)request.getAttribute("controller");
                    if( controller != null && controller.equals("deletesong") ){
                        if( msg != null && msg.equals("success") ){
                %>
                    <div class="alert alert-success alert-dismissable">
                        <i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                        <b>Succes!</b>
                        Songw Deleted Successfully.
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
                                <th>Song Name</th>
                                <th>Song Album</th>
                                <th>Album Artists</th>
                                <th>Song Genre</th>
                                <th>Song Lyric</th>
                                <th>Song Artwork</th>
                                <th>Delete Song</th>
                            </tr>
                            <%
                                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
                                ISongServiceProvider songServiceProvider = (ISongServiceProvider)context.getBean("songFacede");
                                List<SongEntity> list = songServiceProvider.getAllSongs();
                                CommonFile commonFile = (CommonFile)context.getBean("commonFile");
                                CommonUI commonUI = (CommonUI)context.getBean("commonUI");
                                Iterator itr = list.iterator();
                                int counter = 1;
                                while( itr.hasNext() ){
                                    SongEntity temp = (SongEntity)itr.next();
                                    AlbumEntity albumEntity = songServiceProvider.getSongAlbum( temp.getSongID() );
                                    List<ArtistEntity> artistEntities = songServiceProvider.getSongArtists( temp.getSongID() );
                                    List<GenreEntity> genreEntities = songServiceProvider.getSongGenre( temp.getSongID() );
                            %>
                            <tr>
                                <th><%=counter%>.</th>
                                <th><%=temp.getName()%></th>
                                <th><%=albumEntity.getName()%></th>
                                <th>
                                    <%
                                        Iterator itr1 = artistEntities.iterator();
                                        while( itr1.hasNext() ){
                                            ArtistEntity artistEntity = (ArtistEntity)itr1.next();


                                    %>
                                        <p><%=artistEntity.getArtistName()%></p>
                                    <%
                                        }
                                    %>
                                </th>
                                <th>
                                    <%
                                        itr1 = genreEntities.iterator();
                                        while( itr1.hasNext() ){
                                            GenreEntity genreEntity = (GenreEntity)itr1.next();
                                    %>
                                        <p><%=genreEntity.getName()%></p>
                                    <%
                                        }
                                    %>
                                </th>
                                <th><%=temp.getLyric()%></th>
                                <th><img src=<%="\""+commonFile.getDomain() + commonFile.getSongArtworksAlias() + commonFile.getSeparator() + temp.getArtworkPath()+"\"" %> width=<%="\"" + commonUI.getAdminImageWidth() + "\""%>  height=<%="\"" + commonUI.getAdminImageHeight() + "\""%>/></th>
                                <th><button class="btn btn-danger btn-flat" onclick="location.href='/deleteSongController.htm?songid=<%=temp.getSongID()%>'">Delete</button></th>
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