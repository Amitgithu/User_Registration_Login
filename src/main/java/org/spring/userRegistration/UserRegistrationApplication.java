package org.spring.userRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class UserRegistrationApplication {

    public static void main(String[] args) {

        Dotenv.configure()
                .systemProperties()
                .load();

        SpringApplication.run(UserRegistrationApplication.class, args);
    }

}
