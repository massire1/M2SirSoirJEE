package sn.ucad.master2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.ucad.master2.entities.Produit;

//@Repository("catalogueRepository")
public interface ICatalogueDaoRepository extends JpaRepository<Produit, String>{
	
	List<Produit> findByDesignation(String designation);

	Produit findByReference(String ref);

}
