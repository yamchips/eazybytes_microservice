package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Accounts microservice REST API documentation",
        description = "EasyBank Accounts microservice REST API documentation", version = "v1",
        contact = @Contact(name = "Fan Wu", email = "wflunch@gmail.com",
                url = "https://github.com/yamchips"),
        license = @License(name = "Apache 2.0", url = "https://github.com/yamchips")),
        externalDocs = @ExternalDocumentation(description = "Extra documentation for EasyBank",
                url = "https://dummy.com"))
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
