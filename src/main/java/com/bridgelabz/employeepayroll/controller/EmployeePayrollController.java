package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping("/get") // by default it will take GetMethod
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get call successful",empDataList );
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId){
        EmployeePayrollData empData = employeePayrollService.getEmployeeDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get call for ID successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department){
        List<EmployeePayrollData> empDataList=employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO= new ResponseDTO("Get departments for employee: ",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO ){
        log.info("Employee DTO: "+empPayrollDTO.toString());
        EmployeePayrollData empPayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Pyroll data sucessfully",empPayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable int empId, @RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empPayrollData = employeePayrollService.updateEmployeePayrollData((empId),empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll data Sucessful",empPayrollData);
        return new ResponseEntity<>(respDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO =new ResponseDTO("Deleted sucessfull","deleted id : "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
}
