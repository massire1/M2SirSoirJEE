package sn.ucad.master2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import sn.ucad.master2.repository.ICatalogueDaoRepository;
import sn.ucad.master2.service.HabitationService;

@SpringBootApplication
//public class GestionImpotByFlexApplication extends SpringBootServletInitializer implements CommandLineRunner {
public class GestionImpotByFlexApplication implements CommandLineRunner {

	@Autowired
	ICatalogueDaoRepository myCatalogueRepository;

	@Autowired
	HabitationService habitationService;

	public static void main(String[] args) {
		SpringApplication.run(GestionImpotByFlexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("*************** APPLICATION DEMAREE *****************");
	}

}
