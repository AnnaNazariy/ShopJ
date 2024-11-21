package com.jewelryshop.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .skuCode(productRequest.skuCode())
                .quantity(productRequest.quantity())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public boolean getProduct(@RequestParam Long productId){
        return productRepository.findById(productId).isPresent();



    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::mapToProductResponse)
                .toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getSkuCode(),
                product.getQuantity()
        );
    }
}
