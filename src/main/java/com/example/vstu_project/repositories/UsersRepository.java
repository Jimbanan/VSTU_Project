package com.example.vstu_project.repositories;

import com.example.vstu_project.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByEmailAndPassword(String email, String password);

}