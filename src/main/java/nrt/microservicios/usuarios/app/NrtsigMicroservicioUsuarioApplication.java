package nrt.microservicios.usuarios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NrtsigMicroservicioUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(NrtsigMicroservicioUsuarioApplication.class, args);
	}

}
