package personnages;

import java.util.Random;

public class Druide {

	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom
				+ " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
		parler("Je vais aller préparer une petite potion...");
	}
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion(int effetPotionMax) {
		//on crée un objet random de type random
        Random random = new Random();
        
        int forcePotionGeneree = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
        //on fait parler le druide
        if (forcePotionGeneree > 7) {
            System.out.println(prendreParole() + "« J'ai préparé une super potion de force : " + forcePotionGeneree + "»");
        } else {
            System.out.println(prendreParole() + "« Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotionGeneree + ".»");
        }
        
        this.forcePotion = forcePotionGeneree;
    }
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equalsIgnoreCase("Obélix")) {
			System.out.println(prendreParole() + "« Non, Obélix !... Tu n'auras pas de potion magique !»");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
    public int getForcePotion() {
        return forcePotion;
    }

    public static void main(String[] args) {
        Druide panoramix = new Druide("Panoramix", 5, 10);
        panoramix.preparerPotion(10);
        Gaulois asterix = new Gaulois("Astérix", 8);
        panoramix.booster(asterix);
    }
	
}