class SpaceshipScenes {
	
}

class CellScene extends Scene {
	CellScene() {
		array = new String[9][11];
		storyInformation = "You wake up in a room littered with dead bodies.\nIt appears this is a prisoner holding cell.\nYou hear sirens onboard --starship sirens.\nYou look around at the damage sustained.\nThe door is open.";
		currentStoryInformation = storyInformation;

		// Stuff we want to run only once when AllScenes object is created
		player.setPos(5, 2);
		//player.addToKeyCount(1, "emeraldKeyCount");

		doorList.add(new Door(3, 4, false, false));
		doorList.add(new Door(0, 3, false, 8, 3, true, "hallwayOneScene"));
		doorList.add(new Door(8, 7, true, 0, 7, true, "escapePodScene", "emeraldKey"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[0][2] = "W";
		array[0][4] = "W";
		
		array[2][0] = "W";
		array[2][1] = "W";
		array[2][2] = "W";
		array[2][3] = "W";
		array[2][4] = "W";
		
		array[4][4] = "W";
		array[5][4] = "W";
		array[6][4] = "W";
		array[7][4] = "W";
		array[8][4] = "W";
	
		array[8][6] = "W";
		array[8][8] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class EscapePodScene extends Scene {
	
	boolean cielingCaved = false;
	
	EscapePodScene() {
		array = new String[9][11];
		storyInformation = "You enter to find escape pods.\nNone have been used.\nBetter get moving. ";
		currentStoryInformation = storyInformation;

		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(0, 7, false, 8, 7, true, "cellScene"));
		
		doorList.add(new Door(7, 1, false, 8, 7, true, "gameCompleted"));
		doorList.add(new Door(7, 5, false, 8, 7, true, "gameCompleted"));
		doorList.add(new Door(7, 9, false, 8, 7, true, "gameCompleted"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[0][6] = "W";
		array[0][8] = "W";
		
		if (player.getPosUp() > 2 && cielingCaved == false) {
			storyInformation = "Skrrrrrch! As a result of a secondary explosion,\nmuch of the ceiling has caved in.";
			array[4][3] = "W";
			array[4][4] = "W";
			array[4][5] = "W";
			array[4][6] = "W";
			array[4][7] = "W";
			array[4][8] = "W";
			array[4][9] = "W";
			array[4][10] = "W";
		}
		
		array[7][0] = "W";
		array[8][0] = "W";
		array[7][2] = "W";
		array[8][2] = "W";
		
		array[7][4] = "W";
		array[8][4] = "W";
		array[7][6] = "W";
		array[8][6] = "W";
		
		array[7][8] = "W";
		array[8][8] = "W";
		array[7][10] = "W";
		array[8][10] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class HallwayOneScene extends Scene {
	HallwayOneScene() {
		array = new String[9][11];
		storyInformation = "Emergency sirens blaring,\nyou continue down the hallway.";
		currentStoryInformation = storyInformation;

		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(8, 3, false, 0, 3, true, "cellScene"));
		doorList.add(new Door(4, 0, true, 4, 9, true, "armoryScene", "goldKey"));
		doorList.add(new Door(4, 10, false, 4, 1, true, "hallwayTwoScene"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[3][0] = "W";
		array[5][0] = "W";
		
		array[8][2] = "W";
		array[8][4] = "W";
		
		array[3][10] = "W";
		array[5][10] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class HallwayTwoScene extends Scene {
	HallwayTwoScene() {
		array = new String[9][11];
		//storyInformation = "";
		
		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(4, 0, false, 4, 9, true, "hallwayOneScene"));
		doorList.add(new Door(4, 10, false, 4, 0, true, "hallwayThreeScene"));
		doorList.add(new Door(0, 5, false, 8, 5, true, "keyRoomScene"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[3][0] = "W";
		array[5][0] = "W";
		
		array[3][10] = "W";
		array[5][10] = "W";
		
		array[0][4] = "W";
		array[0][6] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class KeyRoomScene extends Scene {
	KeyRoomScene() {	
		array = new String[9][11];
		storyInformation = "This appears to be a control room.\nYou find a dead body on the ground and spot the\nkey, although not before you realize the man in\nfront of you died of shrapnel through the brain.";
		currentStoryInformation = storyInformation;

		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(8, 5, false, 0, 5, true, "hallwayTwoScene"));
		keyList.add(new Key(3, 5, "goldKey"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[8][4] = "W";
		array[8][6] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class HallwayThreeScene extends Scene {
	HallwayThreeScene() {
		array = new String[9][11];
		storyInformation = "Except for stellar views of the planet below\nthis room contains nothing useful.";
		currentStoryInformation = storyInformation;

		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(4, 0, false, 4, 10, true, "hallwayTwoScene"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[3][0] = "W";
		array[5][0] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}

class ArmoryScene extends Scene {
	ArmoryScene() {
		array = new String[9][11];
		storyInformation = "This appears to be an armory.\nAssault weapons, protective gear and grenades,\nthis room has it all\n--if you have access code to anything that is.";
		currentStoryInformation = storyInformation;
		
		// Stuff we want to run only once when AllScenes object is created
		doorList.add(new Door(4, 10, false, 4, 0, true, "hallwayOneScene"));
		keyList.add(new Key(4, 5, "emeraldKey"));
		enemyList.add(new Enemy(4, 6, 0, 1, 1, "Up"));
		enemyList.add(new Enemy(5, 4, 0, 1, 1, "Up"));
	}

	public void placeEntities() {
		super.placeEntities();
		
		array[0][0] = "W";
		array[0][2] = "W";
		array[0][4] = "W";
		array[0][6] = "W";
		array[0][8] = "W";
		array[0][10] = "W";
		
		array[3][10] = "W";
		array[5][10] = "W";
		
		array[3][4] = "W";
		array[3][5] = "W";
		array[3][6] = "W";
		
		array[5][4] = "W";
		array[5][5] = "W";
		array[5][6] = "W";
		
		array[8][0] = "W";
		array[8][2] = "W";
		array[8][4] = "W";
		array[8][6] = "W";
		array[8][8] = "W";
		array[8][10] = "W";

		array[player.getPosUp()][player.getPosAcross()] = "P";
	}
}