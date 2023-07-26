package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductDTO findById(Long id) {

        return new ProductDTO(productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));

    }

    @Transactional
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(product -> new ProductDTO(product));

    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {

        Product product = new Product();
        copyDTOtoEntity(productDTO, product);
        return new ProductDTO(productRepository.save(product));

    }

    @Transactional
    public ProductDTO updateById(Long id, ProductDTO productDTO) {

        try {

            Product product = productRepository.getReferenceById(id);
            copyDTOtoEntity(productDTO, product);
            return new ProductDTO(productRepository.save(product));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);

    }

    private void copyDTOtoEntity(ProductDTO productDTO, Product product) {

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImgUrl(productDTO.getImgUrl());
        product.setPrice(productDTO.getPrice());

    }

}
