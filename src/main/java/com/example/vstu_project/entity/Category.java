package com.example.vstu_project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;


//    @OneToOne(mappedBy = "allCategories", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, orphanRemoval = true)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//@OneToOne(fetch = FetchType.LAZY,
//        cascade =  CascadeType.ALL,
//        mappedBy = "allCategories",
//        orphanRemoval = true)
//    public Categories allCategories;

}
