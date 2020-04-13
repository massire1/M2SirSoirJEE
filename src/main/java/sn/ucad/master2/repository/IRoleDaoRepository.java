package sn.ucad.master2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.ucad.master2.entities.Role;

@Repository("roleRepository")
public interface IRoleDaoRepository extends JpaRepository<Role, Integer> {
	
	Role findByRole(String role);

}
