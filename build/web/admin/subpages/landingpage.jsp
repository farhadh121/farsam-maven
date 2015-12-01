<script>
    var video = document.getElementById("bgvideo");
    video.addEventListener('touchstart', function(e) {
        e.preventDefault();

        video.play();
    });
</script>

    <video id="video" autoplay="" loop="" poster="http://demosthenes.info/assets/images/polina.jpg" id="bgvid"  muted>
      <!--  <source src="../img/3dmusic.webm" type="video/webm">  -->
        <source src="../img/video.mp4" type="video/mp4">
    </video>


<style>

     video#bgvid {
        position: fixed; right: 0; bottom: 0;
        min-width: 100%; min-height: 100%;
        width: auto; height: auto; z-index: -100;
        'background: url(polina.jpg) no-repeat;
        background-size: cover;
    }
</style>
