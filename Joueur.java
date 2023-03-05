import java.util.Scanner;

public class Joueur {
    private String nom;
    private Grille grille;
    private Bateau[] bateaux;

    public Joueur(String nom) {
        this.nom = nom;
        grille = new Grille();
        bateaux = new Bateau[5];
        bateaux[0] = new Bateau("Porte-avions", 5);
        bateaux[1] = new Bateau("Croiseur", 4);
        bateaux[2] = new Bateau("Contre-torpilleur", 3);
        bateaux[3] = new Bateau("Sous-marin", 3);
        bateaux[4] = new Bateau("Torpilleur", 2);
    }

    public String getNom() {
        return nom;
    }

    public void placerBateaux() {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < bateaux.length; i++) {
            grille.afficherGrille();
            System.out.println("\n");
            System.out.println(nom + ", placez votre " + bateaux[i].getNom() + " (" + bateaux[i].getTaille() + " cases)");
            boolean bateauPlace = false;
            while(!bateauPlace) {
                System.out.println("\n");
                System.out.print("Entrez la position de la première case (par exemple A1): \n");
                String position = scanner.next().toUpperCase();
                System.out.print("Entrez l'orientation (H pour horizontal, V pour vertical): \n");
                String orientation = scanner.next().toUpperCase();
                int x = position.charAt(0) - 'A';
                int y = Integer.parseInt(position.substring(1)) - 1;
                if(x < 0 || x > 9 || y < 0 || y > 9) {
                    System.out.println("Position invalide\n");
                    continue;
                }
                if(orientation.equals("H")) {
                    if(y + bateaux[i].getTaille() > 10) {
                        System.out.println("Bateau hors grille\n");
                        continue;
                    }
                    boolean caseOccupee = false;
                    for(int j = y; j < y + bateaux[i].getTaille(); j++) {
                        if(grille.getGrille()[x][j] != '.') {
                            caseOccupee = true;
                            break;
                        }
                    }
                    if(caseOccupee) {
                        System.out.println("Cases occupées");
                        continue;
                    }
                    for(int j = y; j < y + bateaux[i].getTaille(); j++) {
                        grille.getGrille()[x][j] = 'O';
                    }
                }
                else if(orientation.equals("V")) {
                    if(x + bateaux[i].getTaille() > 10) {
                        System.out.println("Bateau hors grille");
                        continue;
                    }
                    boolean caseOccupee = false;
                    for(int j = x; j < x + bateaux[i].getTaille(); j++) {
                        if(grille.getGrille()[j][y] != '.') {
                            caseOccupee = true;
                            break;
                        }
                    }
                    if(caseOccupee) {
                        System.out.println("Cases occupées");
                        continue;
                    }
                    for(int j = x; j < x + bateaux[i].getTaille(); j++) {
                        grille.getGrille()[j][y] = 'O';
                        }
                    }
                    else {
                        System.out.println("Orientation invalide");
                        continue;
                    }
                    bateauPlace = true;
                }
            }
            grille.afficherGrille();
        }
    
        public boolean aPerdu() {
            for(Bateau bateau : bateaux) {
                if(!bateau.estCoule()) {
                    return false;
                }
            }
            return true;
        }
    
        public boolean tirer(Joueur joueur) {
            System.out.println("\n");
            grille.afficherGrille();
            Scanner scanner = new Scanner(System.in);
            System.out.println(nom + ", à vous de jouer !\n");
            boolean tirReussi = false;
            while(!tirReussi) {
                System.out.println("\n");
                System.out.print("Entrez la position à viser (par exemple A1): ");
                String position = scanner.next().toUpperCase();
                int x = position.charAt(0) - 'A';
                int y = Integer.parseInt(position.substring(1)) - 1;
                if(x < 0 || x > 9 || y < 0 || y > 9) {
                    System.out.println("\nPosition invalide");
                    continue;
                }
                if(joueur.getGrille().getGrille()[x][y] == 'X') {
                    System.out.println("\nCette case a déjà été visée");
                    continue;
                }
                if(joueur.getGrille().getGrille()[x][y] == '.') {
                    System.out.println("\nDans l'eau !");
                    joueur.getGrille().getGrille()[x][y] = 'O';
                    tirReussi = true;
                }
                else {
                    System.out.println("\nTouché !");
                    joueur.getGrille().getGrille()[x][y] = 'X';
                    for(Bateau bateau : joueur.bateaux) {
                        if(bateau.estCoule()) {
                            System.out.println("\nVous avez coulé le " + bateau.getNom() + " de " + joueur.getNom() + " !");
                        }
                    }
                    tirReussi = true;
                }
                
            }
            return joueur.aPerdu();
        }
    
        public Grille getGrille() {
            return grille;
        }
}
    
