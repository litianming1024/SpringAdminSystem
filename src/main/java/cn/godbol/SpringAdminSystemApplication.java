package cn.godbol;

import cn.godbol.config.StorageProperties;
import cn.godbol.common.service.storage.api.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties({StorageProperties.class})
public class SpringAdminSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdminSystemApplication.class, args);
	}

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
