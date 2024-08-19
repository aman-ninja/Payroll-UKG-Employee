package com.payroll.Employees.controller;
import com.payroll.Employees.dto.EmployeesDto;
import com.payroll.Employees.dto.ResponseDto;
import com.payroll.Employees.entity.Employees;
import com.payroll.Employees.services.IEmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(
        name = "Employee Controller",
        description = "Employee controller for Payroll project"
)
public class EmployeeController {
    private final IEmployeesService iEmployeesService;

    @Value("${build.version}")
    private String buildVersion;

    public EmployeeController(IEmployeesService iEmployeesService) {
        this.iEmployeesService = iEmployeesService;
    }
    @Operation(
            summary = "Create new employee"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Employee successfully created"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeesDto employeesDto) {
        iEmployeesService.createEmployee(employeesDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("Successfully Created", HttpStatus.CREATED));
    }

    @Operation(
            summary = "Fetch a particular details of an employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Employee details successfully fetched"
    )
    @GetMapping("/fetch")
    public ResponseEntity<EmployeesDto> fetchEmployee(@RequestParam String mobileNumber){
        EmployeesDto employeeDto = iEmployeesService.fetchDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @Operation(
            summary = "Update a employee details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Employee details successfully updated"
    )
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


    @Operation(
            summary = "Delete a particular instance of an employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Employee successfully deleted"
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteDetails(@RequestParam String mobileNumber){
        boolean isDeleted = iEmployeesService.deleteDetails(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("Deleted Succesfully",HttpStatus.ACCEPTED));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto("Unable to update",HttpStatus.BAD_REQUEST));

    }

    @Operation(
            summary = "Get the build info"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Build info successfully fetched"
    )
    @GetMapping("/build")
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
}
