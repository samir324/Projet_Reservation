package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Etudiant;


public interface EtudiantDao {


	public Etudiant getById(Long id) throws ClassNotFoundException, SQLException;
	public void createEtudiant(Etudiant etudiant) throws ClassNotFoundException, SQLException;
	public void delete(Long id) throws ClassNotFoundException, SQLException;
	public List<Etudiant> getAll() throws ClassNotFoundException, SQLException;


}
