<%--
  Created by IntelliJ IDEA.
  User: farhad
  Date: 5/17/14
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="subpages/header.jsp" %>
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
        <small>User Management Panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">User Management Panel</li>
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
<!-- add user subpage -->
<%@ include file="subpages/adduser.jsp"%>

<!-- list users subpage -->
<%@ include file="subpages/listusers.jsp"%>

<!--Javascripts and links-->
<%@ include file="subpages/javascript.jsp" %>

</body>
</html>