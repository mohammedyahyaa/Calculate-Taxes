/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/validation"})
public class validation extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/plain");
        
        int salary=Integer.parseInt(request.getParameter("salary"));
        String salaryPer=request.getParameter("salary_per");
        String taxCode=request.getParameter("tax_code");
        String paidPer=request.getParameter("paid_per");
        String month=request.getParameter("month_paid");
        //String week=request.getParameter("week_paid");
        
        PrintWriter out=response.getWriter();
        
        out.println(salary);
        out.println(salaryPer);
        out.println(taxCode);
        out.println(paidPer);
        out.println(month);

        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
