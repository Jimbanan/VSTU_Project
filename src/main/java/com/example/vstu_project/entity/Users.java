package com.example.vstu_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String patronymic;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String division;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
