//package com.example.vstu_project.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "student_course")
//public class StudentCourse {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String studentCourse;
//
//    //------------------------------------FOREIGN ENTITIES
//    @OneToOne(cascade = {CascadeType.ALL}, optional = false, mappedBy = "studentCourse")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    public Courses courses;
//}
