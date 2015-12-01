<%--
  Created by IntelliJ IDEA.
  User: saman
  Date: 5/17/14
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Artist Test( Version 1 )</title>
</head>
<body>
    <form method="post" action="/testsuite/addartist">
        <p>Artist Name</p>
        <input type="text" id="inputArtistName" name="inputArtistName"/>
        <br/>
        <p>Artist Info</p>
        <input type="text" id="inputArtistInfo" name="inoutArtistInfo"/>
        <br/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>