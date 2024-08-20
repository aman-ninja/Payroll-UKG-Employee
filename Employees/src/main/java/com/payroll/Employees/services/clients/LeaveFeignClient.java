package com.payroll.Employees.services.clients;

import com.payroll.Employees.dto.LeaveDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("leave")
public interface LeaveFeignClient {
    @GetMapping("/api/fetch-all-leave")
    ResponseEntity<List<LeaveDto>> fetchAllLeave(@RequestParam Long employeeId);
}