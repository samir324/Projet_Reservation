import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.example.dao.EtudiantDao;
import org.example.dao.EtudiantDaoImp;
import org.example.model.Etudiant;
import org.example.service.EtudiantService;
import org.example.service.EtudiantServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EtudiantDaoTest {

	private static Etudiant etud1;
	
	private static EtudiantDao etudiantDao;
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void init() throws Exception {
		etud1 = new Etudiant("zahidi", new Date(), "samir@samir.com", "ttttt");
		etudiantDao = new EtudiantDaoImp();
		System.out.println("set Up Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tear Down After Class");
	}

	

	@Before
	public void setUp() throws Exception {
		System.out.println("set Up");
		
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear Down");
	}
	
	@Test
	public void testCeateEtudiant() throws ClassNotFoundException, SQLException {
		

		//etudiantService.save(etud1);
		etud1 = new Etudiant("zahidi", new Date(), "samir@samir.com", "ttttt");
		EtudiantDao etudiantdao = new EtudiantDaoImp();
		etudiantdao.createEtudiant(etud1);
		
		
	/*	Etudiant samir = new Etudiant("zahidi", new Date(), "samir@samir.com", "ttttt");
		
		List<Etudiant> etudiants = etudiantDao.getAll();
		
		System.out.println(etudiants.get(2).getNom());
		
		
		assertEquals("les deux personnes doivent etre égaux",samir.getNom(), etudiants.get(5).getNom());
		
		System.out.println("Etudiant : "+etudiants.get(2).getNom());*/
	}
	
	/*@Test
	public void getById() throws ClassNotFoundException, SQLException {
		EtudiantDao etudiantdao = new EtudiantDaoImp();
		Etudiant etudiant = etudiantdao.getById(1L);
		Etudiant sa = new Etudiant();
		sa.setNom("sami");
		assertEquals("les deux personnes doivent etre égaux",sa.getNom(), etudiant.getNom());
	}
*/
}
