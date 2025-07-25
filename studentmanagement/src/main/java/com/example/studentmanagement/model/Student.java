package com.example.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class
Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]{2,30}$", message = "Name must contain only letters and spaces, 2 to 30 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
    @NotNull(message = "entering age is mandatory")
    private Integer age;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
