package com.example.springboottutorialdemo.controller;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@WebMvcTest(StudentController.class)
class StudentControllerTest {


    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;




    @Test
    @DisplayName("Test if add student request will return an OK status")
    public void addStudent() throws Exception  {

     //   given: student Entity
        StudentEntity expectedStudentEntity = new StudentEntity(1,"Test Name",1, "Test Address");
        given(studentService.addStudent(expectedStudentEntity)).willReturn(expectedStudentEntity);
     //   When: addStudent post request is called
        mockMvc.perform(MockMvcRequestBuilders.post("/student/").contentType(MediaType.APPLICATION_JSON).content("{\r\n" +
                "  \"id\": 1,\r\n" +
                "  \"name\": \"Test Name\",\r\n" +
                "  \"rollNo\": 1,\r\n" +
                "  \"address\": \"Test Address" +"\"\r\n" +
                //Then: The request result should return an OK status
                "}")).andExpect(MockMvcResultMatchers.status().isOk());

     //   Then: The request result should return an OK status


    }


    //Test1

    @Test
    @DisplayName("Test if get student request will return an OK status")
    public void GetStudentById() throws Exception  {

        //   given: student Entity
        int existing_student_id = 1;
        StudentEntity expectedStudentEntity = new StudentEntity(1,"Test Name",1, "Test Address");
        given(studentService.getStudentById(existing_student_id)).willReturn(expectedStudentEntity);
        //   When: addStudent post request is called
        mockMvc.perform(MockMvcRequestBuilders.get("/student/"+existing_student_id).contentType(MediaType.APPLICATION_JSON).content("{\r\n" +
                "  \"id\": 1,\r\n" +
                "  \"name\": \"Test Name\",\r\n" +
                "  \"rollNo\": 1,\r\n" +
                "  \"address\": \"Test Address" +"\"\r\n" +
                //Then: The request result should return an OK status
                "}")).andExpect(MockMvcResultMatchers.status().isOk());

        //   Then: The request result should return an OK status


    }





}