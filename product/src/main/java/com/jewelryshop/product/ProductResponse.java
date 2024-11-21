package com.jewelryshop.product;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, BigDecimal price, String skuCode, Integer quantity) {
}
