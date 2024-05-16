package com.unittesting.student;

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
}