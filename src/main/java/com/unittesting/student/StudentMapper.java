package com.unittesting.student;

public class StudentMapper {

    public static Student toStudent(StudentRequest request){
        Student student = new Student();
        student.setAge(request.age());
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());
        return student;
    }

    public static StudentResponse toStudentResponse(Student student){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setAge(student.getAge());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmail(student.getEmail());
        return studentResponse;
    }
}
