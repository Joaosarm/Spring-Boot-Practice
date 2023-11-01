package br.com.meli.springbootexercise.controllers;

import br.com.meli.springbootexercise.DTOs.ProductDTO;
import br.com.meli.springbootexercise.models.Product;
import br.com.meli.springbootexercise.models.UpdateForm;
import br.com.meli.springbootexercise.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public void postProduct(@RequestBody ProductDTO productDto){
        productService.postProduct(productDto);
    }

    @PutMapping("/{id}")
    public String updateById(@PathVariable Long id, @RequestBody UpdateForm form){
        return productService.updateById(id, form);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }
}
