package com.payroll.Employees.controller;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.ResponseDto;
import com.payroll.Employees.services.IEmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {
    private IEmployeesService iEmployeesService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccounts(@RequestBody EmployeesDto employeesDto) {
        System.out.println(employeesDto.getFirstName());
        iEmployeesService.createEmployee(employeesDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Successfully Created", HttpStatus.CREATED));
    }
}
