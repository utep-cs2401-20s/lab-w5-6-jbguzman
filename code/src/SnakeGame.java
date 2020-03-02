public class SnakeGame {
    private boolean [][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //default constructor
    public SnakeGame(){
        game = new boolean[1][1];
    }

    //constructor
    public SnakeGame(boolean[][] game, int x, int y){
        this.game = game;
        this.headPosition = new int[2];
        this.headPosition[0] = x;
        this.headPosition[1] = y;
    }

    //reset counters
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    //getter
    public static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

    //getter
    public static int getRecursiveChecks(){
        return recursiveChecks;
    }

    //Helper method to count neighbors
    public int neighbors(int r, int c) { //Helper method to count the 4 possible neighbours
        int neighbor = 0;
        if (game[r][c + 1] && c + 1 < game[r].length) { //If right neighbor is a snake and is in the board
            neighbor++;
        }
        if (game[r + 1][c] && r + 1 < game.length) { //If bottom neighbor is a snake and is in the board
            neighbor++;
        }
        if (game[r - 1][c] && r - 1 >= 0) { //If top neighbor is a snake and is in the board
            neighbor++;
        }
        if (game[r][c - 1] && c - 1 >= 0) { //If left neighbor is a snake and is in the board
            neighbor++;
        }
        return neighbor;
    }

    //Exhaustive method
    public int[] findTailExhaustive() {
        resetCounters();
        int length = 0;
        int[] result = new int[3];
        int tailX = 0;
        int tailY = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                exhaustiveChecks ++;
                if (game[i][j]) { //If part of snake
                    length++;
                    int sumNeighbors = neighbors(i, j); //Calls neighbors method to count number of neighbors and see if cell is a head/tail or none
                    if (sumNeighbors == 1) { //Checking to see if cell is at the head/tail
                        if (!game[headPosition[0]][headPosition[1]]) { //If the cell is tail
                            tailX = i;
                            tailY = j;
                        }
                    }
                }
            }
        }
        return result = new int[]{tailX, tailY, length};
    }

    //empty Recursive method
    public int[] findTailRecursive(){
        resetCounters();
        int length = 0;
        int[] result = new int[3];
        int tailX = 0;
        int tailY = 0;
        int[] head = findTailRecursive(headPosition, headPosition);
        recursiveChecks++;
        return result = new int[]{tailX, tailY, length};
    }

    //Recursive method with parameters
    private int[] findTailRecursive(int[] currentPosition, int [] previousPosition){
        resetCounters();
        int length = 1; //Counts head
        int[] result = new int[3];
        int tailX = 0;
        int tailY = 0;
        int sumNeighbors = neighbors(currentPosition[0], currentPosition[1]); //Get the neighbors of head
        recursiveChecks ++;
        if (sumNeighbors == 1 && currentPosition == previousPosition) { //If at head, update current and previous position
            int[] c = currentPosition;
            currentPosition[0]++;
            currentPosition[1]++;
            previousPosition = c;
        }
        if (sumNeighbors > 1) { //If along the snake
            length++;
            findTailRecursive();
        }
        if (sumNeighbors == 1 && currentPosition != previousPosition) { //If at tail
            tailX = currentPosition[0];
            tailY = currentPosition[1];
        } else {
            findTailRecursive();
        }
        return result = new int[]{tailX, tailY, length};
    }
}
