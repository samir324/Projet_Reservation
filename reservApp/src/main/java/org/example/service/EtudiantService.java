package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Etudiant;

//@Service
public interface EtudiantService {
	
	public List<Etudiant>findAll() throws ClassNotFoundException, SQLException;
    public Etudiant findById(Long id) throws ClassNotFoundException, SQLException;
    public void save(Etudiant etudiant) throws ClassNotFoundException, SQLException;
    public void delete(Long id) throws ClassNotFoundException, SQLException;

}
