package com.jewelryshop.product;

import java.math.BigDecimal;



public record ProductRequest(String name, String description, BigDecimal price, String skuCode, Integer quantity) {
}
