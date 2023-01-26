package com.example.springboottutorialdemo.repository;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {


    @Autowired
    StudentRepository  studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DisplayName("Test that student repository  will retrieve given a student id")
    void findById() {
        /*given: student_id
        when: studentRepository.findById is executed
        then: studentRepository.findById will return a studentEntity that is the same with expectedStudentEntity
        */

        //given
        int student_id =1;
        StudentEntity expectedStudentEntity = new StudentEntity(1,"Test Name",1, "Test Address");
        testEntityManager.persist(expectedStudentEntity);

        //when
        studentRepository.findById(student_id);
        StudentEntity result = studentRepository.findById(student_id).get();
        assertEquals(result, expectedStudentEntity);



    }


    //Test1
    @Test
    @DisplayName("Test that student repository  will retrieve entities, name attribute of all student entities retrieved from database should equal Test Name")
    public void findByName() {
        StudentEntity expectedStudentEntity = new StudentEntity(1,"Test Name",1, "Test Address");
        StudentEntity expectedStudentEntity2 = new StudentEntity(2,"Test Name",2, "Test Address2");
        String student_name = "Test Name";
        testEntityManager.persist(expectedStudentEntity);
        testEntityManager.persist(expectedStudentEntity2);
        List<StudentEntity> expectedStudents = Arrays.asList(expectedStudentEntity, expectedStudentEntity2);
        List<StudentEntity> result = studentRepository.findByName(student_name);
        assertEquals(expectedStudents, result);
    }
}