package com.medilyes.student_manager.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    // @Autowired //dependency injection of the Bean (student service)
    // @Qualifier("DBStudentService")
    // private StudentService service;

    private final StudentService service;

    public StudentController(@Qualifier("DBStudentService") StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        // TODO Auto-generated method stub
        service.delete(email);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        // TODO Auto-generated method stub
        return service.findByEmail(email);
    }

    @PostMapping()
    public Student save(@RequestBody Student s) {
        // TODO Auto-generated method stub
        return service.save(s);
    }

    @PutMapping()
    public Student update(@RequestBody Student s) {
        // TODO Auto-generated method stub
        return service.update(s);
    }
}
