$(document).ready(function(){
    
    $("#pl").hover(
        function(){
        $("#pl").animate({
            height:"1300px",
            paddingTop:"230px"
        },600)},
        function(){
        $("#pl").animate({
            height:"1200px",
            paddingTop:"150px"
        },600)
    });
    
    $("#pr").hover(
        function(){
        $("#pr").animate({
            height:"1300px",
            paddingTop:"230px"
        },600)},
        function(){
        $("#pr").animate({
            height:"1200px",
            paddingTop:"150px"
        },600)
    });
    
    
    
}); 

function show(){
    $(".parent").animate({
        marginTop: "300px"
    },1000);
}
function check_info_er(){
    var erusername=document.getElementById("erusername").value;
    var erpass=document.getElementById("erpass").value;
    
    if(erusername=="" || erpass==""){
        
        //alert("Pleas Fill All Fields.");
        swal({
        title: "Pleas Fill All Fields.",
        icon: "info",
        button: "Ok",
    });
        return false;
    }else{
        return true;
    }
    
   
}
function check_info_ee(){
    var eeusername=document.getElementById("eeusername").value;
    var eepass=document.getElementById("eepass").value;
    
    if(eeusername=="" || eepass==""){
     //alert("Pleas Fill All Fields.");
        swal({
        title: "Pleas Fill All Fields.",
        icon: "info",
        button: "Ok",
    });
        return false;
    }else{
        return true;
    }
}






