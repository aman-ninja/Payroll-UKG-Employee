package com.payroll.Employees.services.clients;

import com.payroll.Employees.dto.PayrollDto;
import com.payroll.Employees.dto.SalaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("salary")
public interface SalaryFeignClient {
    @GetMapping("/api/v1/fetch-all-salary")
    ResponseEntity<List<SalaryDto>> fetchSalaryDetails(@RequestParam Long employeeId);
}