package com.unittesting.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse save(StudentRequest studentRequest) {
        Student student = StudentMapper.toStudent(studentRequest);
        Student savedStudent = studentRepository.save(student);
        // verify studentRepository was called one time with Mockito
        //studentRepository.save(student);
        return StudentMapper.toStudentResponse(savedStudent);
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::toStudentResponse).collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return StudentMapper.toStudentResponse(optionalStudent.get());
        } else {
            return null;
        }
    }

    public StudentResponse getStudentByName(String name) {
        Optional<Student> student = studentRepository.findByName(name);
        if (student.isPresent()) {
            return StudentMapper.toStudentResponse(student.get());
        }else{
            return null;
        }
    }
}
