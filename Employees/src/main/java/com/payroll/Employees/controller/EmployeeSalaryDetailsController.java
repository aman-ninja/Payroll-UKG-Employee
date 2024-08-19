package com.payroll.Employees.controller;

import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;
import com.payroll.Employees.services.IEmployeeSalaryDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(
        name = "Employee salary Controller",
        description = "Employee controller for Payroll project"
)
public class EmployeeSalaryDetailsController {
    private final IEmployeeSalaryDetailsService iEmployeeSalaryDetailsService;

    @Operation(
            summary = "Details of Employee salary"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Employee salary details"
    )
    @GetMapping("/fetch-employee-salary-details")
    public ResponseEntity<EmployeeSalaryDetailsDto> getSalaryDetails(@RequestParam String mobileNumber){
        EmployeeSalaryDetailsDto employeeSalaryDetailsDto = iEmployeeSalaryDetailsService.fetchEmployeeSalaryDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(employeeSalaryDetailsDto);
    }

}
