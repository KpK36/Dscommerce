package com.devsuperior.dscommerce.controllers.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductDTO findById (Long id) {
        return new ProductDTO(productRepository.findById(id).get());

    }
    @Transactional
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(product -> new ProductDTO(product));

    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImgUrl(productDTO.getImgUrl());
        product.setPrice(productDTO.getPrice());

        return new ProductDTO(productRepository.save(product));

    }



}
