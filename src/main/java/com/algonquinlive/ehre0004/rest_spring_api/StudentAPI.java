package com.algonquinlive.ehre0004.rest_spring_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/students/{id}")
    public Map<String, Object> get(@PathVariable String id) {
        Student find = new Student(0, "Error", "Error", "Error");
        HashMap<String, Object> data = new HashMap<>();
        for (int i=0; i<students.size(); i++) {
            if (students.get(i).getId() == Integer.parseInt(id)){
                find = students.get(i);
                data.put("student", find);
                return data;
            }
        }
        data.put("student", "not found");
        return data;
    }

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> addStudent(@RequestBody Student student) {
        HashMap<String, Object> data = new HashMap<>();
        if (student == null) {
            data.put("data", "Error processing student in request body");
        } else {
            students.add(student);
            data.put("data", student);
        }
        return data;
    }

    @PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@PathVariable String id, @RequestBody Student student) {
        for (int i=0; i<students.size();i++){
            if (students.get(i).getId() == Integer.parseInt(id)) {
                students.set(i, student);
                return "{\"data\":\"OK\"}";
            }
        }
        return "{\"data\": \"error\"}";
    }

    @DeleteMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@PathVariable String id) {
        for (int i=0; i<students.size();i++){
            if (students.get(i).getId() == Integer.parseInt(id)) {
                students.remove(i);
                return "{\"data\":\"OK\"}";
            }
        }
        return "{\"data\": \"error\"}";
    }
}
