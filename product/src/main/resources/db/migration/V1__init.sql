CREATE TABLE t_products (
                            id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            product_name VARCHAR(255) NOT NULL,
                            sku_code VARCHAR(255),
                            price DECIMAL(19, 2) NOT NULL,
                            quantity INT(11) NOT NULL,
                            category_id BIGINT(20),
                            UNIQUE (sku_code)
);

