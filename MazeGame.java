package MazeGamee;

import java.util.Scanner;
import java.io.IOException;

public class MazeGame {

	public static Scanner input = new Scanner(System.in);
    public static Maze mazeTable = new Maze();
    
    public static void main(String[] args){
        //declaring variables
        String direction = "";
        int moveCount = 0;

        // welcome message
        intro();
        
        while(!mazeTable.didIWin()) {
            direction = userMove(); /*prompting and getting user direction input*/
            takeMove(direction); /*checking and making move if it is possible*/
            ++moveCount;
            movesMessage(moveCount);
            if (moveCount>60) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            }
        }
        //closing message
        System.out.println("Congratulations, you made it out alive! And you did it in " + moveCount + " moves");
    }
    
    public static void intro(){
        System.out.println("Welcome to Maze Game!\n Here is your current position:");
        mazeTable.printMap();
    }
    
    public static String userMove(){
        String userChoice;
        do{
            System.out.print("Where would you like to move? (r, l, u, d) ");
            userChoice = input.next();
        }while(!userChoice.equals("r") && !userChoice.equals("l") && !userChoice.equals("u") && !userChoice.equals("d"));
        
        	try { //to clear old version of mazeTable
        		Process exitCode;
        		if( System.getProperty( "os.name" ).startsWith( "Window" ) ) {
        			exitCode = Runtime.getRuntime().exec("cls");
        		}else {
        			exitCode = Runtime.getRuntime().exec("clear");
        		}
        	}catch (IOException e) {
        		for(int i = 0; i < 1000; i++) {
        			System.out.println();
        		}
        	}

        return userChoice;
    }
    
    public static void movesMessage(int moves){
        if (moves == 30) {
            System.out.println("Warning: You have made 30 moves, you have 30 remaining before the maze exit closes");
        } else if (moves == 45) {
            System.out.println("Alert! You have made 45 moves, you only have 15 moves left to escape.");
        } else if (moves == 60) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }
    
    public static void takeMove(String userChoice){
    	if(userChoice.equals("u") && mazeTable.canIMoveUp()) {
            mazeTable.moveUp();
        } else if (userChoice.equals("d") && mazeTable.canIMoveDown()) {
            mazeTable.moveDown();
        } else if (userChoice.equals("l") && mazeTable.canIMoveLeft()) {
            mazeTable.moveLeft();
        } else if (userChoice.equals("r") && mazeTable.canIMoveRight()){
            mazeTable.moveRight();
        }  else {
            System.out.println("Sorry, but you’ve hit a wall.");
        }

        mazeTable.printMap();
    }

}
