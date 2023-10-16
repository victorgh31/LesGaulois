package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement [] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
        System.out.println(prendreParole() + "« Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée. »");
    }
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup(force / 3 * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public void faireUneDonnation(Musee musee) {
	    if (nbTrophees == 0) {
	        System.out.println("Le gaulois " + getNom() + " n'a pas de trophées à donner.");
	        return;
	    }

	    System.out.print("Le gaulois " + getNom() + " : « Je donne au musée tous mes trophées :\n");

	    for (int i = 0; i < nbTrophees; i++) {
	        Equipement equipement = trophees[i];
	        System.out.println("- " + equipement.getNom());
	        musee.donnerTrophees(this, equipement);
	    }

	    System.out.println(" »");

	    // Réinitialiser le tableau de trophées à la fin de la donation
	    for (int i = 0; i < nbTrophees; i++) {
	        trophees[i] = null;
	    }

	    nbTrophees = 0; // Réinitialise le nombre de trophées après la donation
	}


//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}

	//TODO on crée un main qui permet de tester la classe Gaulois
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		
		panoramix.preparerPotion(10);
		int forceDeLaPotion = panoramix.getForcePotion();
		
		asterix.boirePotion(forceDeLaPotion);
		
		Romain minus = new Romain("Minus", 3);
		asterix.frapper(minus);
	}
}