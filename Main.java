import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> computerPosition = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
					{'-', '+', '-', '+', '-'},
					{' ', '|', ' ', '|', ' '},
					{'-', '+', '-', '+', '-'},
					{' ', '|', ' ', '|', ' '},};
			
		printGameBoard(gameBoard);
		
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Geben Sie Ihre Eingabe ein (1-9): ");
			int playerPos = scanner.nextInt();
			
			while(playerPosition.contains(playerPosition)|| computerPosition.contains(playerPosition)) {
				System.out.println("Position schon vergeben. Geben Sie eine korrekte Position: ");
				playerPos = scanner.nextInt();
			}
			
			placePiece(gameBoard, playerPos, "player");
			
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			
			Random random = new Random();
			int computerPos = random.nextInt(9)+1;
			
			while(playerPosition.contains(computerPosition)|| computerPosition.contains(computerPosition)) {
				computerPos = random.nextInt(9)+1;
			}
			
			placePiece(gameBoard, computerPos, "computer");
			
			printGameBoard(gameBoard);
			
			result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
		}
		
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		
		List leftCol = Arrays.asList(1, 4, 7);
		List middleCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		
		List diag1 = Arrays.asList(1, 5, 9);
		List diag2 = Arrays.asList(7, 5, 3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(middleRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(middleCol);
		winning.add(rightCol);
		winning.add(diag1);
		winning.add(diag2);
		
		for(List l: winning) {
			if(playerPosition.containsAll(l)) {
				return "Herzlichen Glückwunsch, Sie haben gewonnen!";
			}
			else if(computerPosition.containsAll(l)) {
				return "Sie haben verloren :(";
			}
			else if(playerPosition.size() + computerPosition.size() == 9) {
				return "Unentschieden!";
			}
		}
		return "";
		
	}
	
	public static void placePiece(char[][]gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPosition.add(pos);
		}else if(user.equals("computer")) {
			symbol = 'O';
			computerPosition.add(pos);
		}
		
		switch(pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
		}
	}
	
	public static void printGameBoard(char[][] gameBoard) {

		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
