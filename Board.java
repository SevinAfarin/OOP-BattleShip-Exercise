public class Board {
    private static final int GRID_SIZE = 10;
    private char[][] grid;

    public Board() {
        grid = new char[GRID_SIZE][GRID_SIZE];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = '~'; // '~' represents water
            }
        }
    }

    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (canPlaceShip(ship, row, col, horizontal)) {
            for (int i = 0; i < ship.getSize(); i++) {
                if (horizontal) {
                    grid[row][col + i] = 'S'; // 'S' represents a ship
                } else {
                    grid[row + i][col] = 'S';
                }
            }
            return true;
        }
        return false;
    }

    private boolean canPlaceShip(Ship ship, int row, int col, boolean horizontal) {
        int size = ship.getSize();
        if (horizontal) {
            if (col + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != '~') return false;
            }
        } else {
            if (row + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] != '~') return false;
            }
        }
        return true;
    }

    public boolean attack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X'; // 'X' represents a hit
            return true;
        } else if (grid[row][col] == '~') {
            grid[row][col] = 'M'; // 'M' represents a miss
        }
        return false;
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 1; i <= GRID_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
