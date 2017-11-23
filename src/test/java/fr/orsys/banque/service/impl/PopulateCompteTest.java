package fr.orsys.banque.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.orsys.banque.repository.CompteDao;
import fr.orsys.banque.service.Banque;

public class PopulateCompteTest {
	static ConfigurableApplicationContext spring = new AnnotationConfigApplicationContext(SpringConfigTest.class);
	static CompteDao dao = spring.getBean(CompteDao.class) ;
	
	@BeforeClass
	static public void cleanDatabase() {
		dao.removeAll(dao.loadAll());
	}
	
	@Test
	public void run() {
	
		
		Banque banque = spring.getBean(Banque.class);
		
		banque.ouvrirCompte(100);
		banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompte(1999f);
		

		
		System.out.println("\n**** Fin la création de comptes en base  *****\n");
			
	}
}
