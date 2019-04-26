
/*
$(".button").click(function (){
   
if($("#salary").val()===""){
var xmlhttp;
if (window.XMLHttpRequest) { // for IE7+, Firefox, Chrome, Opera, Safari
xmlhttp = new XMLHttpRequest();
} else { // for IE6, IE5
xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange = function() {
if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
document.getElementById("wofsal").innerHTML = "Validating..";
} else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
document.getElementById("wofsal").innerHTML = "not valida";
} else {
document.getElementById("wofsal").innerHTML = "Error Occurred in the page.";
}
}
xmlhttp.open("POST", true);
xmlhttp.send();
   }
});
*/
    
    
    
    function showNote(){
    $("#dnote").animate({
        marginTop: "150px"
    },800);
    
    $(".buttonOk").click(function(){
        $("#dnote").animate({
        marginTop: "-400px"
    },1000);
    });
    }
    
    





function onChange(){
var list1 = document.getElementById("type_paid");
var myselect = list1.options[list1.selectedIndex].text;

if(myselect ==="---"){
    $(".month").css("display","none");
    $(".week").css("display","none");
}
if(myselect === "Month"){    

    if($(".week").css("display")!== 'none'){
        $(".week").css("display","none");
        
    }
    $(".month").css("display","block");
}else{
    if($(".month").css("display")!== 'none'){
        $(".month").css("display","none");
    }
    $(".week").css("display","block");
}
}


$(function(){
    
    var salaryError=true,
        salaryPerError=true,
        taxCodeError=true,
        paidPerError=true,
        monthError=true,
        weekError=true;
    
   
    
    $("#salary").blur(function (){
    if($(this).val()==""){
        $(this).css('border','1px solid #f00');
        $(".wofsal").fadeIn(200);
        salaryError=true;
    }else{
        $(this).css('border','1px solid green');
        $(".wofsal").fadeOut(200);
        salaryError=false;
    }
});
    
    $("#salare_per").blur(function (){
    if(formCalculate.salary_per.selectedIndex == 0){
        $(this).css('border','1px solid #f00');
        $(".wofsal_per").fadeIn(200);
        salaryPerError=true;
    }else{
        $(this).css('border','1px solid green');
        $(".wofsal_per").fadeOut(200);
        salaryPerError=false;
    }
});
    
    $("#tax_code").blur(function (){
    if(formCalculate.tax_code.selectedIndex == 0){
        $(this).css('border','1px solid #f00');
        $(".woftax_code").fadeIn(200);
        taxCodeError=true;
    }else{
        $(this).css('border','1px solid green');
        $(".woftax_code").fadeOut(200);
        taxCodeError=false;
    }
});
    
    $("#type_paid").blur(function (){
    if(formCalculate.paid_per.selectedIndex == 0){
        $(this).css('border','1px solid #f00');
        $(".wofpaid_per").fadeIn(200);
        paidPerError=true;
    }else if(formCalculate.paid_per.selectedIndex !== formCalculate.salary_per.selectedIndex){
        $(this).css('border','1px solid #f00');
        $(".wofpaid_per").fadeIn(200);
    }else{
        $(this).css('border','1px solid green');
        $(".wofpaid_per").fadeOut(200);
        paidPerError=false;
    }
});
    
    $("#month_paid").blur(function (){
    if(formCalculate.month_paid.selectedIndex == 0){
        $(this).css('border','1px solid #f00');
        $(".wofmdate").fadeIn(200);
        monthError=true;
    }else{
        $(this).css('border','1px solid green');
        $(".wofmdate").fadeOut(200);
        monthError=false;
    }
});
    
     $("#week_paid").blur(function (){
    if(formCalculate.week_paid.selectedIndex == 0){
        $(this).css('border','1px solid #f00');
        $(".wofwdate").fadeIn(200);
        weekError=true;
    }else{
        $(this).css('border','1px solid green');
        $(".wofwdate").fadeOut(200);
        weekError=false;
    }
});
    
    $("#form_calculate").submit(function (e){
    if(salaryError === true || salaryPerError===true || taxCodeError===true || paidPerError===true){
        e.preventDefault();
        $("#salary, #salare_per, #tax_code,#type_paid, #month_paid, #week_paid").blur();
        
    }
    });
    
   
});




