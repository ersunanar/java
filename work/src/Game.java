import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Game {
		
		
		Random rnd = new Random();
	
		private int boardSize;
		private ArrayList<GameObject> gameObjects;
		private Player player;
		private Robot robot;
		private Treasure treasure;
		
			
		
		public Game(int boardSize) {
				
			
			this.boardSize = boardSize;
		
		ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
		
		int treasure_x = rnd.nextInt(boardSize);
		int treasure_y = rnd.nextInt(boardSize);
		GameObject treasure = new Treasure(treasure_x,treasure_y);
		
		this.treasure = (Treasure)treasure;
		
		int player_x = rnd.nextInt(boardSize);
		int player_y = rnd.nextInt(boardSize);
		
		
		while (player_x==treasure_x && player_y == treasure_y) {
			
			player_x = rnd.nextInt(boardSize);
			player_y = rnd.nextInt(boardSize);			
		}		
		
		int distance = (int)calculateDistance(player_x,player_y,treasure_x,treasure_y);
		
		Player player = new Player(player_x,player_y,distance);
		this.player = player;
		
		int robot_x = rnd.nextInt(boardSize);
		int robot_y = rnd.nextInt(boardSize);	
		
		while ((robot_x==treasure_x && robot_y == treasure_y)||
				(robot_x==player_x && robot_y == player_y)) {
			
			robot_x = rnd.nextInt(boardSize);
			robot_y = rnd.nextInt(boardSize);			
		}		
			
		GameObject robot = new Robot(robot_x,robot_x);	
		this.robot = (Robot)robot;
		
		
		
		int tree1_x = rnd.nextInt(boardSize);
		int tree1_y = rnd.nextInt(boardSize);	
		
		while ((tree1_x==treasure_x && tree1_y == treasure_y)||
				(tree1_x==player_x && tree1_y == player_y)||
				(tree1_x==robot_x && tree1_y == robot_y)) {
			
			tree1_x = rnd.nextInt(boardSize);
			tree1_y = rnd.nextInt(boardSize);			
		}		
			
		GameObject tree1 = new Tree(tree1_x,tree1_y);
		
		
		int tree2_x = rnd.nextInt(boardSize);
		int tree2_y = rnd.nextInt(boardSize);
		
		while ((tree2_x==treasure_x && tree2_y == treasure_y)||
				(tree2_x==player_x && tree2_y == player_y)||
				(tree2_x==robot_x && tree2_y == robot_y)||
				(tree2_x==tree1_x && tree2_y == tree1_y)) {
			
			tree2_x = rnd.nextInt(boardSize);
			tree2_y = rnd.nextInt(boardSize);			
		}			
		
		GameObject tree2 = new Tree(tree2_x,tree2_y);
		
		
		int house_x = rnd.nextInt(boardSize);
		int house_y = rnd.nextInt(boardSize);
		
		while ((house_x==treasure_x && house_y == treasure_y)||
				(house_x==player_x && house_y == player_y)||
				(house_x==robot_x && house_y == robot_y)||
				(house_x==tree1_x && house_y == tree1_y)||
				(house_x==tree2_x && house_y == tree2_y)) {
			
			house_x = rnd.nextInt(boardSize);
			house_y = rnd.nextInt(boardSize);			
		}			
		
		GameObject house = new House(house_x,house_y);
		
		gameObjects.add(treasure);
		gameObjects.add(robot);
		gameObjects.add(house);
		gameObjects.add(tree1);
		gameObjects.add(tree2);
		
		this.gameObjects = gameObjects;
		
		}
		
		private double calculateDistance(int x1,int y1, int x2, int y2) {
			
			double absX = Math.abs(x1-x2);
			double absY = Math.abs(y1-y2);
			double squareX = Math.pow(absX,2);
			double squareY = Math.pow(absY,2);
			double distance = Math.pow((squareX+squareY),0.5);		
			return distance;
		}
		
		
		public void play() {
			Scanner sc = new Scanner(System.in);
			
			outer:
			for (int turn = 1; turn <= 10; turn++) {
								
				System.out.println("Turn: "+turn);
				
				System.out.println("You are in position x: "+ player.getPosX()+" y: "+player.getPosY());
				System.out.println("please enter position x for player: ");				
				int new_x = sc.nextInt();
				System.out.println("please enter position y for player: ");				
				int new_y = sc.nextInt();
				
				while (new_x >= boardSize ||new_y >= boardSize) {
					System.out.println("your x-y cordinates is outside the board!!!!!");
					System.out.println("please enter position x for player: ");				
					new_x = sc.nextInt();
					System.out.println("please enter position y for player: ");				
					new_y = sc.nextInt();				
				}
				
				boolean canMove = true;
				
				for (GameObject gameobject : gameObjects) {
					if (gameobject.toString().equals("Robot") && new_x ==  gameobject.getPosX() && new_y == gameobject.getPosY()) {
					System.out.println("you hit the robot, you lost the game");
					break outer;
				
				} else if (gameobject.toString().equals("Treasure") && new_x == gameobject.getPosX() && new_y == gameobject.getPosY()) {
					System.out.println("you found the treasure, you won the game");					
					break outer;
					
				} else if (gameobject.toString().equals("House") &&  new_x == gameobject.getPosX() && new_y == gameobject.getPosY()) {
				
					System.out.println("you can not go there, there is a House");
					canMove = false;
					break;
					
				} else if (gameobject.toString().equals("Tree") &&  new_x == gameobject.getPosX() && new_y == gameobject.getPosY()) {
					System.out.println("you can not go there, there is a Tree");
					canMove = false;
					break;
				}
			}
				
				if (canMove) {					
					
					player.move(new_x, new_y);
					int newDistance =  (int) calculateDistance(new_x,new_y,treasure.getPosX(),treasure.getPosY());
					if (newDistance < player.getPreviousDistance()) {
						System.out.println("you are getting closer to the treasure");
						player.setPreviousDistance(newDistance);
					} else {
						System.out.println("you are getting far to the treasure or your distance to the treasure is same");
						player.setPreviousDistance(newDistance);
					}
				}				
						
				int new_x_forRobot = rnd.nextInt(boardSize);
				int new_y_forRobot = rnd.nextInt(boardSize);
				
				if (new_x_forRobot == treasure.getPosX() && new_y_forRobot == treasure.getPosY()) {
					
					System.out.println("Robot found the treasure\nYou lost the game");
					break outer;					
				} else if (new_x_forRobot == player.getPosX() && new_y_forRobot == player.getPosY()) {
					
					System.out.println("Robot hit you\nYou lost the game");
					break outer;					
				} else {
					robot.move(new_x_forRobot, new_y_forRobot);
					
				}				
			}
		}
		
		
		
		public static void main(String[] args) {			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the board size: ");
			int sizeOfBoard = sc.nextInt();
			
			while (sizeOfBoard < 5) {
				System.out.println("the boardsize must be greater than or equal to 5");
				sizeOfBoard = sc.nextInt();
			}		
			
			Game game = new Game(sizeOfBoard);
			game.play();
			
		sc.close();	
		}
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	

}
