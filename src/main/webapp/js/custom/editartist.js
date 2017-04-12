/**
 * Created by saman on 10/15/14.
 */

var domain = getDomain();

function editArtistName( songID, newSongName ){

    var json = { "id" : songID, "name" : newSongName };

    $.ajax({

        url: domain+"/changeArtistName.ajax",
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


function editArtistInfo( songID, newArtistInfo ){

    var json = { "id" : songID, "info" : newArtistInfo };

    $.ajax({

        url: domain+"/changeArtistInfo.ajax",
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