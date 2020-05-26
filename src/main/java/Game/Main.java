package Game;

import java.util.Scanner;

public class Main {
    public static World world;
    public static Player player1, player2;

    /**
     * A játék létrehozása.
     * @param args nem tudom
     */
    public static void main(String[] args) {
        player1 = new Player("Zoli");
        player2 = new Player("Béla");
        world = new World(4, 10);
        world.startingState(player1, player2);

        world.terminalImage();

        Scanner scanner = new Scanner(System.in);
        boolean hibaslepes = false;
        int fromRow, fromColumn, toRow, toColumn;
        while (true) {
            do {
                if (hibaslepes) {
                    System.out.println("Hibás Lépés");
                }
                System.out.println("Kérem az első játékos lépését!");
                fromRow = scanner.nextInt();
                fromColumn = scanner.nextInt();
                toRow = scanner.nextInt();
                toColumn = scanner.nextInt();
                System.out.println("Honnan sor: " + fromRow + " Oszlop: " + fromColumn + " Hova sor: " + toRow + " Oszlop: " + toColumn);
            } while (hibaslepes = !world.movePuppet(player1, fromRow, fromColumn, toRow, toColumn));

            if (world.somebodyIsWin(player1)) {
                System.out.println("Az első játékos nyert!");
                break;
            }
            world.terminalImage();
            do {
                if (hibaslepes) {
                    System.out.println("Hibás Lépés");
                }
                System.out.println("Kérem a második játékos lépését!");
                fromRow = scanner.nextInt();
                fromColumn = scanner.nextInt();
                toRow = scanner.nextInt();
                toColumn = scanner.nextInt();
                System.out.println("Honnan sor: " + fromRow + " Oszlop: " + fromColumn + " Hová sor: " + toRow + " Oszlop: " + toColumn);
            } while (hibaslepes = !world.movePuppet(player2, fromRow, fromColumn, toRow, toColumn));

            if (world.somebodyIsWin(player2)) {
                System.out.println("A második játékos nyert!");
                break;
            }
            world.terminalImage();
        }
    }
}
