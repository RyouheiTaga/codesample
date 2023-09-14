package jp.yoshida.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "jp.yoshida.shop.entity")
public class ShopDx4Application {

	public static void main(String[] args) {
		SpringApplication.run(ShopDx4Application.class, args);
	}

}
