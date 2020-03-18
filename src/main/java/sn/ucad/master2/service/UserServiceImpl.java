package sn.ucad.master2.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sn.ucad.master2.dao.IRoleDaoRepository;
import sn.ucad.master2.dao.IUserDaoRepository;
import sn.ucad.master2.entities.Role;
import sn.ucad.master2.entities.Utilisateur;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserDaoRepository userRepository;

	@Autowired
	private IRoleDaoRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Utilisateur findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(Utilisateur user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ROLE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	public Utilisateur findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Utilisateur findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	public void updateUser(Utilisateur user) {
		// TODO Auto-generated method stub

	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public List<Utilisateur> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	public boolean isUserExist(Utilisateur user) {
		// TODO Auto-generated method stub
		return false;
	}

}