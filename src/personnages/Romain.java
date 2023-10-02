package personnages;

public class Romain {

	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	//TODO on crée un main qui permet de tester la classe Gaulois
		public static void main(String[] args) {
			Romain minus;
			
			minus = new Romain("Minus", 3);
			System.out.println(minus.getNom());
			minus.parler("bonjour");
			minus.recevoirCoup(8);
		}
}
