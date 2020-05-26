public class Main {
    public static Court court;
    public static Player player1, player2;

    public static void main(String[] args) {
        player1 = new Player("Zoli");
        player2 = new Player("Béla");
        court = new Court(4, 10);
        court.startingState(player1, player2);

        court.trackImage();
    }
}
