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
	
	@GetMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Optional <Product> product = productService.getProductById(id);
		product.ifPresent(value-> model.addAttribute("product",value));
		return "product_form";
		
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

/*
 * @GetMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Optional <Product> product = productService.getProductById(id);
		product.ifPresent(value-> model.addAttribute("product",value));
		return "product_form";
 * 
   Optional <Product> product = productService.getProductById(id);
	   	Optional 안에는 productService.getProductById(id)로 id값을 가져와서 id에 해당하는 제품을 가지고 옴
	   	그런데 여기서 만약 id에 해당하는 제품이 존재하지않는다면 Optional은 비어있게 됨
	   	만약 Optional이 비어있게 된다면 에러가 발생할 수 있지만
	   	추후 비어있을 경우를 대비해서 예외 값을 처리해주는 것이 좋음
	   	예외값을 처리하는 방법 : orElse 를 이용해서 대체값을 제공하거나 페이지 이동 처리를 할 수 있음 (ex:error.html)
	   						이외에 orElseGet : 대체값을 생성하는 함수를 제공
	   							 orElseThrow : 예외를 던짐
	   						
 *
   product.ifPresent(value-> model.addAttribute("product",value));
   		ifPresent : 
   					Optional 객체 안에 값이 존재할 경우 람다식 표현을 실행하기 위한 메서드
   					value 값이 존재하면 모델에 product 변수명을 사용해서 product 안에 value값을 추가할 것
   					추가된 product는 html 템플릿 안에서 product를 thymeleaf를 통해 호출해서 value값을 사용할 수 있음 
   		
 		-> : 람다식 (간결하게 함수를 표현하는 방법으로 간단하게 결과를 표현할 때 사용)
 			기본코드 : (변수값)-> 변수값이 존재하거나 어떤 일을 발생할 경우의 결과를 작성
 			==
 			if(value != null){
 				model.addAttribute("product",value)
 				}
 				
*/
