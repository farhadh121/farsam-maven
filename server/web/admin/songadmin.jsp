<!DOCTYPE html>
<html>

<%@ include file="subpages/header.jsp" %>
<!-- Javascript for adding more textboxes-->
<script>
    <%@ include file="../js/addinputbox.js" %>
</script>
<!-- Javascript for adding more textboxes-->
<body class="skin-blue">
<!-- top navigation bar jsp file-->
<%@ include file="subpages/topNavBar.jsp" %>
<div class="wrapper row-offcanvas row-offcanvas-left">
<!-- Left side column. contains the logo and sidebar -->
<%@ include file="subpages/leftNavBar.jsp" %>
<!-- Right side column. Contains the navbar and content of the page -->
<aside class="right-side">
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Dashboard
        <small>Song Management Panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Song Management</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

<!-- top row -->
<div class="row">
    <div class="col-xs-12 connectedSortable">

    </div><!-- /.col -->
</div>
<!-- /.row -->

 <!-- Add song Module-->
<%@ include file="subpages/addsong.jsp" %>

 <!-- List song Module -->
<%--<%@ include file="subpages/listsongs.jsp" %>--%>
    
 <!-- Search song module -->
<%@ include file="subpages/editsong.jsp" %>    


</section><!-- /.content -->
</aside><!-- /.right-side -->
</div><!-- ./wrapper -->

<!-- add new calendar event modal -->


<%@ include file="subpages/javascript.jsp" %>

</body>
</html>