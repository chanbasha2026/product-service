package com.ecomm.com.dto.request;

import com.ecomm.com.constants.ErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Data
public class ProductDto {
    @NotBlank(message=ErrorConstants.PRODUCT_NAME_ERROR)
    private String name;
    @NotBlank(message = ErrorConstants.PRODUCT_COLOR_ERROR)
    private String color;
    @NotBlank(message = ErrorConstants.PRODUCT_BRAND_ERROR)
    private String brand;
    @NotNull(message = ErrorConstants.PRODUCT_PRICE_ERROR)
    private double price;
}
