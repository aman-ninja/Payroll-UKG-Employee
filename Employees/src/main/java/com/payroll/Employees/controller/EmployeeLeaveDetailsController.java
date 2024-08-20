package com.payroll.Employees.controller;

import com.payroll.Employees.dto.EmployeeLeaveDetailsDto;
import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;
import com.payroll.Employees.services.IEmployeeLeaveDetailsService;
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
        name = "Employee leave Controller",
        description = "Employee controller for Leave project"
)
public class EmployeeLeaveDetailsController {
    private final IEmployeeLeaveDetailsService iEmployeeLeaveDetailsService;

    @Operation(
            summary = "Details of Employee Leave"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Employee Leave details"
    )
    @GetMapping("/fetch-all-leave-details")
    public ResponseEntity<EmployeeLeaveDetailsDto> getSalaryDetails(@RequestParam Long empId){
        EmployeeLeaveDetailsDto employeeLeaveDetailsDto = iEmployeeLeaveDetailsService.fetchEmployeeLeaveDetails(empId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeLeaveDetailsDto);
    }
}
