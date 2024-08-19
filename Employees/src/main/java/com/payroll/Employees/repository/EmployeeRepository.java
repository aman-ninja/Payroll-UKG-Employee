package com.payroll.Employees.repository;

import com.payroll.Employees.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    Optional<Employees> findByEmployeeId(Long employeeId);
    Optional<Employees> findByMobileNumber(String mobileNumber);

}
