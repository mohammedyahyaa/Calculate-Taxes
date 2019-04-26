<%-- 
    Document   : calculate
    Author     : Dell
--%>




<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="model.calculateData"%>
<%@page import="DataBase_connection.DataBase"%>
<%@page import="java.io.PrintWriter"%>
<%@ page errorPage="error.jsp" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='animationPage.css' rel='stylesheet' type='text/css'>
        <link href='fonts.css' rel='stylesheet' type='text/css'>
        <title>JSP Page</title>
        <style>
            body{
                background-image: url(images/signup_new.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }
            *{
                font-family: "open sans";
            }
            .result{
                width: 250px;
                height: 120px;
                padding-top: 1px;
                padding-left: 13px;
                background-color: #fbb405;
                border-radius: 10px;
                margin:20% 0px 0px 37%;
            }
            #h3{
                color: #0f1c41;
                text-align: center;
                margin-bottom: 0px;
                font-size: 20px;
            }
            #label{
                color: #fff;
            }
            #show{
                color: #0f1c41;
                width: 120px;
                height: 25px;
                background-color: #0f1c41;
                padding-left: 5px;
                padding-top: 2px;
                padding-bottom: 2px;
                color: #fff;
                border-radius: 10px;
                margin-left: 5px;
            }
        </style>
    </head>
    <body>


        <%!
            public static Statement st;
            static double tax;
            static double Totalpay;
            static double column1MonthValue;
            static double column2MonthValue;
            static double column3MonthValue;
            static double column1WeekValue;
            static double column2WeekValue;
            static double column3WeekValue;
            static double reminderNumbers;
            static double singleNumbers;
            static double taxValue1;
            static double taxValue2;
            static double totalTaxValue;
            static double column4MonthValue;
            static double column5MonthValue;
            static double column4WeekValue;
            static double column5WeekValue;


        %>

        <%

            calculateData data = new calculateData();

            double salary = Double.parseDouble(request.getParameter("salary"));
            String salaryPer = request.getParameter("salary_per");
            String taxCode = request.getParameter("tax_code");

            data.setSalary(salary);
            data.setSalaryPer(salaryPer);
            data.setTaxCode(taxCode);

            DataBase db = new DataBase();

            st = db.getconnection().createStatement();

            String monthDate = request.getParameter("month_paid");
            String q = "select * from period_type_chart where period='" + monthDate + "'";
            ResultSet resultSet = st.executeQuery(q);

            resultSet.beforeFirst();

            while (resultSet.next()) {

                data.setMonthNumberOrWeek(resultSet.getInt("Number"));
            }

            st = db.getconnection().createStatement();

            String weekDate = request.getParameter("week_paid");
            String que = "select * from period_type_chart where period='" + weekDate + "'";
            resultSet = st.executeQuery(que);

            resultSet.beforeFirst();

            while (resultSet.next()) {

                data.setMonthNumberOrWeek(resultSet.getInt("Number"));

            }

            /// throw exception for negative salary to create error page  
            if (data.getSalary() < 0) {

                throw new IOException("You have entered a negative number");
            }
            if (data.getSalary() == 0) {

                throw new IOException("You have entered invalid number such as zero ");
            }

            if (data.getTaxCode().equals("BR") || data.getTaxCode().equals("SBR") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                tax = Math.round(Totalpay) * 0.20;
                tax = tax / data.getMonthNumberOrWeek();

            } else if (data.getTaxCode().equals("BR") || data.getTaxCode().equals("SBR") && data.getSalaryPer().equals("week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                tax = Math.round(Totalpay) * 0.20;
                tax = tax / data.getMonthNumberOrWeek();

                //Do for mooooooooooooooooooooooonth  
            } else if (data.getTaxCode().equals("D0") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que2 = "select * from tablec1_monthlypaid  where month='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet2 = st.executeQuery(que2);

                while (resultSet2.next()) {

                    column1MonthValue = resultSet2.getInt("column1");
                    column2MonthValue = resultSet2.getInt("column2");
                    column3MonthValue = resultSet2.getInt("column3");
 
                }

                if (Totalpay > column1MonthValue && Totalpay < column2MonthValue) {

                    Totalpay = Totalpay - column1MonthValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                    } catch (SQLException sql) {

                    }

                    try {
                        String que4 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet4 = st.executeQuery(que4);

                        while (resultSet4.next()) {

                            taxValue2 = resultSet4.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column3MonthValue;
                    Totalpay = totalTaxValue;
                    tax = Totalpay / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column1MonthValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que5 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet5 = st.executeQuery(que5);

                        while (resultSet5.next()) {

                            taxValue1 = resultSet5.getInt("tax");

                        }
                    } catch (SQLException sqle) {

                    }

                    try {
                        String que6 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet6 = st.executeQuery(que6);

                        while (resultSet6.next()) {

                            taxValue2 = resultSet6.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

                // Do for weeeeeeeeeeeeeeeeeeeeeeeek 
            } else if (data.getTaxCode().equals("D0") && data.getSalaryPer().equals("Week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que7 = "select * from tablec1_weeklypaid  where week='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet7 = st.executeQuery(que7);

                while (resultSet7.next()) {

                    column1WeekValue = resultSet7.getInt("column1");
                    column2WeekValue = resultSet7.getInt("column2");
                    column3WeekValue = resultSet7.getInt("column3");

                }

                if (Totalpay > column1WeekValue && Totalpay < column2WeekValue) {

                    Totalpay = Totalpay - column1WeekValue;

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que8 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet8 = st.executeQuery(que8);

                        while (resultSet8.next()) {

                            taxValue1 = resultSet8.getInt("tax");

                        }
                    } catch (SQLException sql) {

                    }

                    try {
                        String que9 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet9 = st.executeQuery(que9);

                        while (resultSet9.next()) {

                            taxValue2 = resultSet9.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column3WeekValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column1WeekValue;

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que10 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet10 = st.executeQuery(que10);

                        while (resultSet10.next()) {

                            taxValue1 = resultSet10.getInt("tax");

                        }
                    } catch (SQLException sqle) {

                    }

                    try {
                        String que11 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet11 = st.executeQuery(que11);

                        while (resultSet11.next()) {

                            taxValue2 = resultSet11.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

            } // ٍSDO for month 
            else if (data.getTaxCode().equals("SD0") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();

                Totalpay = Math.round(Totalpay);
                String que7 = "select * from tablec1_scottish_monthlypaid  where month='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet7 = st.executeQuery(que7);

                while (resultSet7.next()) {

                    column1MonthValue = resultSet7.getInt("column1");
                    column2MonthValue = resultSet7.getInt("column2");
                    column3MonthValue = resultSet7.getInt("column3");

                }

                if (Totalpay > column1MonthValue && Totalpay < column2MonthValue) {

                    Totalpay = Totalpay - column1MonthValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled1_scottishhigherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                    } catch (SQLException sql) {

                    }

                    try {
                        String que4 = "select * from tabled1_scottishhigherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet4 = st.executeQuery(que4);

                        while (resultSet4.next()) {

                            taxValue2 = resultSet4.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column3MonthValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column1MonthValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que5 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet5 = st.executeQuery(que5);

                        while (resultSet5.next()) {

                            taxValue1 = resultSet5.getInt("tax");

                        }
                    } catch (SQLException sqle) {

                    }

                    try {
                        String que6 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet6 = st.executeQuery(que6);

                        while (resultSet6.next()) {

                            taxValue2 = resultSet6.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

                //// sD0 for weeeeeeeeeeek   
            } else if (data.getTaxCode().equals("SD0") && data.getSalaryPer().equals("Week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que7 = "select * from tablec1_scottish_weeklypaid  where week='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet7 = st.executeQuery(que7);

                while (resultSet7.next()) {

                    column1WeekValue = resultSet7.getInt("column1");
                    column2WeekValue = resultSet7.getInt("column2");
                    column3WeekValue = resultSet7.getInt("column3");

                }

                if (Totalpay > column1WeekValue && Totalpay < column2WeekValue) {

                    Totalpay = Totalpay - column1WeekValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que8 = "select * from tabled1_scottishhigherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet8 = st.executeQuery(que8);

                        while (resultSet8.next()) {

                            taxValue1 = resultSet8.getInt("tax");

                        }
                    } catch (SQLException sql) {

                    }

                    try {
                        String que9 = "select * from tabled1_scottishhigherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet9 = st.executeQuery(que9);

                        while (resultSet9.next()) {

                            taxValue2 = resultSet9.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column3WeekValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column1WeekValue;                                   // may be exception happens 

                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que10 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet10 = st.executeQuery(que10);

                        while (resultSet10.next()) {

                            taxValue1 = resultSet10.getInt("tax");

                        }
                    } catch (SQLException sqle) {

                    }

                    try {
                        String que11 = "select * from tabled1_higherrate_taxat40  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet11 = st.executeQuery(que11);

                        while (resultSet11.next()) {

                            taxValue2 = resultSet11.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

            } // D1 for mooooooooooooooonth 
            else if (data.getTaxCode().equals("D1") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que2 = "select * from tablec2_monthlypaid  where month='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet2 = st.executeQuery(que2);

                while (resultSet2.next()) {

                    column4MonthValue = resultSet2.getInt("column4");
                    column5MonthValue = resultSet2.getInt("column5");

                }

                if (Totalpay > column4MonthValue) {

                    Totalpay = Totalpay - column4MonthValue;
                    singleNumbers = Totalpay % 1000;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {

                    }//////////////////////
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue2 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {

                    }
                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column5MonthValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column4MonthValue;
                    singleNumbers = Totalpay % 1000;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {
                    }//////////////////////
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue2 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }

                    totalTaxValue = taxValue1 + taxValue2;

                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

            } ///////// D1 for weeeeeeeeeeeeeeeeeeeeeeek 
            else if (data.getTaxCode().equals("D1") && data.getSalaryPer().equals("Week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que2 = "select * from tablec2_weeklypaid  where week='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet2 = st.executeQuery(que2);

                while (resultSet2.next()) {

                    column4WeekValue = resultSet2.getInt("column4");
                    column5WeekValue = resultSet2.getInt("column5");

                }

                if (Totalpay > column4WeekValue) {

                    Totalpay = Totalpay - column4WeekValue;
                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue2 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }
                    totalTaxValue = taxValue1 + taxValue2;
                    totalTaxValue = totalTaxValue + column5WeekValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();
                } else {

                    Totalpay = Totalpay - column4WeekValue;
                    singleNumbers = Totalpay % 100;

                    reminderNumbers = Totalpay - singleNumbers;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + singleNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + reminderNumbers + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue2 = resultSet3.getInt("tax");

                        }

                    } catch (SQLException sqle) {
                    }
                    totalTaxValue = taxValue1 + taxValue2;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();
                }

                ///// SD1 for moooooooooooooonth
            } else if (data.getTaxCode().equals("SD1") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que2 = "select * from tablec2_scottish_monthlypaid  where month='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet2 = st.executeQuery(que2);

                while (resultSet2.next()) {

                    column4MonthValue = resultSet2.getInt("column4");
                    column5MonthValue = resultSet2.getInt("column5");

                }

                if (Totalpay > column4MonthValue) {

                    Totalpay = Totalpay - column4MonthValue;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + Totalpay + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {

                    }//////////////////////

                    totalTaxValue = taxValue1;
                    totalTaxValue = totalTaxValue + column5MonthValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column4MonthValue;
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + Totalpay + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {
                    }//////////////////////

                    totalTaxValue = taxValue1;

                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

            } //// SD1 for weeeeeeeeeeeeeeeeek 
            else if (data.getTaxCode().equals("SD1") && data.getSalaryPer().equals("Week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();
                Totalpay = Math.round(Totalpay);
                String que2 = "select * from tablec2_scottish_weeklypaid  where week='" + data.getMonthNumberOrWeek() + "'";
                ResultSet resultSet2 = st.executeQuery(que2);

                while (resultSet2.next()) {

                    column4WeekValue = resultSet2.getInt("column4");
                    column5WeekValue = resultSet2.getInt("column5");

                }

                if (Totalpay > column4WeekValue) {

                    Totalpay = Totalpay - column4WeekValue;

                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + Totalpay + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {

                    }//////////////////////

                    totalTaxValue = taxValue1;
                    totalTaxValue = totalTaxValue + column5WeekValue;
                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                } else {

                    Totalpay = Totalpay - column4WeekValue;
                    try {
                        String que3 = "select * from tabled2_additionalrate_taxat45  where taxablePay='" + Totalpay + "'";
                        ResultSet resultSet3 = st.executeQuery(que3);

                        while (resultSet3.next()) {

                            taxValue1 = resultSet3.getInt("tax");

                        }
                        //Totalpay = totalTaxValue + column5MonthValue;
                    } catch (SQLException sqle) {
                    }//////////////////////

                    totalTaxValue = taxValue1;

                    tax = totalTaxValue / data.getMonthNumberOrWeek();

                }

            } else if (data.getTaxCode().equals("OTHER") && data.getSalaryPer().equals("Month")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();

                Totalpay = Totalpay - Totalpay * 0.10;;
                tax = Totalpay / data.getMonthNumberOrWeek();

            } else if (data.getTaxCode().equals("OTHER") && data.getSalaryPer().equals("Week")) {

                Totalpay = data.getSalary() * data.getMonthNumberOrWeek();

                Totalpay = Totalpay - Totalpay * 0.10;;
                tax = Totalpay / data.getMonthNumberOrWeek();

            }


        %>




        <div class="result">
            <p id="h3">Result..</p>
            <table>
                <tr>
                    <td><p id="label">Pay to date:</p></td>
                    <td><p id="show"><%=Math.ceil(tax)%></p></td>
                </tr>
            </table>
        </div>







    </body>
</html>
