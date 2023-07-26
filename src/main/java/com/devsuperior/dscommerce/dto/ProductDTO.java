package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa estar entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Size(min = 10, message = "O campo deve ter no mínimo 10 caracteres")
    private String description;

    @Positive(message = "Preço deve ser positivo")
    private Double price;
    private String imgUrl;

    public ProductDTO(Product productEntity) {
        id = productEntity.getId();
        name = productEntity.getName();
        description = productEntity.getDescription();
        price = productEntity.getPrice();
        imgUrl = productEntity.getImgUrl();
    }

    public ProductDTO(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
