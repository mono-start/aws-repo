package com.rms.service;

import com.rms.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {


    Map<Long, Employee> employeeMap = new HashMap<Long, Employee>();

    public Employee addEmployee(Employee employee) {
        Long empId = Long.valueOf(employeeMap.size() + 1);
        employee.setEmployeeId(empId);
        employeeMap.put(empId, employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        if (CollectionUtils.isEmpty(employeeMap))
            return new ArrayList<>();

        return employeeMap.values().stream().toList();

    }

    public Employee getEmployeeById(Long employeeId) {
        if (employeeId != null && employeeMap.containsKey(employeeId)) {
            return employeeMap.get(employeeId);
        }
        return null;

    }

    public Employee updateEmployee(Employee employee) {
        if (employee.getEmployeeId() != null && employeeMap.containsKey(employee.getEmployeeId())) {
            employeeMap.put(employee.getEmployeeId(), employee);
        }
        return employee;

    }

    public boolean deleteEmployee(Long employeeId) {
        if (employeeId != null && employeeMap.containsKey(employeeId)) {
            employeeMap.remove(employeeId);
            return true;
        }
        return false;
    }
}
