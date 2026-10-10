package com.ecomm.com.service.impl;

import com.ecomm.com.constants.ApiConstants;
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
        ProductEntity entity = prepo.findById(id).orElseThrow(() -> new ProductNotFoundException(ApiConstants.PRODUCT_NOT_EXIST + id));

        return mapper.toResponse(entity);
    }
    @Override
    public List<ProductRes> findAll(){
        List<ProductEntity> all = prepo.findAll();
        return all.stream().map(a -> mapper.toResponse(a)).toList();


    }

    @Override
    public void deleteProductById(Long id) {
        ProductEntity entity = prepo.findById(id).orElseThrow(() -> new ProductNotFoundException(ApiConstants.PRODUCT_NOT_EXIST + id));
        prepo.delete(entity);

    }

    @Override
    public void deleteAllProduct() {
        prepo.deleteAll();
    }


}
