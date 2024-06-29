package com.odoo.combat.services;

import java.util.List;

import com.odoo.combat.entities.Users;

public interface UserService {

	public Users createUser(Users user);

	public Users updateUser(Long userId, Users user);

	public List<Users> getUsers();
	
	public Users getUser(String username);

	public void removeUser(Long userId);

}
