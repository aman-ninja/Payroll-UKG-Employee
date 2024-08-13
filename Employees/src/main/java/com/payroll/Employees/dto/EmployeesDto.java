package com.payroll.Employees.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String role;
    private String mobileNumber;
}