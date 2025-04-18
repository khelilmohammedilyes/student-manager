package com.medilyes.student_manager.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    Student findByEmail(String email);
    void deleteByEmail(String email);
}
