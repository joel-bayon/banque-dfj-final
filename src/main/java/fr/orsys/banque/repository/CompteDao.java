package fr.orsys.banque.repository;

import java.util.List;

import fr.orsys.banque.entity.Compte;
import fr.orsys.banque.entity.CompteEpargne;

public interface CompteDao extends Dao<Integer, Compte> {
	public List<CompteEpargne> loadCompteEpargneAll();
	public Compte findCompteWithOperations(Integer primaryKey);

}
