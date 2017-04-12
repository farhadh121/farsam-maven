var count=1;
function loadAdd(){

$(document).ready(function(){
    var newInput = $("<div class='input-group' style='margin-top: 3%;'><div class='input-group-addon' > <i class='fa fa-male'></i> </div><input  type='text' class='form-control'  placeholder='Artist Name'name='artistname"+ count +"'/></div>");
    $('div#input-group').after(newInput);


});
    count++;
    console.log(count);
    $('div#input-group').after("<input type='hidden' name='textboxcount' value='"+count+"'/>" );
}

