package com.medilyes.student_manager.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentDao {

    private final List<Student> students = new ArrayList<>();

    public Student save(Student s){
        students.add(s);
        return s;
    }
    public List<Student> getAllStudents() {
        return students;
    }
    public void delete(String email) {
        var s= findByEmail(email);
        if(s!=null){
            students.remove(s);
        }
    }
    public Student findByEmail(String email) {
        return students.stream().filter(s->email.equals(s.getEmail())).findFirst().orElse(null);
    }
    public Student update(Student s) {
        var studentIndex=IntStream.range(0, students.size()).filter(index->students.get(index).getEmail().equals(s.getEmail())).findFirst().orElse(-1);
        if(studentIndex>-1){
            students.set(studentIndex, s);
            return s;
        }
        return null;
    }

}
