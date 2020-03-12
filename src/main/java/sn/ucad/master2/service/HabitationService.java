package sn.ucad.master2.service;

import java.util.List;

import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;

public interface HabitationService {

	public List<Habitation> findAllHabitations();
	
	public List<HabitationIndividuelle> findAllHabitationsIndiv();
	
	public List<HabitationProffessionnelle> findAllHabitationsPro();

	public Habitation findHabitationById(Long codeHabitation);

	public void saveHabitation(Habitation habitation);

	public void deleteHabitation(Long codeHabitation);
	
	public void deleteHabitation(Habitation habitation);
	
	public Double calculImpot(Habitation habitation);

}
