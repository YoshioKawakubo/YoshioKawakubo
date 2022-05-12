package com.example.Controller;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ex03")
public class Exam03Controller {
	@Autowired
	ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("result")
	public String result(Integer product1,Integer product2, Integer product3
			, Integer exTax, Integer inTax) {
//		List<String> productList = new ArrayList<>();
//		productList.add("product1");
//		productList.add("product2");
//		productList.add("product3");
//		model.addAttribute(productList);
//		application.setAttribute("product1", product1);
//		application.setAttribute("product2", product2);
//		application.setAttribute("product3", product3);
		System.out.println(product1);
		exTax = product1 + product2 + product3;
		inTax = (int) ((product1 + product2 + product3) * 1.1) ;
		application.setAttribute("exTax", exTax);
		application.setAttribute("inTax", inTax);
		
	
		return "exam03-result";
	}

}
