package br.com.ifpe.oxefood;

// Importação necessária para iniciar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// A anotação @SpringBootApplication marca a classe como a classe principal de inicialização do Spring Boot
@SpringBootApplication
@EnableJpaAuditing //Quando persistido em b

public class OxefoodDanielApplication {

    // O método main é o ponto de entrada da aplicação
    public static void main(String[] args) {
        // Chama o método run da SpringApplication para iniciar a aplicação Spring Boot
        SpringApplication.run(OxefoodDanielApplication.class, args);
    }
}
