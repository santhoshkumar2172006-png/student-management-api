package com.studentmanagement.student_management.controller;

import com.studentmanagement.student_management.entity.Student;
import com.studentmanagement.student_management.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
public ResponseEntity<Student> createStudent(
        @Valid @RequestBody Student student) {

    Student createdStudent = studentService.createStudent(student);

    return ResponseEntity.ok(createdStudent);
}

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // SEARCH BY NAME
@GetMapping("/search")
public ResponseEntity<List<Student>> searchStudents(
        @RequestParam String name) {

    return ResponseEntity.ok(
            studentService.searchByName(name)
    );
}

// FILTER BY DEPARTMENT
@GetMapping("/department")
public ResponseEntity<List<Student>> filterByDepartment(
        @RequestParam String department) {

    return ResponseEntity.ok(
            studentService.filterByDepartment(department)
    );
}

// FILTER BY YEAR
@GetMapping("/year")
public ResponseEntity<List<Student>> filterByYear(
        @RequestParam Integer year) {

    return ResponseEntity.ok(
            studentService.filterByYear(year)
    );
}

// FILTER BY SEMESTER
@GetMapping("/semester")
public ResponseEntity<List<Student>> filterBySemester(
        @RequestParam Integer semester) {

    return ResponseEntity.ok(
            studentService.filterBySemester(semester)
    );
}
    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
public ResponseEntity<Student> updateStudent(
        @PathVariable Long id,
        @Valid @RequestBody Student student) {

    return ResponseEntity.ok(
            studentService.updateStudent(id, student)
    );
}

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
}