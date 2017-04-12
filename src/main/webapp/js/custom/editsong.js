/**
 * Created by saman on 9/24/14.
 */

var domain = getDomain();

function editSongName( songID, newSongName ){

    var json = { "id" : songID, "name" : newSongName };

    $.ajax({

        url: domain+"/changeSongName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Song name changed successfully!" );
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    });

}


function editSongAlbumName( songID, newAlbumName ){

    var json = { "id" : songID, "name" : newAlbumName };

    $.ajax({

        url: domain+"/changeSongAlbumName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Song album name changed successfully!" );
        },
        error: function(jqXhr, textStatus, errorThrown){
            alert(textStatus);
        }

    });

}

function editSongGenreName( songID, newGenreName ){

    var json = { "id" : songID, "name" : newGenreName };

    $.ajax({
        url: domain+"/changeSongGenreName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert("song genre change successfully!");
        },
        error: function(jqXhr, textStatus, errorThrown){
            alert(textStatus);
        }
    });

}

function editSongLyric( songID, newLyric ){

    var json = { "id" : songID, "lyric" : newLyric  };

    $.ajax({
        url: domain+"/changeSongLyric.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert("Song's lyric changed successfully!");
        },
        error: function(jqXhr, textStatus, errorThrown){
            alert(textStatus);
        }
    });

}