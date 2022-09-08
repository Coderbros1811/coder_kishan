package com.spring.boot.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.demo.model.UserData;

@Repository
public interface UserRepository  extends CrudRepository<UserData, Long>  
{  

}
