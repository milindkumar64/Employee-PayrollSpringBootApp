package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"}) // by default it will take GetMethod
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("pankaj",3000));
        ResponseDTO respDTO = new ResponseDTO("Get call successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empPayrollDataData = new EmployeePayrollData(1,new EmployeePayrollDTO("Milind",3000));
        ResponseDTO respDTO = new ResponseDTO("Get call for ID successful", empPayrollDataData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO ){
        EmployeePayrollData empPayrollData = new EmployeePayrollData(1,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Pyroll data sucessfully",empPayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empPayrollData = new EmployeePayrollData(1,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll data Sucessful",empPayrollData);
        return new ResponseEntity<>(respDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO respDTO =new ResponseDTO("Deleted sucessfull","deleted id : "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }


}
