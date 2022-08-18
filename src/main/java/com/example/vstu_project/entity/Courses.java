package com.example.vstu_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class Courses implements Comparable<Courses> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

//    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="courses")
//    private List<Categories> categories;

//    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "studentCourse_id", unique = true, updatable = false)
//    private StudentCourse studentCourse;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String place;

//    private Image image;

    @Override
    public int compareTo(Courses o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}
