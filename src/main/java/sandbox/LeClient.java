
package sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LeClient {
	@Autowired
	Fournisseur fournisseur;
	
	public void manger() {
		fournisseur.fairePizza();
	}
	public LeClient() {System.out.println("LeClient()");}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}
