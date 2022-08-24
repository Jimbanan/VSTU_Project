package com.example.vstu_project.entity;

import com.example.vstu_project.enums.StudentCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categories_id")
    private List<Categories> categories;

    @Column
    private String studentCourse;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;

    @Column
    private String place;

    @Column
    private String image;

    @Column
    private String info;

    @Column
    private String lecturerInformation;

    @Override
    public int compareTo(Courses o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}
