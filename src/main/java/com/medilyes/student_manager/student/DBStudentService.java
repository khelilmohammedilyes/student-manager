package com.medilyes.student_manager.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DBStudentService implements StudentService{

    private final StudentRepository repo;


    public DBStudentService(StudentRepository repo) {
        this.repo = repo;
    }


    @Override
    public Student save(Student s) {
        // TODO Auto-generated method stub
        return repo.save(s);
    }

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Student findByEmail(String email) {
        // TODO Auto-generated method stub
        return repo.findByEmail(email);
    }

    @Override
    public Student update(Student s) {
        // TODO Auto-generated method stub
        Student existingStudent = repo.findByEmail(s.getEmail());
        if (existingStudent != null) {
            existingStudent.setName(s.getName());
            existingStudent.setDateOfBirth(s.getDateOfBirth());
            existingStudent.setEmail(s.getEmail());
            return repo.save(existingStudent);
        }
        return null;
    }

    @Override
    public void delete(String email) {
        // TODO Auto-generated method stub
        Student s=repo.findByEmail(email);
        if(s!=null){
            repo.deleteById(s.getId());
        }

    }



}
