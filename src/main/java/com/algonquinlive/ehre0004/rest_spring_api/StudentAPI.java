package com.algonquinlive.ehre0004.rest_spring_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentAPI {

    private List<Student> students = new ArrayList<>() {
        {
            add(new Student(1, "Alice Garnier", "A+", "garn001@collegelive.com"));
            add(new Student(2, "Bo L'Oriel", "B+", "lori002@collegelive.com"));
        }
    };

    public StudentAPI() {}

    @GetMapping(value="/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object[]> getAll() {
        HashMap<String, Object[]> data = new HashMap<>() {
            {
                put("students", students.toArray());
            }
        };
        return data;
    }

    
}
