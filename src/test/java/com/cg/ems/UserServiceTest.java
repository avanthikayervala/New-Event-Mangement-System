package com.cg.ems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cg.ems.dao.RoleDao;
import com.cg.ems.dao.UserDao;
import com.cg.ems.entity.Role;
import com.cg.ems.entity.User;
import com.cg.ems.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserDao userDao;

	@Mock
	private RoleDao roleDao;

	@Mock
	private PasswordEncoder passwordEncoder;

	private UserService userService;

	@Before
	public void setup() {
		userService = new UserService();
		userService.setUserDao(userDao);
		userService.setRoleDao(roleDao);
		userService.setPasswordEncoder(passwordEncoder);
	}

	@Test
	public void testRegisterNewUser() throws Exception {
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for user");
		Mockito.when(roleDao.findById("User")).thenReturn(Optional.of(userRole));

		User user = new User();
		user.setUserName("testuser");
		user.setUserFirstName("Test");
		user.setUserLastName("User");
		user.setUserPassword("password");
		user.setMobileNumber(1234567890L);

		Mockito.when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

		Mockito.when(userDao.save(Mockito.any(User.class))).thenReturn(user);

		User savedUser = userService.registerNewUser(user);

		assertNotNull(savedUser.getId());
		assertEquals("testuser", savedUser.getUserName());
		assertEquals("Test", savedUser.getUserFirstName());
		assertEquals("User", savedUser.getUserLastName());
		assertEquals("encodedPassword", savedUser.getUserPassword());
		assertEquals(1234567890L, savedUser.getMobileNumber());
		Set<Role> roles = savedUser.getRole();
		assertNotNull(roles);
		assertEquals(1, roles.size());
		assertEquals(userRole, roles.iterator().next());
	}

	@Test
	public void testInitRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		Mockito.when(roleDao.save(adminRole)).thenReturn(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for user");
		Mockito.when(roleDao.save(userRole)).thenReturn(userRole);

		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserPassword("password");
		adminUser.setMobileNumber(7993008788l);
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		Mockito.when(userDao.save(adminUser)).thenReturn(adminUser);

		userService.initRolesAndUser();

		Mockito.verify(roleDao, Mockito.times(1)).save(adminRole);
		Mockito.verify(roleDao, Mockito.times(1)).save(userRole);
		Mockito.verify(userDao, Mockito.times(1)).save(adminUser);
	}

	@Test
	public void testGetEncodedPassword() {
		Mockito.when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
		String encodedPassword = userService.getEncodedPassword("password");
		assertEquals("encodedPassword", encodedPassword);
	}
}

