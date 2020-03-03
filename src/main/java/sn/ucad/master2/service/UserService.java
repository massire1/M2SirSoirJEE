package sn.ucad.master2.service;

import java.util.List;

import sn.ucad.master2.entities.Utilisateur;

public interface UserService {
	
	public Utilisateur findUserByEmail(String email);

	public void saveUser(Utilisateur user);

	public Utilisateur findById(long id);

	public Utilisateur findByName(String name);

	public void updateUser(Utilisateur user);

	public void deleteUserById(long id);

	public List<Utilisateur> findAllUsers();

	public void deleteAllUsers();

	public boolean isUserExist(Utilisateur user);

}
