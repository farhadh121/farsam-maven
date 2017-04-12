/**
 * Created by saman on 10/19/14.
 */

var domain = getDomain();
function editAlbumName( songID, newAlbumName ){

    var json = { "id" : songID, "name" : newAlbumName };

    $.ajax({

        url: domain+"/changeAlbumName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Album name changed successfully!" );
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    });

}

function editAlbumRecordLabel( songID, newAlbumRecordLabel ){

    var json = { "id" : songID, "name" : newAlbumRecordLabel };

    $.ajax({

        url: domain+"/changeAlbumRecordLabel.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Album Record Label changed successfully!" );
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    });

}

function editAlbumArtist( songID, newArtistName ){

    var json = { "id" : songID, "name" : newArtistName };

    $.ajax({

        url: domain+"/changeAlbumArtist.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Album artist changed successfully!" );
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    });

}

function editAlbumReleaseDate( songID, newAlbumReleaseDate ){

    var json = { "id" : songID, "date" : newAlbumReleaseDate };

    $.ajax({

        url: doamin+"/changeAlbumReleaseDate.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            alert( "Album release date changed successfully!" );
        },
        error: function (jqXhr, textStatus, errorThrown) {
            alert(textStatus);
        }

    });

}

