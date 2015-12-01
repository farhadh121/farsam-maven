/**
 * Created by MizhoO on 12/30/14.
 */


function editProfileUsername( userID, newUsername ){

    var json = { "userID" : userID, "username" : newUsername };

    $.ajax({

        url: "/changeUsernameController.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response) {

            // alert( "Profile username changed successfully!" );
            var div = document.createElement('div');

            if (response == "success") {
                div.innerHTML = '<div class="alert alert-success">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You successfully modified your username.</a>\
            </div>';
            }
            else if(response == "failed"){
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>Your request cannot be processed due to an error.</a>\
                </div>';
            }
            else if (response == "emailnotvalid"){
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>The entered username is not a valid email address.</a>\
                </div>';
            }
            document.getElementById('success').appendChild(div);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log("error", arguments);
            //alert(textStatus);
            var div = document.createElement('div');
            div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot be processed now.</a>\
            </div>';
            document.getElementById('success').appendChild(div);
        }
    });

}
/*
 function editProfilePasswrod( userID, newPassword ){

 var json = { "id" : userID, "password" : newPassword };

 $.ajax({

 url: "http://localhost:8080/changeUserPassword.ajax",
 type: "POST",
 data: JSON.stringify(json),
 cache: false,
 beforeSend: function(xhr){
 xhr.setRequestHeader( "Accept", "application/json" );
 xhr.setRequestHeader( "Content-Type", "application/json" );
 },
 success: function(response){
 alert( "Profile password changed successfully!" );
 },
 error: function (jqXhr, textStatus, errorThrown) {
 alert(textStatus);
 }
 });

 }
 */

function editProfileFirstName( userID, firstName ){

    var json = { "userID" : userID, "firstName" : firstName };

    // alert( userID + " " + firstName );

    $.ajax({

        url: "/changeUserFirstName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            // add the success message to success div in UI

            var div = document.createElement('div');
            if(response == "success") {
                div.innerHTML = '<div class="alert alert-success">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You successfully modified your first name.</a>\
            </div>';
            }
            else{
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
                </div>';
            }
            document.getElementById('success').appendChild(div);
        },
        error: function (jqXhr, textStatus, errorThrown) {
           // alert(textStatus);
            var div = document.createElement('div');
            div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
            </div>';
            document.getElementById('success').appendChild(div);
        }

    });

}

function editProfileLastName( userID, lastName ){

    var json = { "userID" : userID, "lastName" : lastName };

    $.ajax({

        url: "/changeUserLastName.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            //alert( "Profile last name changed successfully!" );
            var div = document.createElement('div');

            if(response == "success") {
                div.innerHTML = '<div class="alert alert-success">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You successfully modified your last name.</a>\
                </div>';
            }
            else{
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
                </div>';
            }
            document.getElementById('success').appendChild(div);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            //alert(textStatus);
            var div = document.createElement('div');
            div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
            </div>';
            document.getElementById('success').appendChild(div);
        }

    });

}

function editProfileBirthday( userID, birthDate ){

    var json = { "id" : userID, "birthDate" : birthDate };

    $.ajax({

        url: "/changeUserBirthDateController.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            //alert( "Profile last name changed successfully!" );
            var div = document.createElement('div');
            if(response == "success") {
                div.innerHTML = '<div class="alert alert-success">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You successfully modified your birthday.</a>\
                </div>';
            }
            else{
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
                </div>';
            }
            document.getElementById('success').appendChild(div);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            //alert(textStatus);
            var div = document.createElement('div');
            div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
            </div>';
            document.getElementById('success').appendChild(div);
        }

    });

}

function deleteStationForUser( stationid, username ){

    var json = { "stationid" : stationid, "username" : username };

    $.ajax({

        url: "/deleteUserStation.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){
            console.log("success" + response);
            //alert( "Profile last name changed successfully!" );
            var div = document.createElement('div');

            if(response == "success") {
                div.innerHTML = '<div class="alert alert-success">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You successfully deleted the station.</a>\
                </div>';
                location.reload();
            }
            else{
                div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
                </div>';
            }

            document.getElementById('success').appendChild(div);
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log("error", arguments);

            var div = document.createElement('div');
            div.innerHTML = '<div class="alert alert-danger">\
                <button type="button" class="close" data-dismiss="alert">×</button>\
                <i class="fa fa-ok-sign"></i>You request cannot processed now.</a>\
            </div>';
            document.getElementById('success').appendChild(div);
        }

    });

}


