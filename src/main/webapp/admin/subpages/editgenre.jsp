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
                        <h3 class="box-title">Edit Genre</h3>
                    </div>

                    <%
                        String msg = (String)request.getAttribute("msg");
                        String controller = (String)request.getAttribute("controller");
                        if( controller != null && controller.equals("editgenre") ){
                            if( msg != null && msg.equals("success") ){
                    %>
                            <div class="alert alert-success alert-dismissable">
                                <i class="fa fa-check"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                                <b>Success!</b>
                                Genre Edited Successfully!
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
                    <form role="form" method="post" action="/searchGenreController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="genrename">Genre Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="genrename" id="genrename" placeholder="Genre Name">
                                    </div>
                                    <div class="col-xs-3">
                                       <button type="submit" name="submit" class="btn btn-success">Search</button>
                                   </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->

                    </form>

                    <%
                        GenreEntity genreEntity = (GenreEntity)request.getAttribute("genreobject");
                        if( genreEntity != null ){
                    %>
                    <form role="form" method="post" action="/editGenreController.htm">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="genrenameedit">Genre Name</label>
                                <div class="row">
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="genrenameedit" id="genrenameedit" value="<%=genreEntity.getName()%>">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="genreid" id="genreid" value="<%=genreEntity.getGenreID()%>"/>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" name="submit" class="btn btn-warning">Edit</button>
                        </div>
                    </form>
                    <%
                        }
                    %>

                </div>
                <!-- /.box -->
            </div>
            <!--/.col-md-6-->
        </div>
        <!-- /.box -->
    </div>
</section><!-- /.Left col -->
<% } %>