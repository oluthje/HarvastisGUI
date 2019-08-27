import java.io.*;

public class SendToGUI {
	protected String scene;
	protected String sceneMessage;
	protected String sceneInfo;

	public void sendVariablesToGUI() {
		Harvastis game = new Harvastis();
		scene = game.cellScene.sceneToGUI;
		sceneMessage = game.cellScene.currentStoryInformation;
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


