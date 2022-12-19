package com.rapidtech.springdasar.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductCategory {
    private Product product;
    private Category category;
}
