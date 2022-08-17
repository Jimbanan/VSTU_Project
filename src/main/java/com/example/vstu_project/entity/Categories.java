//package com.example.vstu_project.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "categories")
//public class Categories {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="courses_id", nullable=false)
//    private Courses courses;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private com.example.vstu_project.enums.Categories categories;
//
//}
