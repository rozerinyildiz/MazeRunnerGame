package MazeGamee;

public class Maze {
	private char[][] mazeTable;
    private int row;
    private int col;
    private int tempRow;
    private int tempCol;
    
    public Maze() {
        row = 0; 
        col = 5;  
        mazeTable = new char[10][12];  
        fillMap(mazeTable);
      
    }
    
    private void fillMap(char[][] map) {
        for(int row2=0;row2<10;row2++){
    		 for(int col2=0;col2<12;col2++) {
    			 map[row2][col2] = '*';
    		 }
    	 }
    	 mazeTable[0][5] = 'S'; // start
    	 mazeTable[row+1][col] = ' ';
    	 mazeTable[row+2][col] = ' ';
    	 mazeTable[row+2][col+1] = ' ';
    	 mazeTable[row+2][col+2] = ' ';
    	 mazeTable[row+2][col+3] = ' ';
    	 mazeTable[row+3][col+3] = ' ';
    	 mazeTable[row+4][col+3] = ' ';
    	 mazeTable[row+5][col+3] = ' ';
    	 mazeTable[row+6][col+3] = ' ';
    	 mazeTable[row+6][col+4] = ' ';
    	 mazeTable[row+6][col+5] = ' ';
    	 mazeTable[row+7][col+5] = ' ';
    	 mazeTable[row+8][col+5] = ' ';
    	 mazeTable[row+9][col+5] = 'F'; // finish
    	 
    	 }
    
    public void printMap() {
        printMap(mazeTable);
    }

    private void printMap(char[][] map) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
   private boolean canMove(int rowMove, int colMove) {
        if (col + colMove > 12 || col + colMove < 0 ||
            row + rowMove > 10 || row + rowMove < 0) {
            return false;
        }else if (mazeTable[row + rowMove][col + colMove] == 'F') { // chNGED
        	tempRow = row + rowMove;
        	tempCol = col + colMove;
        	return didIWin();
        }else if(mazeTable[row + rowMove][col + colMove] == ' ') {
        	return true;
        }else {
        	return false;
        }
    }
    
    public boolean didIWin() {
        if (tempRow == 9 && tempCol == 10) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean canIMoveRight() {
        return canMove(0,1);
    }

    public boolean canIMoveLeft() {
        return canMove(0,-1);
    }

    public boolean canIMoveUp() {
        return canMove(-1,0);
    }

    public boolean canIMoveDown() {
        return canMove(1,0);
    }
    
    private void move(int rowMove, int colMove) {
        
    	if(canMove(rowMove, colMove)) {
            
        	mazeTable[row][col] = ' ';
            row += rowMove;
            col += colMove;
            mazeTable[row][col] = 'S';
         } if(mazeTable[row][col] == '*') { 
            throw new IllegalArgumentException("ERROR: You cannot move that way");
        }
       
    }
    
    public void moveRight() {
        move(0, 1);
    }

    public void moveLeft() {
        move(0, -1);
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveDown() {
        move(1, 0);
    }
    
}