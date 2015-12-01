<%--
  Created by IntelliJ IDEA.
  User: saman
  Date: 5/16/14
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Song Test( Version 1 )</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="/testsuite/addsong">
        <p>Song Name</p>
        <input type="text" id="inputSongName" name="inputSongName"/>
        <br/>
        <p>Artist Name</p>
        <input type="text" id="inputArtistName" name="inputArtistName"/>
        <br/>
        <p>Lyric</p>
        <input type="text" id="inputSongLyric" name="inputSongLyric"/>
        <br/>
        <p>Upload Song</p>
        <input type="file" id="inputSongFile" name="inputSongFile"/>
        <br/>
        <p>Upload Artwork</p>
        <input type="file" id="inputArtworkFile" name="inputArtworkFile"/>
        <br/>
        <input type="submit" name="inputSongSubmit" id="inputSongSubmit" value="Submit"/>
    </form>
</body>
</html>