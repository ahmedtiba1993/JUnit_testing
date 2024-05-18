package com.unittesting.student;

import com.unittesting.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    // wich service we want to test
    @InjectMocks
    private StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveStudent() {
        StudentRequest dto = new StudentRequest("Ahmed", "Tiba", 30, "ahmed.tiba.1993@gmail.com", 1L);

        Student sudent = new Student();
        sudent.setFirstName("Ahmed");
        sudent.setLastName("Tiba");
        sudent.setAge(30);
        sudent.setEmail("ahmed.tiba.1993@gmail.com");

        Student saveStudent = new Student();
        saveStudent.setFirstName("Ahmed");
        saveStudent.setLastName("Tiba");
        saveStudent.setAge(30);
        saveStudent.setEmail("ahmed.tiba.1993@gmail.com");

        // Mock the calls
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(saveStudent);

        StudentResponse response = studentService.save(dto);

        assertNotNull(response);
        assertEquals(dto.firstName(), response.getFirstName());
        assertEquals(dto.lastName(), response.getLastName());
        assertEquals(dto.email(), response.getEmail());

        // verify studentRepository was called one time
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any(Student.class));
    }
}