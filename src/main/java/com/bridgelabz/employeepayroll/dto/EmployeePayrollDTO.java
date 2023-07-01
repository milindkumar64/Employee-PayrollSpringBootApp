package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.crypto.dsig.spec.XPathType;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 20000,message ="Sorry bro!,ur salary is too less like TCS employee")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull
    @PastOrPresent
    public LocalDate startDate;

    @NotBlank(message = "note can not be blank")
    public String note;
    @NotBlank(message = "pic can not be blank")
    public String profilePic;
    @NotNull(message = "department should not be empty")
    public List<String> department;

}
