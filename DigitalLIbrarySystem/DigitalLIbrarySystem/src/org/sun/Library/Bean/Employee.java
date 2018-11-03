package org.sun.Library.Bean;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed_Aljazwiee
 */
public class Employee {
public static final  String Mail="Mail";
public static final  String FMail="FMail";
    private String employee_Name = "No Employee Found";
    private String employee_Gender = "No Gender Found";
    private String employee_Salary = "NO salary Found";

    public Employee() {
        
    }

    public Employee(String Employee_Name, String Employee_Gender, String Employee_Salary) {
        setEmployee_Name(Employee_Name);
        setEmployee_Gender(Employee_Gender);
        setEmployee_Salary(Employee_Salary);
    }
    
    public void setEmployee_Name(String Employee_Name) {
        this.employee_Name = Employee_Name;
    }

    public void setEmployee_Gender(String Employee_Gender) {
        this.employee_Gender = Employee_Gender;
    }

    public void setEmployee_Salary(String Employee_Salary) {
        this.employee_Salary = Employee_Salary;
    }
  public String getEmployee_Name()
  {
      return this.employee_Name;
  }
  public String getEmployee_Gender()
  {
      return this.employee_Gender;
  }
  public String getEmolyee_Salary()
  {
      return this.employee_Salary;
  }
}
