package pl.devkamil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackageClasses = com.devkamil.PageController.class)
@EnableJpaRepositories(basePackageClasses = TaskRepository.class)
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Main.class, args);
	}

}
