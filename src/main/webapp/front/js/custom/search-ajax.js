

//var availableTags;
/*
 function createStation(){
 $.ajax({

 type: "POST",
 data: JSON.stringify(ui.item.lable + ui.),
 cache: false,
 beforeSend: function(xhr){
 xhr.setRequestHeader( "Accept", "application/json" );
 xhr.setRequestHeader( "Content-Type", "application/json" );
 }
 });
 */

//var domain = "http://127.0.0.1:8080";
function createStation( input ){

    var json = { "name" : input.name, "type" : input.type, "id" :  input.id, "lyrics" : input.lyrics };

    $.ajax({

        url: "/createStation.ajax",
        type: "POST",
        data: JSON.stringify(json),
        cache: false,
        beforeSend: function(xhr){
            xhr.setRequestHeader( "Accept", "application/json" );
            xhr.setRequestHeader( "Content-Type", "application/json" );
        },
        success: function(response){

            if( JSON.stringify(response) != -1 ){
                // We are getting redirected to the listen page, because station has been created successfully.
                window.location.replace( "/front/listen.jsp?stationid="+JSON.stringify(response) );
            }else{
                // Unfortunately, something went wrong and the station was not created successfully.
                $("#error").append("<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><i class='fa fa-ban-circle'></i><strong>Oh snap!</strong> <a href='#' class='alert-link'>Change a few things up</a> and try submitting again.</div>");

            }
        },
        error: function(jqXhr, textStatus, errorThrown){
            console.log( textStatus );
        }
    });

}



function getSearchCandidates( ){
    //global array
    var resultResponse = [];


    $("#searchbar").autocomplete({
        appendTo: "#results",
        minLength: 0,


        source: function (request, response) {



            var searchString = $('#searchbar').val();
            var json = { "search": searchString };


            $.ajax({

                url: "/searchForStation.ajax",
                type: "POST",
                data: JSON.stringify(json),
                cache: false,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },

                success: function (data) {
                        //adding the result of AJAX to the array created previously
                       resultResponse = data;
                    //console.log(JSON.stringify(resultResponse))

                    //Mapping the JSON array to it parts name, type, artworkPath and id
                    response($.map(data, function (v, i) {

                        return {
                            type: v.type,
                            name: v.name,
                            artWork: v.artworkPath,
                            id: v.id
                        }


                    }));


                },
                error: function (jqXhr, textStatus, errorThrown) {
                    console.log(textStatus);
                }

            });

        },open: function() {
            //console.log("kose nanat "+id );
            //Setting the position of the serach textbox.
            var position = $("#results").position(),
                left = position.left, top = position.top, bottom = position.bottom;

            $("#results > ul").css({ bottom: (bottom + 8)+ "px", left: (left + 0) + "%"});

            //Select function will trigger when item is clicked on.
        },select: function (event, ui) {   //must be cleared with function parameter



            var passCreateStation;
            for( var i = 0;  i < resultResponse.length; i++ ){

                if( resultResponse[i].id == ui.item.id)
                    passCreateStation = resultResponse[i];
                    //alert(passCreateStation);
               //alert(JSON.stringify(passCreateStation));

            }
            //alert( resultResponse );
            //pass the selected item to creatStation to make a new station.
            createStation( passCreateStation );


        },
        response:function(event, ui){
            if (!ui.content.length) {
                var noResult = { type:"",name:"No results found",artWork: domain+"/front/images/sadface.png" };
                ui.content.push(noResult);
                //$("#message").text("No results found");
            } else {
                $("#message").empty();
            }
        }


    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
       // console.log("endol " + item.artWork);



        //var position = $("#results").position(),
        //left = position.left, top = position.top, bottom = position.bottom;
        return $( "<li class=''>" ).append( "<a><img id='image-prop' style='left: 0px' src='"+ item.artWork +"'></img><span style='float: left; font: FontAwesome; font-size-adjust: 15; text-wrap:normal;' >" + item.name + "</span><span style='float: right;'>" + item.type + "</span></a>" )
            .appendTo( ul);


    };
    return true;
}






// var availableTags = getSearchCandidates();
//console.log(availableTags);




