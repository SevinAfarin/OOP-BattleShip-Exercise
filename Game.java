import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;

    public Game() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        setupGame();
    }

    private void setupGame() {
        System.out.println("Setting up the game...");
        placeShipsForPlayer(player1);
        placeShipsForPlayer(player2);
    }

    private void placeShipsForPlayer(Player player) {
        System.out.println(player.getName() + ", place your ships:");
        Board board = player.getBoard();
        int[] shipSizes = {4, 3, 3, 2, 2, 1, 1};
        for (int size : shipSizes) {
            Ship ship = new Ship(size);
            boolean placed = false;
            while (!placed) {
                int row = new Random().nextInt(10);
                int col = new Random().nextInt(10);
                boolean horizontal = new Random().nextBoolean();
                placed = board.placeShip(ship, row, col, horizontal);
            }
        }
    }

    public void play() {
        boolean player1Turn = true;

        while (!isGameOver()) {
            if (player1Turn) {
                System.out.println(player1.getName() + "'s turn:");
                player1.getBoard().printBoard();
                player1.takeTurn(player2);
            } else {
                System.out.println(player2.getName() + "'s turn:");
                player2.getBoard().printBoard();
                player2.takeTurn(player1);
            }
            player1Turn = !player1Turn;
        }

        System.out.println("Game Over!");
        System.out.println((player1Turn ? player2.getName() : player1.getName()) + " wins!");
    }

    private boolean isGameOver() {
        // Add logic to check if all ships are sunk for either player
        return false; // Placeholder implementation
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
