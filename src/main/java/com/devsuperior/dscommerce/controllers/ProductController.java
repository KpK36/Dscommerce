package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.controllers.services.ProductService;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return productService.findById(id);

    }
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDTO insert (@RequestBody ProductDTO productDTO){
        return productService.insert(productDTO);

    }

}
