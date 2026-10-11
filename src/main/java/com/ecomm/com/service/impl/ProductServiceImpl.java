package com.ecomm.com.service.impl;

import com.ecomm.com.constants.ApiConstants;
import com.ecomm.com.constants.ErrorConstants;
import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;
import com.ecomm.com.entity.ProductEntity;
import com.ecomm.com.exception.custom.ProductNotFoundException;
import com.ecomm.com.mapper.ProductMapper;
import com.ecomm.com.repo.ProductRepo;
import com.ecomm.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo prepo;
    @Autowired
    private ProductMapper mapper;

    @Override
    public ProductRes addProduct(ProductDto dto){
       ProductEntity entity= mapper.toEntity(dto);
        ProductEntity saved = prepo.save(entity);
       return mapper.toResponse(saved);
    }
    @Override
    public ProductRes findProductById(Long id) {
        ProductEntity entity = prepo.findById(id).orElseThrow(() -> new ProductNotFoundException(ErrorConstants.PRODUCT_NOT_FOUND +" " + id));

        return mapper.toResponse(entity);
    }
    @Override
    public List<ProductRes> findAll(){
        List<ProductEntity> all = prepo.findAll();
        return all.stream().map(a -> mapper.toResponse(a)).toList();


    }

    @Override
    public void deleteProductById(Long id) {
        ProductEntity entity = prepo.findById(id).orElseThrow(() -> new ProductNotFoundException(ErrorConstants.PRODUCT_NOT_FOUND +" "+ id));
        prepo.delete(entity);

    }

    @Override
    public void deleteAllProduct() {
        prepo.deleteAll();
    }

    @Override
    public ProductRes updateProduct(ProductDto dto, Long id) {
        ProductEntity entity = prepo.findById(id).orElseThrow(() -> new ProductNotFoundException(ErrorConstants.PRODUCT_NOT_FOUND +" "+ id));
            entity.setName(dto.getName());
            entity.setColor(dto.getColor());
            entity.setBrand(dto.getBrand());
            entity.setPrice(dto.getPrice());
        ProductEntity saved = prepo.save(entity);
       return mapper.toResponse(saved);
    }


}
