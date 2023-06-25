package com.bridgelabz.employeepayroll.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee name Invalid")
    String name;
    @Size(min = 20000,max = 100000,message ="Sorry bro!,ur salary is too less like TCS employee")
    long salary;
}
