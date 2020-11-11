package com.brtspringmvc.Spring_MVC_CRUD.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brtspringmvc.Spring_MVC_CRUD.models.*;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{

}
