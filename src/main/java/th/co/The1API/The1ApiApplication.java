package th.co.The1API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class The1ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(The1ApiApplication.class, args);
	}

}
