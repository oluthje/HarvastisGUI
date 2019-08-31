import java.io.*;

public class SendToGUI {
	protected String scene;
	protected String sceneMessage;
	protected String sceneInfo;

	public void getCurrentSceneMessage() {
		
	}

	public void sendVariablesToGUI() {
		Harvastis game = new Harvastis();

		// gets current scene message
		switch (game.currentScene) {
			case "cellScene":
				sceneMessage = game.cellScene.storyInformation;
				break;
			case "hallwayOneScene":
				sceneMessage = game.hallwayOneScene.storyInformation;
				break;
			case "hallwayTwoScene":
				sceneMessage = game.hallwayTwoScene.storyInformation;
				break;
			case "armoryScene":
				sceneMessage = game.armoryScene.storyInformation;
				break;
			case "hallwayThreeScene":
				sceneMessage = game.hallwayThreeScene.storyInformation;
				break;
			case "keyRoomScene":
				sceneMessage = game.keyRoomScene.storyInformation;
				break;
			case "escapePodScene":
				sceneMessage = game.escapePodScene.storyInformation;
				break;
		}

		scene = game.cellScene.sceneToGUI;
		sceneInfo = game.cellScene.sceneInformation;

		saveVariablesToFile();
	}

	public void saveVariablesToFile() {
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("toPythonGUI.txt"));
			System.out.println("scene:" + scene + " sceneMessage:" + sceneMessage + " sceneInfo:" + sceneInfo);
			writer.write("scene:" + scene + "sceneMessage:" + sceneMessage + "\nsceneInfo:" + sceneInfo);
			writer.close();
		}catch(Exception e){System.out.println(e);}
	}
}

class RetrieveGUIInput {
	protected String playerInput;
	protected int fileVar;

	public void loadPlayerInputFromFile() {
		try {
			String file;
			BufferedReader reader = new BufferedReader(new FileReader("toJavaGame.txt"));
			while ((file = reader.readLine()) != null) {
				fileVar = file.charAt(0);
				playerInput = file.substring(1);
			}
			reader.close();
		}catch(Exception e){System.out.println(e);}
	}
}


