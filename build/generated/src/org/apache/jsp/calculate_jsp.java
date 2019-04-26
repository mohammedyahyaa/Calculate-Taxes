package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.calculateData;
import DataBase_connection.DataBase;
import java.io.PrintWriter;

public final class calculate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


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


        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href='animationPage.css' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='fonts.css' rel='stylesheet' type='text/css'>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-image: url(images/signup_new.jpg);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("            *{\n");
      out.write("                font-family: \"open sans\";\n");
      out.write("            }\n");
      out.write("            .result{\n");
      out.write("                width: 250px;\n");
      out.write("                height: 120px;\n");
      out.write("                padding-top: 1px;\n");
      out.write("                padding-left: 13px;\n");
      out.write("                background-color: #fbb405;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                margin:20% 0px 0px 37%;\n");
      out.write("            }\n");
      out.write("            #h3{\n");
      out.write("                color: #0f1c41;\n");
      out.write("                text-align: center;\n");
      out.write("                margin-bottom: 0px;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            #label{\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("            #show{\n");
      out.write("                color: #0f1c41;\n");
      out.write("                width: 120px;\n");
      out.write("                height: 25px;\n");
      out.write("                background-color: #0f1c41;\n");
      out.write("                padding-left: 5px;\n");
      out.write("                padding-top: 2px;\n");
      out.write("                padding-bottom: 2px;\n");
      out.write("                color: #fff;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                margin-left: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");


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


        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"result\">\n");
      out.write("            <p id=\"h3\">Result..</p>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><p id=\"label\">Pay to date:</p></td>\n");
      out.write("                    <td><p id=\"show\">");
      out.print(Math.ceil(tax));
      out.write("</p></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
