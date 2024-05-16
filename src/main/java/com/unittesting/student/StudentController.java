package com.unittesting.student;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("save")
    public ResponseEntity<StudentResponse> save(@RequestBody @Valid StudentRequest studentRequest) {
        return ResponseEntity.ok().body(studentService.save(studentRequest));
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentResponse>> findAll() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable long id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }
}
