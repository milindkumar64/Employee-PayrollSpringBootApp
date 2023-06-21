package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Milind",30000)));
        return empDataList;
    }
    @Override
    public EmployeePayrollData getEmployeeDataById(int empId) {
        EmployeePayrollData empPayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Milind", 30000));
        return empPayrollData;
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empPayrollData = new EmployeePayrollData(1,empPayrollDTO);
        return empPayrollData;
    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empPayrollData = new EmployeePayrollData(1,empPayrollDTO);
        return empPayrollData;
    }
    @Override
    public void deleteEmployeePayrollData(int empId) {
    }
}
