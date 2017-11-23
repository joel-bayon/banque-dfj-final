package sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("fournisseur")
public class LeFournisseur implements Fournisseur {
	//@Value("le super pizzaiolo")
	@Autowired
	String nom;

	public LeFournisseur(String nom) {
		super();
		System.out.println("LeFournisseur(String nom)");
		this.nom = nom;
	}
	
	public LeFournisseur() {System.out.println("LeFournisseur()");}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void fairePizza() {
		System.out.println("moi : " + nom + " je fais des pizzas ...!");
	}

	@Override
	public void encaisserArgent(float montant) {
		System.out.println("j'encaisse la somme de :" + montant);
		
	}

}
