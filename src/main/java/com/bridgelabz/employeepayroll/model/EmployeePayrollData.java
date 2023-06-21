package com.bridgelabz.employeepayroll.model;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;

@Data
public class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;
    public EmployeePayrollData(){}

    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO){
        this.employeeId = empId;
        this.name = empPayrollDTO.getName();
        this.salary=empPayrollDTO.getSalary();
    }
}
