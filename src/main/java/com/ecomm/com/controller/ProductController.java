package com.ecomm.com.controller;

import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;
import com.ecomm.com.response.ApiResponse;
import com.ecomm.com.service.impl.ProductService;


import com.ecomm.com.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService pService;
@PostMapping("/create")
  public ResponseEntity<ApiResponse<ProductRes>> addProduct(@RequestBody ProductDto dto){
      ProductRes productRes = pService.addProduct(dto);
      return  ResponseUtil.success(productRes,"CREATED", HttpStatus.CREATED);
  }
}
