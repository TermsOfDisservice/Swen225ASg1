import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;

public class Cluedo_movementv2 {
    public static void main(String[] args) {
        // Create a 2D array to represent the board
        Tile[][] board = new Tile[24][24];
        Room Haunted_House = new Room();

        // Populate the board with empty tiles (assuming '*' as an empty character)
        char emptyChar = '*';
        
        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 24; x++) {
                if(x > 1 && x < 7 && y > 1 && y < 7){
                    if((x == 6 && y == 3) || (x == 5 && y == 6)){
                        board[x][y] = new Tile(x, y, '_'); // door 
                    }
                    else if(((x > 1 && x < 7) && (y == 2 || y == 6)) || ((x == 2 || x == 6) && (y > 1 && y < 7))){
                        board[x][y] = new Tile(x, y, 'w'); // wall 
                    }
                
                    else board[x][y] = new Tile(x, y, 'H');
                }
                else  if(x > 16 && x < 22 && y > 1 && y < 7) {
                    
                    if((x == 17 && y == 5) || (x == 20 && y == 6)){
                        board[x][y] = new Tile(x, y, '_'); // door 
                    }
        
                    else if(((x > 16 && x < 22) && (y == 2 || y == 6)) || ((x == 17 || x == 21) && (y > 1 && y < 7))){
                        board[x][y] = new Tile(x, y, 'w'); // wall 
                    }
                    else board[x][y] = new Tile(x, y, 'M');
                }
                else if(x > 1 && x < 7 && y > 16 && y < 22){
                    
                    if((x == 3 && y == 17) || (x == 6 && y == 18)){
                        board[x][y] = new Tile(x, y, '_'); // door 
                    }
                    else if(((x > 1 && x < 7) && (y == 17 || y == 21)) || ((x == 2 || x == 6) && (y > 16 && y < 22))){
                        board[x][y] = new Tile(x, y, 'w'); // wall 
                    }
                    else board[x][y] = new Tile(x, y, 'C');
                }
                else if(x > 16 && x < 22 && y > 16 && y < 22){
                    if((x == 18 && y == 17) || (x == 17 && y == 20)){
                        board[x][y] = new Tile(x, y, '_'); // door 
                    }
                    
                    else if(((x > 16 && x < 22) && (y == 17 || y == 21)) || ((x == 17 || x == 21) && (y > 16 && y < 22))){
                         board[x][y] = new Tile(x, y, 'w'); // wall 
                    }
                    else board[x][y] = new Tile(x, y, 'P');
                }
                else if(x > 8 && x < 15 && y > 9 && y < 14){
                    
                    if((x == 12 && y == 10) || (x == 14 && y == 11) || (x == 9 && y == 12) || (x == 11 && y == 13)){
                        board[x][y] = new Tile(x, y, '_'); // door 
                    }
                    else if(((x > 8 && x < 15) && (y == 10 || y == 13)) || ((x == 9 || x == 14) && (y > 9 && y < 14))){
                         board[x][y] = new Tile(x, y, 'w'); // wall 
                    }
                    else board[x][y] = new Tile(x, y, 'V');
                }
                else if((x > 4 && x < 7 && y > 10 && y < 13) ||
                        (x > 16 && x < 19 && y > 10 && y < 13) ||
                        (x > 10 && x < 13 && y > 4 && y < 7) ||
                        (x > 10 && x < 13 && y >16 && y < 19)){ 
                            board[x][y] = new Tile(x, y, 'G'); 
                        }
            
                else board[x][y] = new Tile(x, y, ' ');
            }
        }
        

        // Create 4 players and place them on the board
        List<Player> players = new ArrayList<>();
        players.add(new Player(14, 1, '1'));
        players.add(new Player(1, 9, '2'));
        players.add(new Player(9, 22, '3'));
        players.add(new Player(22, 14, '4'));

        // Print the initial board
        printBoard(board, players);

        // Handle player movement in turns
        Scanner scanner = new Scanner(System.in);
        int currentPlayerIndex = 0;

        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println();
            System.out.println("Player " + currentPlayer.getPlayerID() + "'s turn.");
            
            
            // Roll the dice and get the number of steps to move
            int stepsToMove = (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1);
            System.out.println("You rolled a " + stepsToMove + ". Press Enter to continue...");
            scanner.nextLine();

            // Clear the previous player position
            board[currentPlayer.getX()][currentPlayer.getY()].setType(' ');

            // Move the player and update the board
            for (int i = 0; i < stepsToMove; i++) {
                // Get the desired movement direction from the player
                System.out.print("Enter direction (UP/W, DOWN/S, LEFT/A, RIGHT/D): ");
                String input = scanner.nextLine();
                //board[currentPlayer.getX()][currentPlayer.getY()].setType(' ');
                int curX;
                int curY;
                String in = input;
                boolean c = false;
                if (input.equalsIgnoreCase("UP") || input.equalsIgnoreCase("W")) {
                    checkCollisionAndMove(board, currentPlayer, players, currentPlayer.getX(), currentPlayer.getY()-1, input);
  

                } else if (input.equalsIgnoreCase("DOWN") || input.equalsIgnoreCase("S")) {
                    checkCollisionAndMove(board, currentPlayer, players, currentPlayer.getX(), currentPlayer.getY()+1, input);

                    
                } else if (input.equalsIgnoreCase("LEFT") || input.equalsIgnoreCase("A")) {
                    checkCollisionAndMove(board, currentPlayer, players,currentPlayer.getX()-1, currentPlayer.getY(), input);
                    
                    
                } else if (input.equalsIgnoreCase("RIGHT") || input.equalsIgnoreCase("D")) {
                   checkCollisionAndMove(board, currentPlayer, players, currentPlayer.getX()+1, currentPlayer.getY(), input);

                    
                } else if (input.equalsIgnoreCase("EXIT")) {
                    System.out.println("Exiting the game.");
                    scanner.close();
                    return;
                } else {
                    System.out.println("Invalid input. Try again.");
                    i--; // Retry the movement input
                }

                // Clear the console for better visibility after each movement
                //clearConsole();

                // Update the player's tile on the board
                //board[currentPlayer.getX()][currentPlayer.getY()].update(currentPlayer.getX(), currentPlayer.getY(), currentPlayer.getPlayerID());

                // Print the updated board
                //printBoard(board, players);
            }

            // Switch to the next player for the next turn
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
    /*
    private static boolean checkCollisionAndMove(Tile[][] board, Player currentPlayer, List<Player> players ,int destX, int destY, String move) {
        if  (destX >= 0 && destX < 24 && destY >= 0 && destY < 24) {
            if (board[destX][destY].getType() != ' ') {
                // do not move the player
                System.out.println("Collision detected. Choose a different direction.");
                return false;
            } else {
                /*
                board[currentPlayer.getX()][currentPlayer.getY()].setType(' ');
                // Move the player to the destination tile
                
                System.out.println("Collision NOT detected");
                clearConsole();
                if (move.equalsIgnoreCase("UP") || move.equalsIgnoreCase("W")) {
                    currentPlayer.moveUp();
                    
                } else if (move.equalsIgnoreCase("DOWN") || move.equalsIgnoreCase("S")) {
                     currentPlayer.moveDown();

                } else if (move.equalsIgnoreCase("LEFT") || move.equalsIgnoreCase("A")) {
                     currentPlayer.moveLeft();
                   
                } else if (move.equalsIgnoreCase("RIGHT") || move.equalsIgnoreCase("D")) {
                    currentPlayer.moveRight();
                }
                board[currentPlayer.getX()][currentPlayer.getY()].update(currentPlayer.getX(), currentPlayer.getY(), currentPlayer.getPlayerID());
                //updated board
                printBoard(board, players); 
                return true;
            }
        } else {
            // Destination is out of bounds; do not move the player
            System.out.println("You cannot move out of bounds. Choose a different direction.");
            return false;
        }
    }  */
    
    private static void checkCollisionAndMove(Tile[][] board, Player currentPlayer, List<Player> players, int destX, int destY, String move) {
        if (destX >= 0 && destX < 24 && destY >= 0 && destY < 24) {
            if (board[destX][destY].getType() != ' ') {
                System.out.println("Collision detected. Choose a different direction.");
            } else {
                
                board[currentPlayer.getX()][currentPlayer.getY()].setType(' ');
    
                
                System.out.println("Collision NOT detected");
                clearConsole();
                if (move.equalsIgnoreCase("UP") || move.equalsIgnoreCase("W")) {
                    currentPlayer.moveUp();
                } else if (move.equalsIgnoreCase("DOWN") || move.equalsIgnoreCase("S")) {
                    currentPlayer.moveDown();
                } else if (move.equalsIgnoreCase("LEFT") || move.equalsIgnoreCase("A")) {
                    currentPlayer.moveLeft();
                } else if (move.equalsIgnoreCase("RIGHT") || move.equalsIgnoreCase("D")) {
                    currentPlayer.moveRight();
                }
    
                
                board[currentPlayer.getX()][currentPlayer.getY()].update(currentPlayer.getX(), currentPlayer.getY(), currentPlayer.getPlayerID());
    
                
                printBoard(board, players);

            }
        } else {
            // Destination is out of bounds, do not move the player
            System.out.println("You cannot move out of bounds. Choose a different direction.");
        }
    }
    // Helper method to print the board
    private static void printBoard(Tile[][] board, List<Player> players) {
        System.out.println("<----------------------MAP---------------------->\n");

        for(int z = 0; z < 25; z++) { System.out.print("__"); }
        System.out.println();
        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 24; x++) {
                char tileContent = board[x][y].getType();
                if(x == 0){ System.out.print("|"); }
                for (Player player : players) {
                    if (player.getX() == x && player.getY() == y) {
                        tileContent = player.getPlayerID();
                        break;
                    }
                }
                System.out.print(tileContent + " ");
            }
            System.out.println(); // Move to the next row after each inner loop
        }
        
        for(int z = 0; z < 25; z++) { System.out.print("__"); }
    }

    // Helper method to clear the console
    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error while clearing the console.");
        }
    }
}

class Tile {
    private char type;
    private int x;
    private int y;

    public Tile(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // Getter for the 'type' field
    public char getType() {
        return type;
    }

    // Setter for the 'type' field
    public void setType(char type) {
        this.type = type;
    }

    // Getter for the 'x' field
    public int getX() {
        return x;
    }

    // Getter for the 'y' field
    public int getY() {
        return y;
    }

    // Setter for the 'x' field
    public void update(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

class Player {
    private int x;
    private int y;
    private char playerID;

    public Player(int initialX, int initialY, char playerID) {
        this.x = initialX;
        this.y = initialY;
        this.playerID = playerID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPlayerID() {
        return playerID;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
    
    public void setX(int newX){
        x = newX;
    }
    
    public void setY(int newY){
        y = newY;
    }
}

class Room{
    HashSet<Tile> roomTile;
    public void addTile(Tile a ){
            
    }


}

class hauntedHouse extends Room{





}
