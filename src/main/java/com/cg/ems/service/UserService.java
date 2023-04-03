package com.cg.ems.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.RoleDao;
import com.cg.ems.dao.UserDao;
import com.cg.ems.entity.Role;
import com.cg.ems.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerNewUser(User user) throws Exception {

		
			Role role = roleDao.findById("User").get();
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRole(roles);
			user.setUserPassword(getEncodedPassword(user.getUserPassword()));
			return userDao.save(user);
		}
	

	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for user");
		roleDao.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setMobileNumber(7993008788l);
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);
		
//		User user = new User();
//		user.setUserName("sandeep123");
//		user.setUserFirstName("Sandeep");
//		user.setUserLastName("sharma");
//		user.setUserPassword(getEncodedPassword("sandeep@pass"));
//		user.setMobileNumber(678909887l);
//		Set<Role> userRoles = new HashSet<>();
//		userRoles.add(userRole);
//		user.setRole(userRoles);
//		userDao.save(user); 
//		
		
		
		
	}
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}


	public void setUserDao(UserDao userDao2) {
		// TODO Auto-generated method stub
		
	}


	public void setRoleDao(RoleDao roleDao2) {
		// TODO Auto-generated method stub
		
	}


	public void setPasswordEncoder(PasswordEncoder passwordEncoder2) {
		// TODO Auto-generated method stub
		
	}
}
