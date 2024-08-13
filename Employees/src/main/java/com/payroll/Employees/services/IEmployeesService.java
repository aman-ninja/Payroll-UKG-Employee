package com.payroll.Employees.services;

import com.payroll.Employees.dto.EmployeesDto;

public interface IEmployeesService {
    void createEmployee(EmployeesDto employeeDto);

    EmployeesDto fetchDetails(String mobileNumber);

    boolean updateDetails(EmployeesDto employeesDto);

    boolean deleteDetails(String mobileNumber);
}
