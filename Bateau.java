public class Bateau {

    private String nom;
    private int taille;
    private int nbTouchees;
    private boolean estCoule;

    public Bateau(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        nbTouchees = 0;
        estCoule = false;
    }

    public String getNom() {
        return nom;
    }

    public int getTaille() {
        return taille;
    }

    public boolean estCoule() {
        return estCoule;
    }

    public boolean tirer() {
        nbTouchees++;
        if(nbTouchees == taille) {
            estCoule = true;
            System.out.println("Vous avez coulé le " + nom + " !");
        }
        else {
            System.out.println("Touché !");
        }
        return estCoule;
    }

}

