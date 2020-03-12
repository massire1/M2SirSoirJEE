package sn.ucad.master2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.ucad.master2.dao.ICatalogueDaoRepository;
import sn.ucad.master2.dao.IHabitationDaoRepository;
import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;
import sn.ucad.master2.entities.Produit;
import sn.ucad.master2.service.HabitationService;

@SpringBootApplication
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

//		habitationService.saveHabitation(new HabitationIndividuelle("aa", "aa", 12.0, 1, false));
//		habitationService.saveHabitation(new HabitationIndividuelle("aa", "aa", 12.0, 1, false));
//		habitationService.saveHabitation(new HabitationProffessionnelle("aa", "aa", 12.0, 1));
//		habitationService.saveHabitation(new HabitationProffessionnelle("aa", "aa", 12.0, 1));

//		List<Habitation> mesHabitations = habitationService.findAllHabitations();
//
//		for (Habitation habitation : mesHabitations) {
//			System.out.println(habitation.getProprietaire());
//		}
		
		System.out.println("*************** APPLICATION DEMAREE *****************");
	}

}
