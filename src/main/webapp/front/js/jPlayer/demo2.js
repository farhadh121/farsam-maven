// the next song Variable set to empty
$.noConflict();
jQuery( document ).ready(function( $ ) {
    // Code that uses jQuery's $ can follow here.

var nextSong = "";
var nextSongTitle = "";
var nextSongArtwork = "";
var nextSongArtist = "";
var nextSongArtistInfo = "";
var nextSongID = null;
var likeStatus = false;
var dislikeStatus = false;
var username = "";
var likeCount = 0;
var dislikeCount = 0;
var domain = "http://taghcheh.com";



$(document).ready(function(){



     //This will get the stationID from the URL
    function getSearchParameters() {
        var prmstr = window.location.search.substr(1);
        return prmstr != null && prmstr != "" ? transformToAssocArray(prmstr) : {};
    }
      //ADD url to array and get the split part by =
    function transformToAssocArray( prmstr ) {
        var params = {};
        var prmarr = prmstr.split("&");
        for ( var i = 0; i < prmarr.length; i++) {
            var tmparr = prmarr[i].split("=");
            params[tmparr[0]] = tmparr[1];
           // alert("stuff from URL " +tmparr[1]);
        }
        return params;
    }

       // call the function to pass the params to variable
    var params = getSearchParameters();
    //clicked station ID
    //console.log("in kos kesh artist" + params.genre);


    function getNextSong( genre ){


              username = getUserID();



        var json = { "genre" : genre, "username" : username}

        $.ajax({

            url: "/perSetStationSong.ajax",
            type: "POST",
            data: JSON.stringify(json),
            cache: false,
            async: false,
            beforeSend: function(xhr){
                xhr.setRequestHeader( "Accept", "application/json" );
                xhr.setRequestHeader( "Content-Type", "application/json" );
            },
            success: function(response){
               //console.log( response );
                nextSongTitle = response.title;
                nextSongArtwork = response.artWorkUrl;
                nextSongArtist = response.artist;
                nextSong  =  response.url;
                nextSongArtistInfo = response.artistInfo;
                nextSongID = response.songID;
                likeStatus = response.likeStatus;
                dislikeStatus = response.dislikeStatus;
                likeCount = response.likeCount;
                dislikeCount = response.dislikeCount;








                //Function from listensideplaylist for Ajax call to like process.


                //console.log("songID e in koskesh" + response.songID);

            },
            error: function(jqXhr, textStatus, errorThrown){
                console.log("error", arguments);
            }

        });
        //Set the picture in Listen page to songArtWork.
        var totalCount = likeCount + dislikeCount;
        var likePercent = (likeCount/totalCount)*100;
        var dislikePercent = (dislikeCount/totalCount)*100;

        if (isNaN(dislikePercent) && isNaN(likePercent)){

            dislikePercent = 0;
            likePercent = 0;
        }

        $("#greenLine").attr('style', 'width:'+likePercent+'%');
        $("#redLine").attr('style', 'width:'+dislikePercent+'%');

        document.getElementById("songArtworkSetter").src = nextSongArtwork;
        document.getElementById("set-artist-name").innerHTML = nextSongArtist;
        document.getElementById("set-artist-info").innerHTML = nextSongArtistInfo;
        document.getElementById("set-next-song-id").innerHTML = nextSongID;
        document.getElementById("dislikeCount").innerHTML = dislikeCount+"";
        document.getElementById("likeCount").innerHTML = likeCount +"";
        document.getElementById("totalCount").innerHTML = likeCount + dislikeCount +"";


        var inputBox = document.getElementById("set-next-song-id");
        inputBox.setAttribute("value", nextSongID);


        if(likeStatus == true){
            //alert("song was liked");
            $('.like-btn').addClass('like-h');
            $('.dislike-btn').removeClass('dislike-h');

        }
        else if(dislikeStatus == true){
            //alert("song wasnot liked");
            $('.dislike-btn').addClass('dislike-h');
            $('.like-btn').removeClass('like-h');
        }
        else{
            $('.dislike-btn').removeClass('dislike-h');
            $('.like-btn').removeClass('like-h');
        }
        //console.log("kire khar " + nextSongID);


        return true;

    }







     //Ajax call for the next song
    getNextSong( params.genre );
    //console.log("picture url:" + nextSongArtwork);
    //This will change the picture in listen.jsp page to songArtwork.

    $("#jplayer_N").jPlayer({
        cssSelectorAncestor: "#jp_container_N",
        ready: function () {

            //Function from listensideplaylist for Ajax call to like process.
            $(this).jPlayer("setMedia", {
                    title: nextSongTitle,
                    artist: nextSongArtist,
                    mp3: nextSong
            }).jPlayer("play");


        },
        ended: function () {

                //getNextSong(function(handleData){});
            document.getElementById("songArtworkSetter").src = nextSongArtwork;
            getNextSong(  params.genre  );
                $(this).jPlayer("setMedia", {

                    title: nextSongTitle,
                    artist: nextSongArtist,
                    mp3: nextSong
                    //oga: "http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
                }).jPlayer("play");
        },
        next: function() {
            //alert( "kirekhar" );
        },

        swfPath: "/js",
        supplied: "mp3, m4a, oga" ,
        autoPlay: true
    });



    //handling next button
    $("#next-song").click(function(){

        document.getElementById("songArtworkSetter").src = nextSongArtwork;
        getNextSong(params.genre );
        $("#jplayer_N").jPlayer( "setMedia", {
            title: nextSongTitle,
            artist: nextSongArtist,
            mp3: nextSong

        }).jPlayer("play");
    });

    //handeling dislike button
    $('.dislike-btn').click(function(){

        document.getElementById("songArtworkSetter").src = nextSongArtwork;
        $('.dislike-btn').removeClass('dislike-h')
        getNextSong(params.genre);
        $("#jplayer_N").jPlayer( "setMedia", {
            title: nextSongTitle,
            artist: nextSongArtist,
            mp3: nextSong

        }).jPlayer("play");
    });








   /* var myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"

    })



        },



    [{mp3: "http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.mp3"}]


   ,{
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: true
    },

    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false

   });           */




    //Song ends itself
    /*$(document).on($.jPlayer.event.ready, myPlaylist.cssSelector.jPlayer,  function(){
        getNextSong(function(handleData){
        console.log("Music is ready to be played");
        myPlaylist.add({
            title:"First Song",
            artist:"The Stark Palace",
            mp3:handleData,

            poster: "http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
        });
            myPlaylist.play(this);
        });
      });     */

    //Song ends itself


    /*$(document).on($.jPlayer.event.ended, myPlaylist.cssSelector.jPlayer,  function(){
        getNextSong(function(handleData){
        console.log("Music Ended");
        myPlaylist.add({
            title:"Fuck Your Face",
            artist:"The Stark Palace",
            mp3: handleData,

            poster: "http://www.jplayer.org/audio/poster/The_Stark_Palace_640x360.png"
        })



      });


    });     */


  /*
  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').addClass('animate');
  });
           */

    //Testing
   // $('.jp-next').click(function(){
     //   $("#jquery_jplayer_1").trigger($.jPlayer.event.ended);
    //});
      //Testing

  $(document).on('click', '.jp-play-me', function(e){
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');


   /* $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if( !$this.hasClass('active') ){
     myPlaylist.pause();
    }else{
      var i = Math.floor(Math.random() * (1 + 7 - 1));
     myPlaylist.play(i);
    }
    
  */});







  // video

  $("#jplayer_1").jPlayer({
    ready: function () {
      $(this).jPlayer("setMedia", {
        title: "Big Buck Bunny",
        m4v: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.m4v",
        ogv: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.ogv",
        webmv: "http://flatfull.com/themes/assets/video/big_buck_bunny_trailer.webm",
        poster: "images/m41.jpg"
      });
    },
    swfPath: "js",
    supplied: "webmv, ogv, m4v",
    size: {
      width: "100%",
      height: "auto",
      cssClass: "jp-video-360p"
    },
    globalVolume: true,
    smoothPlayBar: true,
    keyEnabled: true
  });



});

});