package com.brtspringmvc.Spring_MVC_CRUD.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtspringmvc.Spring_MVC_CRUD.models.*;
import com.brtspringmvc.Spring_MVC_CRUD.repo.ProductRepo;
@Service
public class ProductService {

@Autowired
ProductRepo prodRepo;
public List<Product> listProducts()
{
	return prodRepo.findAll();
}
public void saveProduct(Product prod)
{
	prodRepo.save(prod);
}
public void deleteProduct(int id)
{
	prodRepo.deleteById(id);
}
public Product getProduct(int id)
{
	return prodRepo.findById(id).get();
}
}
