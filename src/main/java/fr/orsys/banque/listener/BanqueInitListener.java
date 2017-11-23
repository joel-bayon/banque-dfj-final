package fr.orsys.banque.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.orsys.banque.repository.CompteDao;
import fr.orsys.banque.service.Banque;

public class BanqueInitListener implements ServletContextListener {
	
	@Autowired
	Banque banque;
	
	@Autowired
	CompteDao dao;
	
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		dao.removeAll(dao.loadAll());
		banque.ouvrirCompte(100);
		banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompteEpargne(10000, 0.2f);
		banque.ouvrirCompte(1999f);
		System.out.println("*****  La banque est initialisée ... *****");

	}

}
