package com.payroll.Employees.controller;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.ResponseDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.services.IEmployeesService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final IEmployeesService iEmployeesService;

    @Value("${build.version}")
    private String buildVersion;

    public EmployeeController(IEmployeesService iEmployeesService) {
        this.iEmployeesService = iEmployeesService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeesDto employeesDto) {
        iEmployeesService.createEmployee(employeesDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Successfully Created", HttpStatus.CREATED));
    }

    @GetMapping("/fetch")
    public ResponseEntity<EmployeesDto> fetchEmployee(@RequestParam String mobileNumber){
        EmployeesDto employeeDto = iEmployeesService.fetchDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateDetails(@RequestBody EmployeesDto employeesDto) {
        boolean isUpdated = iEmployeesService.updateDetails(employeesDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto("Updated successfully", HttpStatus.ACCEPTED));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to update", HttpStatus.BAD_REQUEST));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteDetails(@RequestParam String mobileNumber){
        boolean isDeleted = iEmployeesService.deleteDetails(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Deleted Succesfully",HttpStatus.ACCEPTED));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to update",HttpStatus.BAD_REQUEST));

    }

    @GetMapping("/build")
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
}
