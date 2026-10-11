package com.ecomm.com.service;

import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;

import java.util.List;

public interface ProductService {

    public ProductRes addProduct(ProductDto dto);
    public ProductRes findProductById(Long id);
    public List<ProductRes> findAll();
    public void deleteProductById(Long id);
    public void deleteAllProduct();
    public ProductRes updateProduct(ProductDto dto,Long id);
}
