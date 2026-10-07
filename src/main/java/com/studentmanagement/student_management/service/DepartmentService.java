package com.studentmanagement.student_management.service;

import com.studentmanagement.student_management.entity.Department;
import com.studentmanagement.student_management.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {

        if (departmentRepository.existsByNameIgnoreCase(department.getName())) {
            throw new RuntimeException(
                    "Department already exists: " + department.getName()
            );
        }

        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
