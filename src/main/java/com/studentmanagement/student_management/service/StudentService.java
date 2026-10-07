package com.studentmanagement.student_management.service;

import com.studentmanagement.student_management.entity.Department;
import com.studentmanagement.student_management.entity.Student;
import com.studentmanagement.student_management.exception.StudentAlreadyExistsException;
import com.studentmanagement.student_management.repository.DepartmentRepository;
import com.studentmanagement.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository) {

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {

        if (studentRepository.existsByRegisterNo(student.getRegisterNo())) {
            throw new StudentAlreadyExistsException(
                    "Register number already exists: "
                            + student.getRegisterNo()
            );
        }

        Department department = departmentRepository
                .findById(student.getDepartment().getId())
                .orElseThrow(() ->
                        new RuntimeException("Department not found")
                );

        student.setDepartment(department);

        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ ONE
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // UPDATE
    public Student updateStudent(Long id, Student studentDetails) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found")
                );

        existingStudent.setRegisterNo(studentDetails.getRegisterNo());
        existingStudent.setName(studentDetails.getName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setPhone(studentDetails.getPhone());
        existingStudent.setYear(studentDetails.getYear());
        existingStudent.setSemester(studentDetails.getSemester());

        Department department = departmentRepository
                .findById(studentDetails.getDepartment().getId())
                .orElseThrow(() ->
                        new RuntimeException("Department not found")
                );

        existingStudent.setDepartment(department);

        return studentRepository.save(existingStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // SEARCH BY NAME
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // FILTER BY DEPARTMENT
    public List<Student> filterByDepartment(String department) {
        return studentRepository.findByDepartment_NameIgnoreCase(department);
    }

    // FILTER BY YEAR
    public List<Student> filterByYear(Integer year) {
        return studentRepository.findByYear(year);
    }

    // FILTER BY SEMESTER
    public List<Student> filterBySemester(Integer semester) {
        return studentRepository.findBySemester(semester);
    }
}