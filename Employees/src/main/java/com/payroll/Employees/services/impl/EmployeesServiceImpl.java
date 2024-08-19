package com.payroll.Employees.services.impl;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.exceptions.EmployeeAlreadyExistException;
import com.payroll.Employees.exceptions.ResourceNotFoundException;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.repository.EmployeeRepository;
import com.payroll.Employees.services.IEmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements IEmployeesService {
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeesDto employeeDto) {
        String mobileNumber = employeeDto.getMobileNumber();
        Optional<Employees> foundEmployee = employeeRepository.findByMobileNumber(mobileNumber);
        if (foundEmployee.isPresent()) {
            throw new EmployeeAlreadyExistException("Customer already exists for given mobile number " + mobileNumber);
        }
        Employees employees = EmployeesMapper.mapToEmployee(employeeDto, new Employees());
        System.out.println("checck kro " + employees.getEmployeeId());
        employeeRepository.save(employees);
    }
    @Override
    public EmployeesDto fetchDetails(String mobileNumber) {
        Employees employees = employeeRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Mobile Number",mobileNumber)
        );
        return EmployeesMapper.mapToEmployeesDto(employees,new EmployeesDto());
    }

    @Override
    public boolean updateDetails(EmployeesDto employeesDto) {

        Employees employees = employeeRepository.findByMobileNumber(employeesDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("customer","mobile number",employeesDto.getMobileNumber())
        );
        if(employees!=null){
            EmployeesMapper.mapToEmployee(employeesDto,employees);
            employeeRepository.save(employees);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDetails(String mobileNumber) {
        Employees employees = employeeRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("customer","mobile number",mobileNumber)
        );
        if(employees!=null){
            employeeRepository.delete(employees);
            return true;
        }else return false;
    }
}
