package com.payroll.Employees.services;

import com.payroll.Employees.dto.EmployeeLeaveDetailsDto;

public interface IEmployeeLeaveDetailsService {
    EmployeeLeaveDetailsDto fetchEmployeeLeaveDetails(Long employeeId);
}
