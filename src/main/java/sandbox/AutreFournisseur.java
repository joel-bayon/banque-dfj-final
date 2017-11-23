package sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="autreFournisseur")

//@Primary
public class AutreFournisseur implements Fournisseur {
	String nom;

	@Autowired
	public AutreFournisseur(@Value("le pizzaiolo") String nom) {
		super();
		System.out.println("AutreFournisseur(@Value(le pizzaiolo) String nom)");
		this.nom = nom;
	}
	
	public AutreFournisseur() {System.out.println("AutreFournisseur()");}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void fairePizza() {
		System.out.println("moi : " + nom + " je fais de meilleurs pizzas ...!");
	}

	@Override
	public void encaisserArgent(float montant) {
		System.out.println("j'encaisse la somme de :" + montant);
		
	}

}
