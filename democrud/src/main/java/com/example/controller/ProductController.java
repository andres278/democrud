package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Product;
import com.example.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public String list(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		return "products";
	}

	@RequestMapping(value = "/product/{id}")
	@ResponseBody
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productShow";
	}

	@RequestMapping(value = "/product/edit/{id}")
	@ResponseBody
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	@ResponseBody
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}

	@RequestMapping("product/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
}
