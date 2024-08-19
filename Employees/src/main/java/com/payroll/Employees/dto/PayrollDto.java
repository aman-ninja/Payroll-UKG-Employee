package com.payroll.Employees.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PayrollDto {
    private Long transactionId;
    private Long employeeId;
    private String payrollDate;
    private Long finalAmount;
}