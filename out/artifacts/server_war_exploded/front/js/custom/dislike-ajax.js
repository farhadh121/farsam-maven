/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 1/10/15
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */


var domain = "http://52.88.252.192:8080";
function passTheDislikeButton() {


    $(function () {

        var songID = $("#set-next-song-id").text();
        var userName = getUserID();
        console.log("Song ID: " + userName);

        // $('.like-btn').click(function(){
        var json = {"songid": songID, "userName": userName};
        //alert( json );
        $('.dislike-btn').addClass('dislike-h');
        $('.like-btn').removeClass('like-h');
        //Call back function to call callLikeAjax when like is clicked
        callDisikeAjax(json);
        // });


        /*$('.dislike-btn').click(function(){
         var json ={ "act" : "dislike", "songid" : songID , "userid" :  userID };
         $('.like-btn').removeClass('like-h');
         $(this).addClass('dislike-h');
         $.ajax({
         type:"POST",
         url:"ajax.php",
         data:JSON.stringify(json),
         success: function(){
         }
         });
         });*/

        $('.share-btn').click(function () {
            $('.share-cnt').toggle();
        });
    });
    function callDisikeAjax(json) {
        $.ajax({
            type: "POST",
            url: domain+"/userDislikesSong.ajax",
            data: JSON.stringify(json),
            cache: false,
            //onLoading:jQuery("#ajaxLoader").attr('src', 'images/Hypercube_Large_Light.gif'),


            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function () {
                //("#ajaxLoader").hide();
            },
            error: function (jqXhr, textStatus, errorThrown) {
                console.log("error", arguments);
            }

        });
    }

}

