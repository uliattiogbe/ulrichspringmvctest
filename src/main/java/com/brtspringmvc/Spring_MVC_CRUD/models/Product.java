package com.brtspringmvc.Spring_MVC_CRUD.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
@Id
int id;
String name;
float price;
public Product() {
	// TODO Auto-generated constructor stub
}
public Product(int id,String name,float price) {
	// TODO Auto-generated constructor stub
	this.id=id;
	this.name=name;
	this.price=price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

}
