/**
 * Created with IntelliJ IDEA.
 * User: farhad
 * Date: 7/8/14
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */

var count=1;
function loadAdd(){

    $(document).ready(function(){
        var newInput = $("<div class='input-group' style='margin-top: 3%;'><div class='input-group-addon'> <i class='fa fa-male'></i> </div><input type='text' class='form-control'  placeholder='User Role'name='userrole"+ count +"' id='userrole" + count + "'/></div>");
        $('div#input-group').after(newInput);


    });
    count++;
    console.log(count);
    $('div#input-group').after("<input type='hidden' name='textboxcount' value='"+count+"'/>" );
}

