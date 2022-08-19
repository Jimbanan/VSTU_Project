package com.example.vstu_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotEmpty
    @Size(min=6, max=30)
    private String surname;

    @Column
    @NotEmpty
    @Size(min=6, max=30)
    private String name;

    @Column
    @NotEmpty
    @Size(min=6, max=30)
    private String patronymic;

    @Column
    @NotEmpty
    @Email
    private String email;

    @Column
    @NotEmpty
    @Size(min=6, max=30)
    private String password;

    @Column
    private String division;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
