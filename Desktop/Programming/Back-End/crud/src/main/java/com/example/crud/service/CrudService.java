package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {
    private CrudRepository crudRepository;

    public void write(User user){

        crudRepository.save(user);
    }

    public List<User> list(){

        return crudRepository.findAll();
    }

    public void delete(Integer id){

       crudRepository.deleteById(id);
    }
}
