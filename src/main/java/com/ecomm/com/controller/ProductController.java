package com.ecomm.com.controller;

import com.ecomm.com.constants.ApiConstants;
import com.ecomm.com.dto.request.ProductDto;
import com.ecomm.com.dto.response.ProductRes;
import com.ecomm.com.response.ApiResponse;
import com.ecomm.com.service.ProductService;


import com.ecomm.com.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {
    @Autowired
    private ProductService pService;
@PostMapping("/create")
  public ResponseEntity<ApiResponse<ProductRes>> addProduct(@Valid @RequestBody ProductDto dto){
      ProductRes productRes = pService.addProduct(dto);
      return  ResponseUtil.success(productRes, ApiConstants.PRODUCT_CREATED, HttpStatus.CREATED);
  }
@GetMapping("/findById/{id}")
  public ResponseEntity<ApiResponse<ProductRes>> findProductById(@PathVariable Long id){
      ProductRes productById = pService.findProductById(id);
      return ResponseUtil.success(productById,ApiConstants.PRODUCT_EXIST,HttpStatus.OK);
  }
    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<List<ProductRes>>> findAllProducts(){
        List<ProductRes> all = pService.findAll();
        return ResponseUtil.success(all,ApiConstants.PRODUCT_EXIST,HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProductById(@PathVariable Long id){
         pService.deleteProductById(id);
        return ResponseUtil.success(ApiConstants.PRODUCT_DELETED,ApiConstants.PRODUCT_NOT_EXIST+" "+id,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> deleteAllProducts(){
        pService.deleteAllProduct();
        return ResponseUtil.success(ApiConstants.PRODUCT_DELETED,ApiConstants.PRODUCT_NOT_EXIST,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProductRes>> updateProduct(@Valid @RequestBody ProductDto dto,@PathVariable Long id){
        ProductRes productRes = pService.updateProduct(dto, id);
        return ResponseUtil.success(productRes,ApiConstants.PRODUCT_UPDATED,HttpStatus.OK);
    }
}
