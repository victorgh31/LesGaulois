package personnages;

public class Village {

	private String nom;
	private Chef chef;
	private Gaulois[] villageois; //tableau de Gaulois
	private int nbVillageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0; //on initialise le nb de villageois à 0
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
            nbVillageois++;
        } else {
        	System.out.println("Le village est plein, impossible d'ajouter plus de villageois.");
	    }
	 }
	public Gaulois trouverHabitant(int numero) {
		if (numero >= 0 && numero < nbVillageois) {
	        return villageois[numero];
	    } else {
	        System.out.println("Numéro de villageois invalide.");
	        return null;
	    }
	}
	 public void afficherVillageois() {
	        if (chef != null) {
	            System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
	        } else {
	            System.out.println("Dans ce village, il n'y a pas de chef.");
	        }
	        for (int i = 0; i < nbVillageois; i++) {
	            System.out.println("- " + villageois[i].getNom());
	        }
	    }
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30); // Message d'exception
        // Le message d'exception est : "Numéro de villageois invalide."
		
		Chef chef = new Chef("Abraracourcix", 6);
		village.setChef(chef);
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		// Gaulois gaulois = village.trouverHabitant(1);
        // System.out.println(gaulois);
        // Si vous décommentez ces lignes, vous obtiendrez une sortie similaire à :
        // Nom du Gaulois numéro 1 : Astérix
        // Cela affiche le nom du Gaulois numéro 1 (l'indice commence à 0) qui est "Astérix".
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
	}
}


    
      