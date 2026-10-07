package com.studentmanagement.student_management.repository;

import com.studentmanagement.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRegisterNo(String registerNo);

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByDepartment_NameIgnoreCase(String department);

    List<Student> findByYear(Integer year);

    List<Student> findBySemester(Integer semester);
}