package personnages;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;
	
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
//	public void recevoirCoup(int forceCoup) {
//		assert force >= 0 : "La force d'un Romain doit être positive.";
//		
//		int forceInitiale = force;
//		
//		force -= forceCoup;
//		
//		assert force < forceInitiale : "La force d'un Romain doit diminuer.";
//		
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) { //méthode copiée collée
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) { //méthode copiée collée
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() { //méthode copiée collée
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	 public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 0:
                ajouterEquipement(equipement);
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement.getNom() + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            case 2:
                System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
                break;
            default:
                System.out.println("Le soldat " + getNom() + " a un nombre d'équipements non valide.");
        }
	 }

	 private void ajouterEquipement(Equipement equipement) {
		 equipements[nbEquipement] = equipement;
         nbEquipement++;
         System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.getNom() + ".");
     }
	
	 public static void main(String[] args) {
		 Romain minus = new Romain("Minus", 6);
		// Le soldat Minus s'équipe avec un casque.
		 minus.sEquiper(Equipement.CASQUE);
		// Le soldat Minus possède déjà un casque.
         minus.sEquiper(Equipement.CASQUE);
         // Le soldat Minus s'équipe avec un bouclier.
         minus.sEquiper(Equipement.BOUCLIER);
         // Le soldat Minus est déjà bien protégé !
         minus.sEquiper(Equipement.CASQUE);
	}
}
