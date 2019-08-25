public class Harvastis {
	static String input;
	static boolean gameWon = false;
	static SpaceshipScenes spaceShipScenes;
	static CellScene cellScene;
	static HallwayOneScene hallwayOneScene;
	static HallwayTwoScene hallwayTwoScene;
	static ArmoryScene armoryScene;
	static HallwayThreeScene hallwayThreeScene;
	static KeyRoomScene keyRoomScene;
	static EscapePodScene escapePodScene;
	
	static Harvastis game;
	static String currentScene = "cellScene";

	public void setCurrentScene(String sumVar) {
		currentScene = sumVar;
	}

	public void start() {
		while (gameWon == false) {
			switch (currentScene) {
				case "cellScene":
					cellScene.printScene();
					break;
				case "hallwayOneScene":
					hallwayOneScene.printScene();
					break;
				case "hallwayTwoScene":
					hallwayTwoScene.printScene();
					break;
				case "armoryScene":
					armoryScene.printScene();
					break;
				case "hallwayThreeScene":
					hallwayThreeScene.printScene();
					break;
				case "keyRoomScene":
					keyRoomScene.printScene();
					break;
				case "escapePodScene":
					escapePodScene.printScene();
					break;
				case "gameCompleted":
					gameWon = true;
					cellScene.clearPage();
					System.out.println("You have escaped and completed the game");
					break;
			}
		}
	}

	public static void main(String[] args) {
		game = new Harvastis();
		cellScene = new CellScene();
		hallwayOneScene = new HallwayOneScene();
		hallwayTwoScene = new HallwayTwoScene();
		armoryScene = new ArmoryScene();
		hallwayThreeScene = new HallwayThreeScene();
		keyRoomScene = new KeyRoomScene();
		escapePodScene = new EscapePodScene();
		game.start();
	}
}

/*
Ideas:

-be able to get armor to have an extra life against enemies.
-have multiple types of Keys (gold, emerald, diamond) for 
different doors.
-be able to open chests(perhaps with keys) to get cool items.
-make key a class to have different types of keys.

*/