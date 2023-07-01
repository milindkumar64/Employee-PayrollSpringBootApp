package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
       return employeeRepository.findAll();
        // return employeePayrollList;
    }
    @Override
    public EmployeePayrollData getEmployeeDataById(int empId) {
        // return employeePayrollList.get(empId-1);
//        return employeePayrollList.stream()
//                .filter(empData -> empData.getEmployeeId()==empId)
//                .findFirst()
//                .orElseThrow(() -> new EmployeePayrollException("Employee Not found"));

        return employeeRepository.findById(empId).orElseThrow(()-> new EmployeePayrollException("Employee with employee id "+empId+" does not exists !!"));
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
        //employeePayrollList.add(empData);
        log.debug("Emp data : "+ empData.toString());
        return employeeRepository.save(empData);
    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empPayrollData = this.getEmployeeDataById(empId);
        empPayrollData.updateEmployeePayrollData(empPayrollDTO);
//        empPayrollData.setName(empPayrollDTO.getName());
//        empPayrollData.setSalary(empPayrollData.getSalary());
//        employeePayrollList.set(empId-1,empPayrollData);
        return employeeRepository.save(empPayrollData);
    }
    @Override
    public void deleteEmployeePayrollData(int empId) {

        EmployeePayrollData employeeData = this.getEmployeeDataById(empId);
        employeeRepository.delete(employeeData);
                // employeePayrollList.remove(empId-1);
    }
    public List<EmployeePayrollData> getEmployeesByDepartment(String department){
        return employeeRepository.findEmployeesByDepartment(department);
    }
}
