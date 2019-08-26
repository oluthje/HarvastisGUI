import java.util.*;

public class Scene {
	protected int playerPosUp;
	protected int playerPosAcross;

	protected static int oldNewFileVar = 0;
	protected static int newFileVar = 0;

	protected String[][] array;
	protected String sceneAsString;
	protected String storyInformation;
	protected String currentStoryInformation;
	protected static String sceneToGUI;
	protected static String sceneInformation;
	protected boolean gameWon = false;
	protected boolean firstTablePrint = true;
	protected boolean firstSceneSpawn = true;
	protected static Scanner entered = new Scanner(System.in);
	protected static String input;
	protected static Player player = new Player();
	protected static Harvastis game = new Harvastis();

	protected ArrayList<Enemy> enemyList = new ArrayList<>();
	protected ArrayList<Door> doorList = new ArrayList<>();
	protected ArrayList<Key> keyList = new ArrayList<>();

	public void checkIfNewFileInfo() {
		boolean running = true;
		while (running == true) {
			RetrieveGUIInput getInput = new RetrieveGUIInput();
			getInput.loadPlayerInputFromFile();
			newFileVar = getInput.fileVar;
			if (oldNewFileVar != newFileVar) {
				input = getInput.playerInput;
				running	= false;
				oldNewFileVar = newFileVar;
			}
			try {
				Thread.sleep(10);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void placeEnemies() {
		// Places all enemies from enemyList in the scene array
		for (int i = 0; i < enemyList.size(); i++) {
			if (firstTablePrint == false) {
				array[enemyList.get(i).getPosUp()][enemyList.get(i).getPosAcross()] = "E";
				enemyList.get(i).moveOnPath();
				array[enemyList.get(i).getPosUp()][enemyList.get(i).getPosAcross()] = " ";
			}
		}
	}

	public void placeEntities() {
		// Places all doors from doorList in the scene array
		for (int i = 0; i < doorList.size(); i++) {
			if (firstTablePrint == false) {
				array[doorList.get(i).getPosUp()][doorList.get(i).getPosAcross()] = "D";
			}
		}

		// Places all keys from keyList in the scene array
		for (int i = 0; i < keyList.size(); i++) {
			if ((firstTablePrint == false) && (keyList.get(i).getIfCollected() == false)) {
				array[keyList.get(i).getPosUp()][keyList.get(i).getPosAcross()] = "K";
			}
		}
	}

	public void removeOldEntities() {
		array[player.getPosUp()][player.getPosAcross()] = " ";
	}

	public void clearPage() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void printInfo() {
		// Clears page
		clearPage();
		System.out.println("===Harvastis===");

		System.out.println("P = player");
		System.out.println("W = wall");
		System.out.println("K = key");
		System.out.println("E = enemy");
		
		// Writes keyCount info above the game
		sceneInformation = "";
		if (player.getKeyCount("goldKeyCount") == 0 && player.getKeyCount("emeraldKeyCount") == 0) {
			sceneInformation = sceneInformation + "\n";
		} else if (player.getKeyCount("goldKeyCount") != 0) {
			sceneInformation = sceneInformation + "Gold Keys: " + player.getKeyCount("goldKeyCount");
		} else if (player.getKeyCount("emeraldKeyCount") != 0) {
			sceneInformation = sceneInformation + "Emerald Keys: " + player.getKeyCount("emeraldKeyCount");
		}
		System.out.print(sceneInformation);
		
		// Writes storyInformation
		if ((firstSceneSpawn == true) && (storyInformation != null)) {
			// Writes === as long as the scene is
			for (int i = 0; i < array[0].length; i++) {
				System.out.print("==");
			}
			System.out.println("="); // just goes to next line
			System.out.println(storyInformation);
		}
		
		// Writes === as long as the scene is
		for (int i = 0; i < array[0].length; i++) {
			System.out.print("==");
		}
		System.out.println("="); // just goes to next line
	}

	public void printScene() {
		printInfo();

		// Assigns all values in array from null to " "
		// Only runs once at the beginning
		if (firstTablePrint == true) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					array[i][j] = " ";
				}
			}
			placeEnemies();
			placeEntities();
			firstTablePrint = false;
		}

		placeEnemies();
		placeEntities();
		// Paints the scene to be sent to pythonGUI
		sceneToGUI = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j == 0) {
					sceneToGUI = sceneToGUI + "|";
				}
				if (j == array[0].length - 1) {
					sceneToGUI = sceneToGUI + array[i][j];
				} else {
					sceneToGUI = sceneToGUI + array[i][j];
				}
			}
			sceneToGUI = sceneToGUI + "|\n";
		}

		// Paints the scene to be used for game
		sceneAsString = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j == 0) {
					sceneAsString = sceneAsString + "|";
				}
				if (j == array[0].length - 1) {
					sceneAsString = sceneAsString + array[i][j];
				} else {
					sceneAsString = sceneAsString + array[i][j] + " ";
				}
			}
			sceneAsString = sceneAsString + "|\n";
		}
		System.out.print(sceneAsString);

		for (int i = 0; i < array[0].length; i++) {
			System.out.print("==");
		}
		System.out.println("="); // just goes to next line

		SendToGUI sendToGUI = new SendToGUI();
		sendToGUI.sendVariablesToGUI();
		acceptPlayerInput();
	}

	public void acceptPlayerInput() {
		removeOldEntities();

		/*
		System.out.println("Press ENTER to wait or ");
		System.out.print("W, A, S, or D to move: ");
		input = entered.nextLine();
		input = input.toLowerCase();
		// REPLACE THIS HERE STOOF WITH NEW INPUT GETTER THINGY
		*/

		checkIfNewFileInfo();

		// In future, create method that when called will update
		// everything like enemy movement which are based on turns.

		switch(input) {
			case "w":
				if (player.getPosUp() > 0) {
					player.setPosUp(-1);
					checkCollision(-1, "Up");
				}
				break;
			case "a":
				if (player.getPosAcross() > 0) {
					player.setPosAcross(-1);
					checkCollision(-1, "Across");
				}
				break;
			case "s":
				if (player.getPosUp() < array.length-1) {
					player.setPosUp(1);
					checkCollision(1, "Up");
				}
				break;
			case "d":
				if (player.getPosAcross() < array[0].length-1) {
					player.setPosAcross(1);
					checkCollision(1, "Across");
				}
				break;
			default:
				System.out.println("You must enter either W A S or D to move!");
				checkCollision(0, "Across");	
		}
	}

	public void checkCollision(int posChange, String direction) {
		
		checkForEnemy();

		// Checks for a door collision
		for (int i = 0; i < doorList.size(); i++) {
			if ((player.getPosUp() + " " + player.getPosAcross()).equals(doorList.get(i).getPosUp() + " " + doorList.get(i).getPosAcross())) {
				if (doorList.get(i).getIfRequiresKey() == true) {
					if (player.getKeyCount("goldKeyCount") > 0 && doorList.get(i).getKeyID().equals("goldKey")) {	
						player.addToKeyCount(-1, "goldKeyCount");
						doorList.get(i).unlockDoor();
					} 
					if (player.getKeyCount("emeraldKeyCount") > 0 && doorList.get(i).getKeyID().equals("emeraldKey")) {
						player.addToKeyCount(-1, "emeraldKeyCount");
						doorList.get(i).unlockDoor();
					} else {
						if (direction.equals("Up")) {
							player.setPosUp(-posChange);
						} else if (direction.equals("Across")) {
							player.setPosAcross(-posChange);
						} else {
							System.out.println("its neither Up nor Across");
						}
						// check for enemy if can't move through door
						checkForEnemy();
					}
				}

				if ((doorList.get(i).getIfHasExit()) && (doorList.get(i).getIfRequiresKey() == false)) {
					firstSceneSpawn = false;
					player.setPos((doorList.get(i).getSetPlayerPosUp()), (doorList.get(i).getSetPlayerPosAcross()));
					
					System.out.println("Up: " + doorList.get(i).getSetPlayerPosUp() + " Across: " + doorList.get(i).getSetPlayerPosAcross());
					System.out.println("Up: " + player.getPosUp() + " Across: " + player.getPosAcross());
					
					game.setCurrentScene(doorList.get(i).getExit());
				}
			}
		}

		// Checks for a key collision
		for (int i = 0; i < keyList.size(); i++) {
			if ((player.getPosUp() + " " + player.getPosAcross()).equals(keyList.get(i).getPosUp() + " " + keyList.get(i).getPosAcross())) {
				if (keyList.get(i).getIfCollected() == false) {
					keyList.get(i).makeCollected();
					if (keyList.get(i).getKeyID().equals("goldKey")) {
						player.addToKeyCount(1, "goldKeyCount");
					}
					if (keyList.get(i).getKeyID().equals("emeraldKey")) {
						player.addToKeyCount(1, "emeraldKeyCount");
					}
				}
			}
		}

		switch(array[player.getPosUp()][player.getPosAcross()]) {
			case "W":
				if (direction.equals("Up")) {
					player.setPosUp(-posChange);
				} else if (direction.equals("Across")) {
					player.setPosAcross(-posChange);
				} else {
					System.out.println("its neither Up nor Across");
				}
				// Check for the enemy
				checkForEnemy();
				break;
		}
	}

	public void checkForEnemy() {
		for (int i = 0; i < enemyList.size(); i++) {
			System.out.println("Player pos: " + player.getPosUp() + " " + player.getPosAcross() + " Enemy pos: " + enemyList.get(i).getPosUp() + " " + enemyList.get(i).getPosAcross());
			if ((player.getPosUp() + " " + player.getPosAcross()).equals(enemyList.get(i).getPosUp() + " " + enemyList.get(i).getPosAcross())) {
				game.gameWon = true;
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("You have collided with an enemy and lost the game");
			}
		}
	}
}