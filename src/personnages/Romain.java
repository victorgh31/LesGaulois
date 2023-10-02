package personnages;

public class Romain {

	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		if (force < 0) {
			this.force = 0;
		} else {
			this.force = force;
		}
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
		assert force >= 0 : "La force d'un Romain doit être positive.";
		
		int forceInitiale = force;
		
		force -= forceCoup;
		
		assert force < forceInitiale : "La force d'un Romain doit diminuer.";
		
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
		public static void main(String[] args) {
			Romain minus;
			
			minus = new Romain("Minus", 6);
			System.out.println(minus.getNom());
			minus.recevoirCoup(5);
		}
}
