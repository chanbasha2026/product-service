package com.ecomm.com.exception.custom;

import com.ecomm.com.constants.ErrorConstants;
import com.ecomm.com.response.ApiResponse;
import com.ecomm.com.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse<Void>> ProductNotFoundExceptionHandler(ProductNotFoundException ex, HttpServletRequest request){
        List<String> errors = extractErrors(ex);
       return ResponseUtil.failure(ex.getMessage(),HttpStatus.NOT_FOUND,request.getRequestURI(),errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGlobalException(Exception ex, HttpServletRequest request){

        List<String> errors = extractErrors(ex);
        return ResponseUtil.failure(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,request.getRequestURI(),errors);

    }

    private List<String> extractErrors(Exception ex){
        if(ex instanceof MethodArgumentNotValidException mavn){
            return mavn.getBindingResult().getFieldErrors().stream()
                    .map(f->f.getField()+":"+f.getDefaultMessage())
                    .toList();
        }
        else if(ex.getMessage()!=null){
            return List.of(ex.getMessage());
        }
        else{
            return List.of(ErrorConstants.UNKNOWN_ERROR);
        }
    }
}
