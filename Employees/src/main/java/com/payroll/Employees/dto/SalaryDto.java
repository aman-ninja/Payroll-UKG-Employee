package com.payroll.Employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class SalaryDto {

    private long employeeId;
    private String dateFrom;
    private String dateTo;
    private long basicAmt;
}
