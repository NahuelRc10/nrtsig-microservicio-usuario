package nrt.microservicios.usuarios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"nrt.microservicios.main.commons.usuario.entity",
			 "nrt.microservicios.main.commons.carrera.entity"})
public class NrtsigMicroservicioUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(NrtsigMicroservicioUsuarioApplication.class, args);
	}

}
