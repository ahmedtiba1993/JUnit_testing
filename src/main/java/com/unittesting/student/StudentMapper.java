package com.unittesting.student;

import com.unittesting.school.School;

public class StudentMapper {

    public static Student toStudent(StudentRequest request){
        if(request == null){
            throw new NullPointerException("request is null");
        }
        Student student = new Student();
        student.setAge(request.age());
        student.setFirstName(request.firstName());
        student.setLastName(request.lastName());
        student.setEmail(request.email());

        School school = new School();
        school.setId(request.SchoolId());
        student.setSchool(school);

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
