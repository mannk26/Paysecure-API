package in.Mrityunjay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(title = "User Management API", version = "1.0", description = "APIs for User Management")
	)
public class MineProjecApplication {

	public static void main(String[] args) {SpringApplication.run(MineProjecApplication.class, args);
	}

}


//http://localhost:8080/swagger-ui/swagger-ui/index.html#/
