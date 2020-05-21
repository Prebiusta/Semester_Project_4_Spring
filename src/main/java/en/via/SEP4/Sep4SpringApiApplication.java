package en.via.SEP4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class Sep4SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sep4SpringApiApplication.class, args);
	}

}
