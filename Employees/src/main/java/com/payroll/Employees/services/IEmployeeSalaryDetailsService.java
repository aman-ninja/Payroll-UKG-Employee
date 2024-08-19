package com.payroll.Employees.services;

import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;

public interface IEmployeeSalaryDetailsService {
    EmployeeSalaryDetailsDto fetchEmployeeSalaryDetails(String mobileNumber);
}
