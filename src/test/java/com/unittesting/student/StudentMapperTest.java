package com.unittesting.student;

import com.unittesting.school.School;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentMapperTest {

    @Test
    public void shouldMapDtoToStudent() {
        StudentRequest dto = new StudentRequest("Ahmed", "Tibe", 30, "ahmed.tiba.1993@gmail.com",1L);
        Student student = StudentMapper.toStudent(dto);

        assertNotNull(student);
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.age(), student.getAge());
        assertNotNull(student.getSchool());
        assertEquals(dto.SchoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToDto() {
        Student student = new Student();
        student.setFirstName("Ahmed");
        student.setLastName("Tibe");
        student.setEmail("ahmed.tiba.1993@gmail.com");
        student.setAge(30);

        StudentResponse studentResponse = StudentMapper.toStudentResponse(student);

        assertNotNull(studentResponse);
        assertEquals(student.getFirstName(), studentResponse.getFirstName());
        assertEquals(student.getLastName(), studentResponse.getLastName());
        assertEquals(student.getEmail(), studentResponse.getEmail());
        assertEquals(student.getAge(), studentResponse.getAge());

    }

    @Test
    public void should_map_Dto_to_student_when_dto_is_null(){
        Student student = StudentMapper.toStudent(null);
    }

    @Test
    public void should_throw__null_pointer_exception_when_dto_is_null(){
        var exp = assertThrows(NullPointerException.class, ()->StudentMapper.toStudent(null));
        assertEquals(exp.getMessage(),"request is null");
    }
}