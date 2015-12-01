/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/3/15
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */



var domain = "http://52.88.252.192:8080";
window.fbAsyncInit = function() {
    FB.init({
        appId      : '419420661507146', // App ID
        channelUrl : domain, // Channel File
        status     : true, // check login status
        cookie     : true, // enable cookies to allow the server to access the session
        xfbml      : true  // parse XFBML
    });


    FB.Event.subscribe('auth.authResponseChange', function(response)
    {
        if (response.status === 'connected')
        {
            console.log("Connected to Facebook");
            //SUCCESS

        }
        else if (response.status === 'not_authorized')
        {
            $("#error").append("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><i class='fa fa-ban-circle'></i><strong>Oh snap!</strong> <a href='#' class='alert-link'>Something went wrong</a> try submitting again.</div>");


            //FAILED
        } else
        {
            console.log("Goodbye");

            //UNKNOWN ERROR
        }
    });

};

function Login()
{

    FB.login(function(response) {
        if (response.authResponse)
        {
            getUserInfo();
        } else
        {
            console.log('User cancelled login or did not fully authorize.');
        }
    },{scope: 'email,user_photos,user_videos'});


}


function getUserInfo() {
    var image = null;
    var fbjason = null;

    FB.api(
        "/me/picture",
        function (response) {
            if (response && !response.error) {
                image =  response.data.url;
            }
        }
    );

    FB.api(
        '/me',
        function(response) {

            var name=response.name;
            var link = response.link;
            var username = response.username;
            var id = response.id;
            var email = response.email;
            var birthday = response.birthday;
            //var image = ;
            // str +="<input type='button' value='Logout' onclick='Logout();'/>";
            // console.log(image);
            //document.getElementById("status").innerHTML= name + " " + link + " " + username + " " + id + " " + email + " " + image;

            fbjason = { "name" : name, "link" : link, "username": username, "id" :id, "picture":image,"birthday":birthday,"email":email };

            ajaxCaller(fbjason);
            //alert("From inside FB" + fbjason);


        }

    );



}
function ajaxCaller(facebookVal){
    //alert("from akax caller" + JSON.stringify(facebookVal));
    var facebookJson = facebookVal;
    $.noConflict();
    jQuery( document ).ready(function( $ ) {
    $.ajax({

        url: domain+"/facebookLogin.ajax",
        type: "POST",
        data: JSON.stringify(facebookJson),
        cache: false,
        beforeSend: function(xhr){

            //console.log(facebookJson);
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){

            //alert(JSON.stringify(response));
            if( JSON.stringify(response) != -1 ){
                // We are getting redirected to the listen page, because station has been created successfully.
                var username = response.username;
                var password = response.password;
                //alert("here is the user and pass" + username + " " + password);
                var url = domain+'/perform_login';
                var form = $('<form action="' + url + '" method="post">' +
                    '<input type="text" name="j_username" value="' + username + '" />' +
                    '<input type="text" name="j_password" value="' + password + '" />' +
                    '</form>');
                $('body').append(form);
                form.submit();
            }else{
                // Unfortunately, something went wrong and the station was not created successfully.
                $("#error").append("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><i class='fa fa-ban-circle'></i><strong>Oh snap!</strong> <a href='#' class='alert-link'>Change a few things up</a> and try submitting again.</div>");

            }
        },
        error: function(jqXhr, textStatus, errorThrown){
            //console.log("error", arguments);
            //console.log( textStatus );
            //console.log("kose nane khomeini");
            $("#error").append("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><i class='fa fa-ban-circle'></i><strong>Oh snap!</strong> <a href='#' class='alert-link'>Change a few things up</a> and try submitting again.</div>");

        }
    });
    });
}


    //alert("in jason jadidast" +fbjason);






function Logout()
{
    FB.logout(function(){document.location.reload();});
}
// Load the SDK asynchronously
(function(d){
    var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement('script'); js.id = id; js.async = true;
    js.src = "//connect.facebook.net/en_US/all.js";
    ref.parentNode.insertBefore(js, ref);
}(document));



