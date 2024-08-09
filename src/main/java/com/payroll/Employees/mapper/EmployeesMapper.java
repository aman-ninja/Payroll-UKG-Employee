package com.payroll.Employees.mapper;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.entity.Employees;

public class EmployeesMapper {

    public static Employees mapToEmployee(EmployeesDto employeesDto, Employees employees){
        employees.setFirstName(employeesDto.getFirstName());
        employees.setLastName(employeesDto.getLastName());
        employees.setDob(employeesDto.getDob());
        employees.setEmail(employeesDto.getEmail());
        employees.setMobileNumber(employeesDto.getMobileNumber());
        employees.setRole(employeesDto.getRole());
        System.out.println(employees.getLastName());
        return employees;
    }

}
