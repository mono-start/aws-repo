package com.mono.ecs.service;

import com.mono.ecs.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchoolService {


    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    public Student addStudent(Student student) {
        Long studentId = Long.valueOf(studentMap.size() + 1);
        student.setId(studentId);
        studentMap.put(studentId, student);
        return student;
    }

    public List<Student> getStudents() {
        if (CollectionUtils.isEmpty(studentMap))
            return new ArrayList<>();

        return studentMap.values().stream().toList();

    }

    public Student getStudentById(Long studentId) {
        if (studentId != null && studentMap.containsKey(studentId)) {
            return studentMap.get(studentId);
        }
        return null;

    }

    public Student updateStudent(Student student) {
        if (student.getId() != null && studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
        }
        return student;

    }

    public boolean deleteStudent(Long studentId) {
        if (studentId != null && studentMap.containsKey(studentId)) {
            studentMap.remove(studentId);
            return true;
        }
        return false;
    }
}
