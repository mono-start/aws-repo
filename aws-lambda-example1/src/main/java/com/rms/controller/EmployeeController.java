package com.rms.controller;

import com.rms.model.Employee;
import com.rms.service.EmployeeService;
import jakarta.ws.rs.PUT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/management")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") Long getEmployeeById) {
        return new ResponseEntity<>(employeeService.getEmployeeById(getEmployeeById), HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);

    }

    @PutMapping("/updatEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);

    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("empId") Long empId) {
        return new ResponseEntity<>(employeeService.deleteEmployee(empId), HttpStatus.OK);
    }
}
