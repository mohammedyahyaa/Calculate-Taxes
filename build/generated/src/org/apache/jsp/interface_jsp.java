package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

public final class interface_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      			null, true, 8192, true);
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
      out.write("<!DOCTYPE>\n");
      out.write("<html class=\"animated fadeIn\">\n");
      out.write("    \n");
      out.write("<head>\n");
      out.write("\t<title>Payroll</title>\n");
      out.write("        <link rel=\"icon\" href=\"images/logo.png\">\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style_logInOfEmployee.css\">\n");
      out.write("    <link href='fonts.css' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='animationPage.css' rel='stylesheet' type='text/css'>\n");
      out.write("</head>\n");
      out.write("    \n");
      out.write("<body onload=\"showNote()\">\n");
      out.write("        <div class=\"mainDiv\">\n");
      out.write("            <!--<div class=\"left\">\n");
      out.write("                <img src=\"images/logo.png\" class=\"img\">\n");
      out.write("                <p>(Simple Way To Manegmment Your Payroll)</p>\n");
      out.write("            </div>-->\n");
      out.write("            <div  id=\"dnote\">\n");
      out.write("                    <p id=\"note\"><span style=\"font-weight: bold;color:red\">Note: </span>\"This Salary Per\" option must be same \"Paid Per\" option.</p>\n");
      out.write("                    <button class=\"buttonOk\">OK</button>\n");
      out.write("                </div>\n");
      out.write("            <div class=\"right\">\n");
      out.write("                <p class=\"title\">Calculate Your<span style=\"color: #fbb405\"> Tax </span></p>\n");
      out.write("                <form action=\"calculate.jsp\"  method=\"post\"  name=\"formCalculate\" id=\"form_calculate\">\n");
      out.write("                    <div> \n");
      out.write("                        <input type=\"text\" name=\"salary\" placeholder=\"salary\" id=\"salary\" ><!--onblur=\"validate('salary', this.value)\"-->\n");
      out.write("                        <p id=\"warning\" class=\"wofsal\" style=\" font-weight: bold\">This filde is requierd</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"hor\">\n");
      out.write("                        <p id=\"lable\">This salary per</p> \n");
      out.write("                        <select id=\"salare_per\" name=\"salary_per\" style=\"margin-left: 42px\">\n");
      out.write("                        <option value=\"\">Select</option>    \n");
      out.write("                        <option>Month</option>\n");
      out.write("                        <option>Week</option>\n");
      out.write("                        </select>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <p id=\"warning\" class=\"wofsal_per\" style=\" font-weight: bold\">This filde is requierd</p>\n");
      out.write("                    <div id=\"hor\">\n");
      out.write("                        <p id=\"lable\">Tax code</p> \n");
      out.write("                        <select id=\"tax_code\" name=\"tax_code\" style=\"margin-left: 95px\">\n");
      out.write("                        <option value=\"\">Select</option>\n");
      out.write("                        <option>BR</option>\n");
      out.write("                        <option>D0</option>\n");
      out.write("                        <option>D1</option>\n");
      out.write("                        <option>SBR</option>\n");
      out.write("                        <option>SD0</option>\n");
      out.write("                        <option>SD1</option>\n");
      out.write("                        <option>OTHER</option>\n");
      out.write("                    </select>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <p id=\"warning\" class=\"woftax_code\" style=\" font-weight: bold\">This filde is requierd</p>\n");
      out.write("                    <div id=\"hor\">\n");
      out.write("                        <p id=\"lable\">Paid per</p> \n");
      out.write("                        <select id=\"type_paid\" name=\"paid_per\" style=\"margin-left:100px\" onchange=\"onChange();\">\n");
      out.write("                            <option value=\"\">Select</option>\n");
      out.write("                            <option>Month</option>\n");
      out.write("                            <option>Week</option>\n");
      out.write("                        </select>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <p id=\"warning\" class=\"wofpaid_per\" style=\" font-weight: bold\">This filde is requierd</p>\n");
      out.write("                    <div id=\"hor\" style=\"display: none\" class=\"month\">\n");
      out.write("                    <p id=\"lable\">Select the date</p> \n");
      out.write("                    <select id=\"month_paid\" name=\"month_paid\" style=\"margin-left: 40px\">\n");
      out.write("                        \n");
      out.write("                        <option value=\"\">Select</option>\n");
      out.write("                        <option>6 April to 5 May</option>\n");
      out.write("                        <option>6 May to 5 June</option>\n");
      out.write("                        <option>6 June to 5 July</option>\n");
      out.write("                        <option>6 July to 5 August</option>\n");
      out.write("                        <option>6 August to 5 September</option>\n");
      out.write("                        <option>6 September to 5 October</option>\n");
      out.write("                        <option>6 October to 5 November</option>\n");
      out.write("                        <option>6 November to 5 December</option>\n");
      out.write("                        <option>6 December to 5 January</option>\n");
      out.write("                        <option>6 January to 5 February</option>\n");
      out.write("                        <option>6 February to 5 March</option>\n");
      out.write("                        <option>6 March to 5 April</option>\n");
      out.write("                        \n");
      out.write("                    </select>\n");
      out.write("                    <div style=\"float: right\"><p id=\"war_date\" class=\"wofmdate\" style=\" font-weight: bold\">This filde is requierd</p></div>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <div id=\"hor\" style=\"display: none\" class=\"week\">\n");
      out.write("                    <p id=\"lable\">Select the date</p> \n");
      out.write("                    <select id=\"week_paid\" name=\"week_paid\" style=\"margin-left: 40px\">\n");
      out.write("                        \n");
      out.write("                        <option value=\"\">Select</option>\n");
      out.write("                        <option>6 april to 12 april</option>\n");
      out.write("                        <option>13 Apr to 19 Apr</option>\n");
      out.write("                        <option>20 Apr to 26Apr</option>\n");
      out.write("                        <option>27 Apr to 3 May</option>\n");
      out.write("                        <option>4 May to 10 May</option>\n");
      out.write("                        <option>11 May to 17 May</option>\n");
      out.write("                        <option>18 May to 24 May</option>\n");
      out.write("                        <option>25 May to 31 May</option>\n");
      out.write("                        <option>1 Jun to 7 Jun</option>\n");
      out.write("                        <option>8 Jun to 14 Jun</option>\n");
      out.write("                        <option>15 Jun to 21 Jun</option>\n");
      out.write("                        <option>22 Jun to 28 Jun</option>\n");
      out.write("                        <option>29 Jun to 5 Jul</option>\n");
      out.write("                        <option>6 Jul to 12 Jul</option>\n");
      out.write("                        <option>20 Jul to 26 Jul</option>\n");
      out.write("                        <option>27 Jul to 2 Aug</option>\n");
      out.write("                        <option>3 Aug to 9 Aug</option>\n");
      out.write("                        <option>10 Aug to 16 Aug</option>\n");
      out.write("                        <option>17 Aug to 23 Aug</option>\n");
      out.write("                        <option>24 Aug to 30 Aug</option>\n");
      out.write("                        <option>31 Aug to 6 Sep</option>\n");
      out.write("                        <option>7 Sep to 13 Sep</option>\n");
      out.write("                        <option>14 Sep to 20 Sep</option>\n");
      out.write("                        <option>21 Sep to 27 Sep</option>\n");
      out.write("                        <option>28 Sep to 4 Oct</option>\n");
      out.write("                        <option>5 Oct to 11 Oct</option>\n");
      out.write("                        <option>12 Oct to 18 Oct</option>\n");
      out.write("                        <option>19 Oct to 25 Oct</option>\n");
      out.write("                        <option>26 Oct to 1 Nov</option>\n");
      out.write("                        <option>2 Nov to 8 Nov</option>\n");
      out.write("                        <option>9 Nov to 15 Nov</option>\n");
      out.write("                        <option>16 Nov to 22 Nov</option>\n");
      out.write("                        <option>23 Nov to 29 Nov</option>\n");
      out.write("                        <option>30 Nov to 6 Dec</option>\n");
      out.write("                        <option>7 Dec to 13 Dec</option>\n");
      out.write("                        <option>14 Dec to 20 Dec</option>\n");
      out.write("                        <option>21 Dec to 27 Dec</option>\n");
      out.write("                        <option>28 Dec to 3 Jan</option>\n");
      out.write("                        <option>4 Jan to 10 Jan</option>\n");
      out.write("                        <option>11 Jan to 17 Jan</option>\n");
      out.write("                        <option>18 Jan to 24 Jan</option>\n");
      out.write("                        <option>25 Jan to 31 Jan</option>\n");
      out.write("                        <option>1 Feb to 7 Feb</option>\n");
      out.write("                        <option>8 Feb to 14 Feb</option>\n");
      out.write("                        <option>15 Feb to 21 Feb</option>\n");
      out.write("                        <option>22 Feb to 28 Feb</option>\n");
      out.write("                        <option>1 Mar to 7 Mar</option>\n");
      out.write("                        <option>8 Mar to 14 Mar</option>\n");
      out.write("                        <option>15 Mar to 21 Mar</option>\n");
      out.write("                        <option>22 Mar to 28 Mar</option>\n");
      out.write("                        <option>29 Mar to 4 Apr</option>\n");
      out.write("               \n");
      out.write("                    </select>\n");
      out.write("                    <div style=\"float: right\"> <p id=\"war_date\" class=\"wofwdate\" style=\" font-weight: bold\">This filde is requierd</p></div>\n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                    <input type=\"submit\" value=\"Calculate\" class=\"button\" name=\"calculate_button\">\n");
      out.write("                </form>\n");
      out.write("                <p id=\"message\"></p>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"query.js\"></script>\n");
      out.write("        <script src=\"scriptOFLogInOfEmployee.js\"></script>\n");
      out.write("        <script src=\"ajaxVali.js\"></script>\n");
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
