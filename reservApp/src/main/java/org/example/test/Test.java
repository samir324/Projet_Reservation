package org.example.test;


import java.sql.SQLException;

import org.example.dao.RoleDao;
import org.example.dao.RoleDaoImpl;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.model.Roles;
import org.example.model.Users;
import org.example.service.EtudiantService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Roles roles = new Roles();
        roles.setId(1L);
	    UserDao user = new UserDaoImpl();
	   
	     //user.createUser(new Users("lamyaa","najahi","lamyaa@gmail.com","admin",roles));

	     // RoleDao role = new RoleDaoImpl();
	      
	     //Roles role1 = role.addRole(2,"user");
	    
	    //user.updateUser( 3L,"lamo","jhj","kjk","jkk",roles);
	    
	     
	     System.out.println(user);
	}

}
