package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }
    @Override
    public EmployeePayrollData getEmployeeDataById(int empId) {
        // return employeePayrollList.get(empId-1);
        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeId()==empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not found"));
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
        employeePayrollList.add(empData);
        return employeeRepository.save(empData);
    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empPayrollData = this.employeePayrollList.get(empId-1);
        empPayrollData.setName(empPayrollDTO.getName());
        empPayrollData.setSalary(empPayrollData.getSalary());
        employeePayrollList.set(empId-1,empPayrollData);
        return empPayrollData;
    }
    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
