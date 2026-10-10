package com.ecomm.com.mapper;

import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;
import com.ecomm.com.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper  {

    public ProductRes toResponse(ProductEntity entity) {

        return ProductRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .build();
    }

    public ProductEntity toEntity(ProductDto productDto) {

        return ProductEntity.builder()
                .name(productDto.getName())
                .color(productDto.getColor())
                .brand(productDto.getBrand())
                .price(productDto.getPrice())
                .build();
    }
}
