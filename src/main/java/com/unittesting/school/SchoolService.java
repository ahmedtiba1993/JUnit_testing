package com.unittesting.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    public final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolResponse save(SchoolRequest schoolRequest) {
        School school = SchoolMapping.toSchool(schoolRequest);
        return SchoolMapping.toSchoolResponse(schoolRepository.save(school));
    }

    public List<SchoolResponse> getAll() {
        List<School> schools = schoolRepository.findAll();
        return schools.stream().map(SchoolMapping::toSchoolResponse).collect(Collectors.toList());
    }
}
