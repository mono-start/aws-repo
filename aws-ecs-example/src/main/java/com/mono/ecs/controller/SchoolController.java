package com.mono.ecs.controller;

import com.mono.ecs.model.Student;
import com.mono.ecs.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(schoolService.addStudent(student), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{empId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(schoolService.getStudentById(studentId), HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(schoolService.getStudents(), HttpStatus.OK);

    }

    @PutMapping("/updatStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(schoolService.updateStudent(student), HttpStatus.OK);

    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(schoolService.deleteStudent(studentId), HttpStatus.OK);
    }
}
