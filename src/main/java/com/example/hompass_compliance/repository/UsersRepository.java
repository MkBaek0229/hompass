package com.example.hompass_compliance.repository;

import com.example.hompass_compliance.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UsersRepository extends CrudRepository<Users, Long>{
    @Override
     ArrayList<Users> findAll();

}
