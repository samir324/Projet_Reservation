package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.EtudiantDao;
import org.example.dao.EtudiantDaoImp;
import org.example.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component("etudiantService")
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	@Qualifier("etudiantDao")
	private EtudiantDao etudiantDao;
	

	@Override
	@Transactional
	public List<Etudiant> findAll() throws ClassNotFoundException, SQLException {
		return etudiantDao.getAll();
		//return (List<Etudiant>) etudiantRepository.findAll();
	}

	@Override
	@Transactional
	public Etudiant findById(Long id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return etudiantDao.getById(id);
		//return etudiantRepository.findById(id).get();
	}

	@Override
	public void save(Etudiant etudiant) throws ClassNotFoundException, SQLException {
		//return etudiantRepository.save(etudiant);
		etudiantDao.createEtudiant(etudiant);
	}

	@Override
	@Transactional
	public void delete(Long id) throws ClassNotFoundException, SQLException {
		etudiantDao.delete(id);
		//etudiantRepository.deleteById(id);

	}

}
