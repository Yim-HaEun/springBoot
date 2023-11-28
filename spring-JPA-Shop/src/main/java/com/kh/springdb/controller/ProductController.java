package com.kh.springdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.kh.springdb.service.ProductService;
import com.kh.springdb.vo.Product;
@Controller
//@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	//모든 제품을 보기위한 메서드
	@GetMapping
	public String getAllProducts(Model model){
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products",products);
		//return productService.getAllProducts();
		//return "products";
		return "product_list";
	}
	//제품 상세보기 메서드
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id,Model model) {
		Optional<Product> product = productService.getProductById(id);
		product.ifPresent(value -> model.addAttribute("product",value));
		return "product_detail";
	}
	//작성한 내용을 저장하기 위한 메서드
	//save = > GetMapping(작성할 url을 불러오기위한 주소값 설정), PostMapping(작성한 내용을 저장할 url 설정)
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		model.addAttribute("product",new Product());
		return "product_form";
	}
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";	
	}
	
	//delete = > GetMapping
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
}
