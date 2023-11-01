package br.com.meli.springbootexercise.services;

import br.com.meli.springbootexercise.DTOs.ProductDTO;
import br.com.meli.springbootexercise.models.Product;
import br.com.meli.springbootexercise.models.UpdateForm;
import br.com.meli.springbootexercise.repositorys.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public void postProduct(ProductDTO productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setValue(productDto.getValue());

        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public String getProductById(Long id){
        Product product = productRepository.getReferenceById(id);

        return "\nNome do produto: " + product.getName() + "\nPreço do produto: " + product.getValue();
    }

    public String updateById(Long id, UpdateForm form){

        try {
            Product product = productRepository.getReferenceById(id);

            if(product.getName() != null) {
                product.setName(form.getName());
                product.setValue(form.getValue());
                productRepository.save(product);
            }
        } catch(EntityNotFoundException e){
            return "Usuário não encontrado!";
        }

        return "Atualizado!";
    }

    public String deleteById(Long id){
        productRepository.deleteById(id);
        return "Produto Deletado!";
    }
}
