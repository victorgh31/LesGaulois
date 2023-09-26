package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

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
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	//TODO on crée un main qui permet de tester la classe Gaulois
	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
		asterix.parler("bonjour");
		Romain cesar = new Romain("César", 3);
		asterix.frapper(cesar);
		
	}
}