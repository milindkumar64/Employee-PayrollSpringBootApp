package com.bridgelabz.employeepayroll.model;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
@AllArgsConstructor
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    public List<String> departments;

    public EmployeePayrollData(){}

    public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO){
//        this.employeeId = empId;
//        this.name = empPayrollDTO.getName();
//        this.salary=empPayrollDTO.getSalary();
//        this.gender=empPayrollDTO.gender;
//        this.note=empPayrollDTO.note;
//        this.startDate=empPayrollDTO.startDate;
//        this.profilePic=empPayrollDTO.profilePic;
//        this.departments=empPayrollDTO.department;

        this.updateEmployeePayrollData(empPayrollDTO);
    }
    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){

        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.note=employeePayrollDTO.note;
        this.startDate=employeePayrollDTO.startDate;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.department;
    }
}
