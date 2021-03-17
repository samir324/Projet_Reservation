package org.example.dao;


import org.example.model.Users;
import org.example.util.HibernateUtil;
import org.hibernate.SessionFactory;



import java.sql.SQLException;


import org.example.model.Etudiant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class UserDaoImpl implements UserDao{
	Session session;

    @Override
    public void createUser(Users user) {
		session = HibernateUtil.getSessionFactory().openSession();

        //session = HibernateUtil.getSessionFactory();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    
    @Override
    public Users getUserById(Long id) {
		
        
    	Users user = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			// get User by id
			user = (Users) session.get(Users.class, id);
			System.out.println("user is !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return user;
    }

   // @Override
    public List<Users> getAllUsers() {
    	
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Users> userList = session.createQuery("From Users ").list();
        session.getTransaction().commit();
        return userList;
    	/*Session session = null;
    	List<Users> user=null;
    	try {
			session = HibernateUtil.getSessionFactory().openSession();

    	}*/
        
        
  
    }

    @Override
    public void dropUser(Long id) {
        Users user;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // user = session.find(Users.class, id);
		user = (Users) session.get(Users.class, id);

        if (user != null){
            session.delete(user);
            session.flush();
            System.out.println("drop user");
        }else{
            System.out.println("User Not Exist");
        }
        session.getTransaction().commit();
    }

    @Override
    public Users updateUser(Users user) {
        Users userUp;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // userUp = session.find(Users.class, user.getUserId());
        userUp = (Users) session.get(Users.class, user.getUserId());

        if (userUp != null){
        	userUp.setUserId(user.getUserId());
            userUp.setUserPrenom(user.getUserPrenom());
            userUp.setUserNom(user.getUserNom());
            userUp.setUserEmail(user.getUserEmail());
            userUp.setUserPassword(user.getUserPassword());
            userUp.setRole(user.getRole());
            System.out.println("User updated");
        }else{
            System.out.println("User Not Exist");
        }
        session.getTransaction().commit();
        return userUp;
    }
}