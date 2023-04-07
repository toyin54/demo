package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo //Acessing the sat asaved in repo
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student S WHERE s.email = ?1")//The student being specifed is the class not repo
    Optional<Student> findStudentByEmail(String email);
}
