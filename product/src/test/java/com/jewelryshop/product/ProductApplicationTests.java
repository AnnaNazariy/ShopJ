package com.jewelryshop.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class) // Імпорт налаштувань Testcontainers
@SpringBootTest
class ProductApplicationTests {

	@Test
	void contextLoads() {
		// Це базовий тест для перевірки, чи завантажується контекст застосунку
	}
}
