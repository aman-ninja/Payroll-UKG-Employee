package com.payroll.Employees.services.impl;

import com.payroll.Employees.dto.EmployeeSalaryDetailsDto;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.PayrollDto;
import com.payroll.Employees.dto.SalaryDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.exceptions.ResourceNotFoundException;
import com.payroll.Employees.mapper.EmployeesMapper;
import com.payroll.Employees.repository.EmployeeRepository;
import com.payroll.Employees.services.IEmployeeSalaryDetailsService;
import com.payroll.Employees.services.clients.PayrollFeignClient;
import com.payroll.Employees.services.clients.SalaryFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeSalaryDetailsServiceImpl implements IEmployeeSalaryDetailsService {
    private EmployeeRepository employeeRepository;
    private PayrollFeignClient payrollFeignClient;
    private SalaryFeignClient salaryFeignClient;

    @Override
    public EmployeeSalaryDetailsDto fetchEmployeeSalaryDetails(String mobileNumber) {
        Employees employees = employeeRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Mobile Number",mobileNumber)
        );
        System.out.println("check kr" + employees.getEmployeeId());
        EmployeeSalaryDetailsDto employeeSalaryDetailsDto = EmployeesMapper.mapToEmployeeSalaryDetailsDto(employees,new EmployeeSalaryDetailsDto());

//        ResponseEntity<List<PayrollDto>> payrollDtoResponseEntity = payrollFeignClient.fetchPayrollDetails(1l);
//        employeeSalaryDetailsDto.setPayrollDtoList(payrollDtoResponseEntity.getBody());
//        System.out.println("check kro wapis" + employeeSalaryDetailsDto.getPayrollDtoList());

        ResponseEntity<List<SalaryDto>> salaryDtoResponseEntity = salaryFeignClient.fetchAllSalaryDetails(1l);
        employeeSalaryDetailsDto.setSalaryDtoList(salaryDtoResponseEntity.getBody());
        System.out.println("check kro dubara" + employeeSalaryDetailsDto.getSalaryDtoList());
        return employeeSalaryDetailsDto;
    }

}
