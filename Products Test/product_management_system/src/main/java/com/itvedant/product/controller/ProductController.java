package com.itvedant.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.product.dao.AddProductDAO;
import com.itvedant.product.dao.UpdateproductDAO;
import com.itvedant.product.servies.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("")
	public  ResponseEntity<?>create(@RequestBody AddProductDAO addProductDAO){
		return ResponseEntity.ok(this.productService.createProduct(addProductDAO));
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.productService.readAllProduct());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>readByID(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.readProductByProduct(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?>update(@PathVariable Integer id,@RequestBody UpdateproductDAO updateProductDAO){
		return ResponseEntity.ok(this.productService.updateproduct(id,updateProductDAO));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.productService.deleteProduct(id));
	}

}