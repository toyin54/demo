package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepo.
                findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }

    }

    public void deleteStudent(Long studentId){

        boolean exists =studentRepo.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("student with id " + studentId + "does no exist");
        }
        studentRepo.deleteById(studentId);

    }


}
