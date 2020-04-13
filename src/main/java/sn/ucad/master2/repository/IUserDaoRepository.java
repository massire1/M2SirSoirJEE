package sn.ucad.master2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.ucad.master2.entities.Utilisateur;

@Repository("userRepository")
public interface IUserDaoRepository extends JpaRepository<Utilisateur, Long> {

	public Utilisateur findByEmail(String email);

	public Utilisateur findByName(String name);

}
