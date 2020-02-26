public class SnakeGame {
    private boolean [][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //comment here
    public SnakeGame() {
        boolean[][] board = new boolean[1][1];
    }

    public SnakeGame(boolean[][] board, int x, int y){
        helper(board);
        this.headPosition[0] = x;
        this.headPosition[1] = y;

    }

    public boolean helper(boolean[][] board){
        for(int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game = new int[][] board;
            }
        }
        return true;
    }

    public int[] findTailExhaustive(){
        resetCounters();

        //return
    }

    public int[] findTailRecursive(){
        resetCounters();


    }

    private int[] findTailRecursive(int[] currentPosition, int [] previousPosition){
//
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){
        return recursiveChecks;

    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;

    }




}
