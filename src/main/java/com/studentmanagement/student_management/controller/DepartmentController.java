package com.studentmanagement.student_management.controller;

import com.studentmanagement.student_management.entity.Department;
import com.studentmanagement.student_management.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // CREATE DEPARTMENT
    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestBody Department department) {

        Department createdDepartment =
                departmentService.createDepartment(department);

        return ResponseEntity.ok(createdDepartment);
    }

    // GET ALL DEPARTMENTS
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {

        return ResponseEntity.ok(
                departmentService.getAllDepartments()
        );
    }
}