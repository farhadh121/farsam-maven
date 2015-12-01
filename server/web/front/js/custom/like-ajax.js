
//This function is called in listenSidePlaylist when Like button is clicked
 //var domain = "http://127.0.0.1:8080";
function passTheLikeButton() {
    (function(){

        var myDiv = document.getElementById("likeLoader");

        var show = function(){
            myDiv.style.display = "block";
            setTimeout(hide, 1000);  // 5 seconds
        }

        var hide = function(){
            myDiv.style.display = "none";
        }

        show();

        /*function hasClass(element, cls) {
            return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;
        }
        var test = document.getElementById("like-status"),
            classes = ['like-btn', 'like-h'];

       // test.innerHTML = "";


            if(hasClass(test, 'like-h')) {
                document.getElementById("msg-already-liked").style.display = "block";
                function hideNote(){
                    document.getElementById("msg-already-liked").style.display = "none";
                }
                setTimeout(hideNote,1000);
            }
            else
            {  */
                //Changes the information on the likeers status in real time.
                var likeCount = document.getElementById("likeCount").innerHTML;
                var dislikeCount = document.getElementById("dislikeCount").innerHTML;
                var likeCountInteger = parseInt(likeCount);
                var dislikeCountInterger = parseInt(dislikeCount);
                likeCountInteger = likeCountInteger + 1;
                var totalCount = likeCountInteger + dislikeCountInterger;
                var totalLikes = likeCountInteger/totalCount * 100;
                //alert(totalLikes);
                //var totalKireKhar  = totalLikes * 100;
                //alert(totalKireKhar);
                document.getElementById("likeCount").innerHTML = likeCount;
                document.getElementById("greenLine").style.width = totalLikes + "%";
                document.getElementById("redLine").style.width = 100 - totalLikes + "%";
                document.getElementById("likeCount").innerHTML =  likeCountInteger.toString();
                document.getElementById("totalCount").innerHTML = likeCountInteger.toString();

            //}



    })();


    $(function () {

        var songID = $("#set-next-song-id").text();
        var userName = getUserID();
        console.log("Song ID: " + userName);

        // $('.like-btn').click(function(){
        var json = {"songid": songID, "userName": userName};
        //alert( json );
        $('.dislike-btn').removeClass('dislike-h');
        $('.like-btn').addClass('like-h');
        //Call back function to call callLikeAjax when like is clicked
        callLikeAjax(json);
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

    function callLikeAjax(json) {


        $.ajax({
            type: "POST",
            url: "/userLikesSong.ajax",
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
