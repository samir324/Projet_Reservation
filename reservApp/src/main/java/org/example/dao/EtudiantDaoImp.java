package org.example.dao;

import java.sql.SQLException;

import java.util.List;

import org.example.model.Etudiant;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component("etudiantDao")
public class EtudiantDaoImp implements EtudiantDao {

	@Override
	public Etudiant getById(Long id) throws ClassNotFoundException, SQLException {
		Etudiant etudiant = null;
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			// get joueur by id
			etudiant = (Etudiant) session.get(Etudiant.class, id);
			System.out.println("Le etudiant lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return etudiant;

	}

	@Override
	public void createEtudiant(Etudiant etudiant) throws ClassNotFoundException, SQLException {
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(etudiant);
			transaction.commit();
			System.out.println("L'etudaint est bien crée !");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void delete(Long id) throws ClassNotFoundException, SQLException {
		Etudiant etudiant = getById(id);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(etudiant);
			transaction.commit();
			System.out.println("Etudiant suprimé !");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@SuppressWarnings("unchecked")
	public List<Etudiant> getAll() throws ClassNotFoundException, SQLException {

		Session session = null;
		List<Etudiant> etudiants = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Query query = session.getNamedQuery("Etudiant.All");
			etudiants = query.list();

			System.out.println("etudaints lu !");
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return etudiants;

	}

}
