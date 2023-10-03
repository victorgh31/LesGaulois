package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];
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
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}


	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

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