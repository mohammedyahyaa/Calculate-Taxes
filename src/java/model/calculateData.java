/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */
public class calculateData {
    
    private double salary ; 
    private String salaryPer ; 
    private String taxCode ;
    private String paidType ; 
    
    private int monthNumberOrWeek;

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the salaryPer
     */
    public String getSalaryPer() {
        return salaryPer;
    }

    /**
     * @param salaryPer the salaryPer to set
     */
    public void setSalaryPer(String salaryPer) {
        this.salaryPer = salaryPer;
    }

    /**
     * @return the taxCode
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * @param taxCode the taxCode to set
     */
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    /**
     * @return the paidType
     */
    public String getPaidType() {
        return paidType;
    }

    /**
     * @param paidType the paidType to set
     */
    public void setPaidType(String paidType) {
        this.paidType = paidType;
    }

    /**
     * @return the date
     */
   

    /**
     * @return the monthNumber
     */
    public int getMonthNumberOrWeek() {
        return monthNumberOrWeek;
    }

    
    public void setMonthNumberOrWeek (int MonthNumberOrWeek) {
        this.monthNumberOrWeek = MonthNumberOrWeek;
    }
}
