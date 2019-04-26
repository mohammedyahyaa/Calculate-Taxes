<%-- 
    Document   : newjsp
    Created on : May 1, 2018, 6:19:35 PM
    Author     : Dell
--%>

<%@page import="com.sun.xml.rpc.processor.modeler.j2ee.xml.string"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html class="animated fadeIn">
    
<head>
	<title>Payroll</title>
        <link rel="icon" href="images/logo.png">
	<meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style_logInOfEmployee.css">
    <link href='fonts.css' rel='stylesheet' type='text/css'>
    <link href='animationPage.css' rel='stylesheet' type='text/css'>
</head>
    
<body onload="showNote()">
        <div class="mainDiv">
            <!--<div class="left">
                <img src="images/logo.png" class="img">
                <p>(Simple Way To Manegmment Your Payroll)</p>
            </div>-->
            <div  id="dnote">
                    <p id="note"><span style="font-weight: bold;color:red">Note: </span>"This Salary Per" option must be same "Paid Per" option.</p>
                    <button class="buttonOk">OK</button>
                </div>
            <div class="right">
                <p class="title">Calculate Your<span style="color: #fbb405"> Tax </span></p>
                <form action="calculate.jsp"  method="post"  name="formCalculate" id="form_calculate">
                    <div> 
                        <input type="text" name="salary" placeholder="salary" id="salary" ><!--onblur="validate('salary', this.value)"-->
                        <p id="warning" class="wofsal" style=" font-weight: bold">This filde is requierd</p>
                    </div>
                    <div id="hor">
                        <p id="lable">This salary per</p> 
                        <select id="salare_per" name="salary_per" style="margin-left: 42px">
                        <option value="">Select</option>    
                        <option>Month</option>
                        <option>Week</option>
                        </select>
                        
                    </div>
                    <p id="warning" class="wofsal_per" style=" font-weight: bold">This filde is requierd</p>
                    <div id="hor">
                        <p id="lable">Tax code</p> 
                        <select id="tax_code" name="tax_code" style="margin-left: 95px">
                        <option value="">Select</option>
                        <option>BR</option>
                        <option>D0</option>
                        <option>D1</option>
                        <option>SBR</option>
                        <option>SD0</option>
                        <option>SD1</option>
                        <option>OTHER</option>
                    </select>
                        
                    </div>
                    <p id="warning" class="woftax_code" style=" font-weight: bold">This filde is requierd</p>
                    <div id="hor">
                        <p id="lable">Paid per</p> 
                        <select id="type_paid" name="paid_per" style="margin-left:100px" onchange="onChange();">
                            <option value="">Select</option>
                            <option>Month</option>
                            <option>Week</option>
                        </select>
                        
                    </div>
                    <p id="warning" class="wofpaid_per" style=" font-weight: bold">This filde is requierd</p>
                    <div id="hor" style="display: none" class="month">
                    <p id="lable">Select the date</p> 
                    <select id="month_paid" name="month_paid" style="margin-left: 40px">
                        
                        <option value="">Select</option>
                        <option>6 April to 5 May</option>
                        <option>6 May to 5 June</option>
                        <option>6 June to 5 July</option>
                        <option>6 July to 5 August</option>
                        <option>6 August to 5 September</option>
                        <option>6 September to 5 October</option>
                        <option>6 October to 5 November</option>
                        <option>6 November to 5 December</option>
                        <option>6 December to 5 January</option>
                        <option>6 January to 5 February</option>
                        <option>6 February to 5 March</option>
                        <option>6 March to 5 April</option>
                        
                    </select>
                    <div style="float: right"><p id="war_date" class="wofmdate" style=" font-weight: bold">This filde is requierd</p></div>
                    </div>
                   
                    <div id="hor" style="display: none" class="week">
                    <p id="lable">Select the date</p> 
                    <select id="week_paid" name="week_paid" style="margin-left: 40px">
                        
                        <option value="">Select</option>
                        <option>6 april to 12 april</option>
                        <option>13 Apr to 19 Apr</option>
                        <option>20 Apr to 26Apr</option>
                        <option>27 Apr to 3 May</option>
                        <option>4 May to 10 May</option>
                        <option>11 May to 17 May</option>
                        <option>18 May to 24 May</option>
                        <option>25 May to 31 May</option>
                        <option>1 Jun to 7 Jun</option>
                        <option>8 Jun to 14 Jun</option>
                        <option>15 Jun to 21 Jun</option>
                        <option>22 Jun to 28 Jun</option>
                        <option>29 Jun to 5 Jul</option>
                        <option>6 Jul to 12 Jul</option>
                        <option>20 Jul to 26 Jul</option>
                        <option>27 Jul to 2 Aug</option>
                        <option>3 Aug to 9 Aug</option>
                        <option>10 Aug to 16 Aug</option>
                        <option>17 Aug to 23 Aug</option>
                        <option>24 Aug to 30 Aug</option>
                        <option>31 Aug to 6 Sep</option>
                        <option>7 Sep to 13 Sep</option>
                        <option>14 Sep to 20 Sep</option>
                        <option>21 Sep to 27 Sep</option>
                        <option>28 Sep to 4 Oct</option>
                        <option>5 Oct to 11 Oct</option>
                        <option>12 Oct to 18 Oct</option>
                        <option>19 Oct to 25 Oct</option>
                        <option>26 Oct to 1 Nov</option>
                        <option>2 Nov to 8 Nov</option>
                        <option>9 Nov to 15 Nov</option>
                        <option>16 Nov to 22 Nov</option>
                        <option>23 Nov to 29 Nov</option>
                        <option>30 Nov to 6 Dec</option>
                        <option>7 Dec to 13 Dec</option>
                        <option>14 Dec to 20 Dec</option>
                        <option>21 Dec to 27 Dec</option>
                        <option>28 Dec to 3 Jan</option>
                        <option>4 Jan to 10 Jan</option>
                        <option>11 Jan to 17 Jan</option>
                        <option>18 Jan to 24 Jan</option>
                        <option>25 Jan to 31 Jan</option>
                        <option>1 Feb to 7 Feb</option>
                        <option>8 Feb to 14 Feb</option>
                        <option>15 Feb to 21 Feb</option>
                        <option>22 Feb to 28 Feb</option>
                        <option>1 Mar to 7 Mar</option>
                        <option>8 Mar to 14 Mar</option>
                        <option>15 Mar to 21 Mar</option>
                        <option>22 Mar to 28 Mar</option>
                        <option>29 Mar to 4 Apr</option>
               
                    </select>
                    <div style="float: right"> <p id="war_date" class="wofwdate" style=" font-weight: bold">This filde is requierd</p></div>
                    </div>
                   
                    <input type="submit" value="Calculate" class="button" name="calculate_button">
                </form>
                <p id="message"></p>
                
            </div>
        </div>
        <script src="query.js"></script>
        <script src="scriptOFLogInOfEmployee.js"></script>
        <script src="ajaxVali.js"></script>
    </body>
</html>
