package com.unittesting.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/save")
    public ResponseEntity<SchoolResponse> save(@RequestBody SchoolRequest schoolRequest) {
        return ResponseEntity.ok().body(schoolService.save(schoolRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SchoolResponse>> getAll() {
        return ResponseEntity.ok().body(schoolService.getAll());
    }
}
