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
        return employees;
    }

    public static EmployeesDto mapToEmployeesDto(Employees employees,EmployeesDto employeesDto){
        employeesDto.setFirstName(employees.getFirstName());
        employeesDto.setLastName(employees.getLastName());
        employeesDto.setDob(employees.getDob());
        employeesDto.setEmail(employees.getEmail());
        employeesDto.setMobileNumber(employees.getMobileNumber());
        employeesDto.setRole(employees.getRole());
        return employeesDto;
    }


}
