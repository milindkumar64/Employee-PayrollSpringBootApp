package com.bridgelabz.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {
    String name;
    long salary;
}
