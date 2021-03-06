package sn.ucad.master2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.ucad.master2.constantes.ConstanteUtil;
import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.HabitationIndividuelle;
import sn.ucad.master2.entities.HabitationProffessionnelle;
import sn.ucad.master2.repository.IHabitationDaoRepository;

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
	public Habitation saveHabitation(Habitation habitation) {
		return habitationDaoRepository.save(habitation);
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

	@Override
	public Double calculImpot(Habitation habitation) {

		Double montantTotal = 0.0;
		
		if (habitation==null)
			return montantTotal;

		if (habitation instanceof HabitationIndividuelle) {

			Integer valPiscine = 0;
			HabitationIndividuelle myHabitationInd = (HabitationIndividuelle) habitation;

			if (myHabitationInd.isPiscine())
				valPiscine = ConstanteUtil.VALPICINE;

			montantTotal = myHabitationInd.getSurface() * ConstanteUtil.VALMETTRECARRE;
			montantTotal += myHabitationInd.getNbrPiece() * ConstanteUtil.VALPIECE;
			montantTotal += valPiscine;

		} else {

			HabitationProffessionnelle myHabitationProf = (HabitationProffessionnelle) habitation;

			montantTotal = myHabitationProf.getSurface() * ConstanteUtil.VALMETTRECARRE;
			montantTotal += (myHabitationProf.getNbrEmploye() / 10) * ConstanteUtil.VALTRANCHE;

		}

		return montantTotal;
	}

	@Override
	public Double calculImpot(Long codeHabitation) {

		Habitation habitation = findHabitationById(codeHabitation);
		return calculImpot(habitation);
	}

}
