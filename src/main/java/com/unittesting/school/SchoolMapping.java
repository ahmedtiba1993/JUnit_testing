package com.unittesting.school;

public class SchoolMapping {

    public static School toSchool(SchoolRequest schoolRequest) {
        School school = new School();
        school.setName(schoolRequest.name());
        return school;
    }

    public static SchoolResponse toSchoolResponse(School school) {
        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setName(school.getName());
        return schoolResponse;
    }
}
