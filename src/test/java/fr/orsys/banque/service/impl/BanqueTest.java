package fr.orsys.banque.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.orsys.banque.repository.CompteDao;
import fr.orsys.banque.service.Banque;
import fr.orsys.banque.service.DebitNonAutoriseException;


public class BanqueTest {
	static ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfigTest.class);
	static CompteDao dao = spring.getBean(CompteDao.class) ;
	
	@BeforeClass
	static public void cleanDatabase() {
		dao.removeAll(dao.loadAll());
	}
	
	Banque banque = null;
	int id1; int id2;
	
	@Before
	public void initBanqueTest() {
		banque=  spring.getBean(Banque.class); //new Banque("LCL", "121212");
		id1 = banque.ouvrirCompte(100.0f);
		id2 = banque.ouvrirCompte(100.0f);
		
	}

	@Test(expected = DebitNonAutoriseException.class)
	public void testEffectuerVirement() throws DebitNonAutoriseException {
		float soldeDestinataire = 0f;
		try {
			banque.effectuerVirement(id1, 200.0f, id2);
			assertEquals(-100.0f, banque.rechercherCompte(id1).getSolde(), 0.0f);
			assertEquals(300.0f, banque.rechercherCompte(id2).getSolde(), 0.0f);
			soldeDestinataire = banque.rechercherCompte(id2).getSolde(); 
			banque.effectuerVirement(id1, 1.0f, id2);
			
			
		} catch (DebitNonAutoriseException e) {
			assertEquals(soldeDestinataire, banque.rechercherCompte(id2).getSolde(), 0.0f);
			throw e;
		}
		
	}

}
