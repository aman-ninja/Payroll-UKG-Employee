package com.payroll.Employees.mapper;

import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.entity.Employees;

public class EmployeesMapper {

    public static Employees mapToEmployee(EmployeesDto employeesDto, Employees employees){
        employees.setEmployeeId(employeesDto.getEmployeeId());
        employees.setFirstName(employeesDto.getFirstName());
        employees.setLastName(employeesDto.getLastName());
        employees.setDob(employeesDto.getDob());
        employees.setEmail(employeesDto.getEmail());
        employees.setMobileNumber(employeesDto.getMobileNumber());
        employees.setRole(employeesDto.getRole());
        return employees;
    }

    public static EmployeesDto mapToEmployeesDto(Employees employees,EmployeesDto employeesDto){
        employeesDto.setEmployeeId(employees.getEmployeeId());
        employeesDto.setFirstName(employees.getFirstName());
        employeesDto.setLastName(employees.getLastName());
        employeesDto.setDob(employees.getDob());
        employeesDto.setEmail(employees.getEmail());
        employeesDto.setMobileNumber(employees.getMobileNumber());
        employeesDto.setRole(employees.getRole());
        return employeesDto;
    }

    public static EmployeeSalaryDetailsDto mapToEmployeeSalaryDetailsDto(Employees employees,EmployeeSalaryDetailsDto employeeSalaryDetailsDto){
        employeeSalaryDetailsDto.setEmployeeId(employees.getEmployeeId());
        employeeSalaryDetailsDto.setFirstName(employees.getFirstName());
        employeeSalaryDetailsDto.setLastName(employees.getLastName());
        employeeSalaryDetailsDto.setDob(employees.getDob());
        employeeSalaryDetailsDto.setEmail(employees.getEmail());
        employeeSalaryDetailsDto.setMobileNumber(employees.getMobileNumber());
        employeeSalaryDetailsDto.setRole(employees.getRole());
        return employeeSalaryDetailsDto;
    }

}
