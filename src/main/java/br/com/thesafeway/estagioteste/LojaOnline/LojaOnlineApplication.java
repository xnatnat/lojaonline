package br.com.thesafeway.estagioteste.LojaOnline;

import br.com.thesafeway.estagioteste.LojaOnline.services.BootstrapDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaOnlineApplication {

	@Autowired
	private BootstrapDataService bootstrapDataService;

	public static void main(String[] args) {
		SpringApplication.run(LojaOnlineApplication.class, args);
	}

	@PostConstruct
	public void bootstrap() {
		bootstrapDataService.bootstrap();
	}
}

