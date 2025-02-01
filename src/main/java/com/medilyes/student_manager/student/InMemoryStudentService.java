package com.medilyes.student_manager.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InMemoryStudentService  implements StudentService{

    private final InMemoryStudentDao dao;

    public InMemoryStudentService(InMemoryStudentDao dao) {
        this.dao=dao;
    }

    @Override
    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    @Override
    public void delete(String email) {
        // TODO Auto-generated method stub
        dao.delete(email);
    }

    @Override
    public Student findByEmail(String email) {
        // TODO Auto-generated method stub
        return dao.findByEmail(email);
    }

    @Override
    public Student save(Student s) {
        // TODO Auto-generated method stub
        return dao.save(s);
    }

    @Override
    public Student update(Student s) {
        // TODO Auto-generated method stub
        return dao.update(s);
    }

}
