package sn.ucad.master2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.master2.entities.Habitation;
import sn.ucad.master2.entities.Produit;

public interface IHabitationDaoRepository extends JpaRepository<Habitation, Long> {

	Habitation findByCodeHabitation(Long codeHabitation);

	Produit findByProprietaire(String proprietaire);

}
