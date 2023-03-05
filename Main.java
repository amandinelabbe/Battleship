import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        joueur1.placerBateaux();
        joueur2.placerBateaux();

        Joueur joueurCourant = joueur1;
        Joueur joueurAdverse = joueur2;

        while(!joueur1.aPerdu() && !joueur2.aPerdu()) {
            joueurCourant.tirer(joueurAdverse);
            Joueur temp = joueurCourant;
            joueurCourant = joueurAdverse;
            joueurAdverse = temp;
        }

        if(joueur1.aPerdu()) {
            System.out.println("Le joueur 2 a gagné !");
        }
        else {
            System.out.println("Le joueur 1 a gagné !");
        }
    }

}
