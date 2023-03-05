public class Grille {

    private char[][] grille;

    public Grille() {
        grille = new char[10][10];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                grille[i][j] = '.';
            }
        }
    }

    public void afficherGrille() {
        System.out.print("  ");
        for(int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < 10; i++) {
            System.out.print((char)('A' + i) + " ");
            for(int j = 0; j < 10; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] getGrille() {
        return grille;
    }

}
