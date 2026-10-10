package com.ecomm.com.service.impl;

import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;
import com.ecomm.com.entity.ProductEntity;
import com.ecomm.com.mapper.ProductMapper;
import com.ecomm.com.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo prepo;
    @Autowired
    private ProductMapper mapper;

    public ProductRes addProduct(ProductDto dto){
       ProductEntity entity= mapper.toEntity(dto);
        ProductEntity saved = prepo.save(entity);
       return mapper.toResponse(saved);
    }



}
