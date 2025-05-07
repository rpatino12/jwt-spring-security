package dev.rpatino12.jwt_demo;

import dev.rpatino12.jwt_demo.config.RsaKeyProperties;
import dev.rpatino12.jwt_demo.model.Post;
import dev.rpatino12.jwt_demo.model.User;
import dev.rpatino12.jwt_demo.repository.PostRepository;
import dev.rpatino12.jwt_demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			userRepository.save(new User("ricardo", encoder.encode("password"), "ROLE_USER"));
			userRepository.save(new User("laura", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
			userRepository.save(new User("joe", encoder.encode("my_super_secret_password"), "ROLE_USER,ROLE_ADMIN"));
			postRepository.save(new Post("Interesting Blog!", "interesting-blog", "Welcome to my blog", "Ricardo"));
		};
	}

}
