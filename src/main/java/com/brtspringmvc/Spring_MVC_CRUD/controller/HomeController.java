package com.brtspringmvc.Spring_MVC_CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.brtspringmvc.Spring_MVC_CRUD.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import com.brtspringmvc.Spring_MVC_CRUD.service.ProductService;

@Controller
public class HomeController {
	
	 @RequestMapping("/") 
	 public String welcome(Model model) {
		 // not invoking any service here...
		 model.addAttribute("message1","hello i am from controller");
	return "index"; 
	 }
	 
@Autowired
ProductService prodService;

@RequestMapping("/list_products")  // http method is get, its by default get
public String listProducts(Model model)
{
	List<Product> listProducts=prodService.listProducts();
	model.addAttribute("products", listProducts); // that htm page can get these details 
	
	return "product"; // name of the thymeleaf or html or jsp
}
@RequestMapping("/new")
public String showNewProductPage(Model  model)
{
	Product prod=new Product();
	model.addAttribute("product",prod);
	return "new_product";
}
@RequestMapping(value="/save", method=RequestMethod.POST)
public String saveProduct(@ModelAttribute("product") Product prod1)
{
	prodService.saveProduct(prod1);
	return "redirect:/list_products";
}
// delete
@RequestMapping("/delete/{id}")
public String deleteProduct(@PathVariable(name="id") int id)
{
	prodService.deleteProduct(id);
	return "redirect:/list_products";
}
//update
@RequestMapping("/edit/{id}")
public ModelAndView editProduct(@PathVariable(name="id") int id)
{
	ModelAndView mav = new ModelAndView("edit_product");
	Product p1=prodService.getProduct(id);
	mav.addObject("product",p1);
	return mav;
}
}
