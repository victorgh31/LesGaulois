package personnages;

public class Musee {

	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
            Trophee trophee = new Trophee(gaulois, equipement);
            trophees[nbTrophee] = trophee;
            nbTrophee++;
        } else {
            System.out.println("Le musée est plein. Les trophées ne peuvent pas être ajoutés.");
        }
    }
	
	public String extraireInstructionsOCaml() {
	    StringBuilder ocamlDeclaration = new StringBuilder();
	    ocamlDeclaration.append("let musee = [");

	    for (Trophee trophee : trophees) {
	        if (trophee != null) {
	            String nomGaulois = trophee.getGaulois().getNom();
	            String nomEquipement = trophee.getEquipement().getNom();
	            ocamlDeclaration.append("\"").append(nomGaulois).append("\", \"").append(nomEquipement).append("\"; ");
	        }
	    }

	    // Supprimer l'espace et le point-virgule en trop à la fin
	    if (ocamlDeclaration.length() >= 2) {
	        ocamlDeclaration.setLength(ocamlDeclaration.length() - 2);
	    }

	    ocamlDeclaration.append("]\n");
	    return ocamlDeclaration.toString();
	}

}

