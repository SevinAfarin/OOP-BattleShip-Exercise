import java.util.Scanner;
public class Player {
    private String name;
    private Board board;

    public Player(String name) {
        this.name = name;
        this.board = new Board();
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public void takeTurn(Player opponent) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", enter your attack coordinates (e.g., A5): ");
        String input = scanner.next().toUpperCase();

        int row = input.charAt(0) - 'A';
        int col = input.charAt(1) - '1';

        boolean hit = opponent.getBoard().attack(row, col);
        if (hit) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss!");
        }
    }
}
