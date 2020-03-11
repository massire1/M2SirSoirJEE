package sn.ucad.master2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ucad.master2.dao.IHabitationDaoRepository;
import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;

@Service("habitationService")
public class HabitationServiceImpl implements HabitationService {

	@Autowired
	private IHabitationDaoRepository habitationDaoRepository;

	@Override
	public List<Habitation> findAllHabitations() {
		return habitationDaoRepository.findAll();
	}

	@Override
	public Habitation findHabitationById(Long codeHabitation) {
		return habitationDaoRepository.findByCodeHabitation(codeHabitation);
	}

	@Override
	public void saveHabitation(Habitation habitation) {
		habitationDaoRepository.save(habitation);
	}

	@Override
	public void deleteHabitation(Long codeHabitation) {
		habitationDaoRepository.deleteById(codeHabitation);
	}

	@Override
	public List<HabitationIndividuelle> findAllHabitationsIndiv() {
		List<Habitation> liste = habitationDaoRepository.findAll();
		List<HabitationIndividuelle> listeIndiv = new ArrayList<HabitationIndividuelle>();
		
		for (Habitation habitation : liste) {
			if (habitation instanceof HabitationIndividuelle) {
				HabitationIndividuelle habitIndiv = (HabitationIndividuelle) habitation;
				listeIndiv.add(habitIndiv);
			}
		}
		return listeIndiv;
	}

	@Override
	public List<HabitationProffessionnelle> findAllHabitationsPro() {
		List<Habitation> liste = habitationDaoRepository.findAll();
		List<HabitationProffessionnelle> listeHabitPro = new ArrayList<HabitationProffessionnelle>();
		
		for (Habitation habitation : liste) {
			if (habitation instanceof HabitationProffessionnelle) {
				HabitationProffessionnelle habitIndiv = (HabitationProffessionnelle) habitation;
				listeHabitPro.add(habitIndiv);
			}
		}
		return listeHabitPro;
	}

	@Override
	public void deleteHabitation(Habitation habitation) {
		habitationDaoRepository.delete(habitation);
	}

}
