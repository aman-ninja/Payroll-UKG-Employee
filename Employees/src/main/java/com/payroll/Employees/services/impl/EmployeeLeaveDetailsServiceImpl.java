package com.payroll.Employees.services.impl;

import com.payroll.Employees.dto.EmployeeLeaveDetailsDto;
import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;
import com.payroll.Employees.dto.LeaveDto;
import com.payroll.Employees.dto.SalaryDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.exceptions.ResourceNotFoundException;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.repository.EmployeeRepository;
import com.payroll.Employees.services.IEmployeeLeaveDetailsService;
import com.payroll.Employees.services.IEmployeeSalaryDetailsService;
import com.payroll.Employees.services.clients.LeaveFeignClient;
import com.payroll.Employees.services.clients.PayrollFeignClient;
import com.payroll.Employees.services.clients.SalaryFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeLeaveDetailsServiceImpl implements IEmployeeLeaveDetailsService {
    private EmployeeRepository employeeRepository;
    private LeaveFeignClient leaveFeignClient;

    @Override
    public EmployeeLeaveDetailsDto fetchEmployeeLeaveDetails(Long employeeId) {
        Employees employees = employeeRepository.findByEmployeeId(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Employee ID",employeeId + "")
        );
        System.out.println("check kr" + employees.getEmployeeId());
        EmployeeLeaveDetailsDto employeeLeaveDetailsDto = EmployeesMapper.mapToEmployeeLeaveDetailsDto(employees,new EmployeeLeaveDetailsDto());

        ResponseEntity<List<LeaveDto>> leaveDtoResponseEntity = leaveFeignClient.fetchAllLeave(employeeId);
        employeeLeaveDetailsDto.setLeaveDtoList(leaveDtoResponseEntity.getBody());
        System.out.println("check krr dubara " + employeeLeaveDetailsDto.getLeaveDtoList());
        return employeeLeaveDetailsDto;
    }
}
