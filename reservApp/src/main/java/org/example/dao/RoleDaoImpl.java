package org.example.dao;

import java.util.List;

import org.example.model.Roles;
import org.example.model.Users;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

public class RoleDaoImpl implements RoleDao {

	   Session session;
	    @Override
	    public void addRole(Roles role) {
	        session =  HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(role);
	        session.getTransaction().commit();
	    }

	    @Override
	    public Roles getRoleById(Long id) {
	       /* session =  HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        //Roles role = session.find(Roles.class, id);
			role = (Roles) session.get(Users.class, id);

	        session.getTransaction().commit();
	        return role;*/
	      
	     	Roles role = null;
			Session session = null;
			try {

				session = HibernateUtil.getSessionFactory().openSession();
				// get role by id
				role = (Roles) session.get(Roles.class, id);
				System.out.println("Role is !");
			} finally {
				if (session != null) {
					session.close();
				}

			}

			return role;
	    }
	        
	        
	    

	@Override
	 public List<Roles> getAllRoles() {
		session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Roles> listRole = session.createQuery("From Roles ").list();
        session.getTransaction().commit();
        return listRole;
    }


	@Override
	public void deleteRole(Long id) {
	
         Roles role;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // role = session.find(Roles.class, id);
        role = (Roles) session.get(Roles.class, id);
        
        if (role != null){
            session.delete(role);
            session.flush();
            System.out.println("Delete Role");
        }else{
            System.out.println("Role Not Exist");
        }
        session.getTransaction().commit();
    }

	@Override
	public Roles updateRole(Roles role) {
		
	        Roles roleUp;
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	       // userUp = session.find(Users.class, user.getUserId());
	        roleUp = (Roles) session.get(Roles.class, role.getId());
	        	       
	        if (roleUp != null){
	            roleUp.setRoleName(role.getRoleName());
	            System.out.println("Role Updated");
	        }else{
	            System.out.println("Role Not Exist");
	        }
	        session.getTransaction().commit();
	        return roleUp;
	    }

}
