package org.example.dao;

import java.util.List;

import org.example.model.Roles;

public interface RoleDao {
	
	 public  void addRole(Roles role);
	    public Roles getRoleById(Long id);
	    public List<Roles> getAllRoles();
	    public void deleteRole(Long id);
	    public Roles updateRole(Roles role);

}
