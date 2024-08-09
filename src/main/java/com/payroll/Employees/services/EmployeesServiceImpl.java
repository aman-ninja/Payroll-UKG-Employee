package com.payroll.Employees.services;

import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.exceptions.EmployeeAlreadyExistException;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements IEmployeesService{
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeesDto employeeDto) {
        Long mobileNumber = employeeDto.getMobileNumber();
        Optional<Employees> foundEmployee = employeeRepository.findByMobileNumber(mobileNumber);
        if (foundEmployee.isPresent()) {
            throw new EmployeeAlreadyExistException("Customer already exists for given mobile number " + mobileNumber);
        }
        Employees employees = EmployeesMapper.mapToEmployee(employeeDto, new Employees());
        employeeRepository.save(employees);

    }
}
