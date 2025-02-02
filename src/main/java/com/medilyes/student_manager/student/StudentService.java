package com.medilyes.student_manager.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student save(Student s);
    List<Student> getAllStudents();
    Student findByEmail(String email);
    Student update(Student s);
    void delete(String email);

}
