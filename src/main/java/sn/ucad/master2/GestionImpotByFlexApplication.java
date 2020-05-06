package sn.ucad.master2;

import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class GestionImpotByFlexApplication extends SpringBootServletInitializer implements CommandLineRunner {
public class GestionImpotByFlexApplication implements CommandLineRunner {

	Logger logger = Logger.getLogger(GestionImpotByFlexApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GestionImpotByFlexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("*************** APPLICATION DEMAREE *****************");
	}

}
