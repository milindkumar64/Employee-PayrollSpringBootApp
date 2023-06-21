package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"}) // by default it will take GetMethod
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<String>("Get call success", HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for id" + empId, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("Created Employee payroll data for: "+empPayrollDTO,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<>("updated employee payroll data for: "+empPayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete call Sucess for id :"+empId,HttpStatus.OK);
    }


}
