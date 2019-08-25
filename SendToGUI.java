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
		
		/*
		try{
			FileWriter fw=new FileWriter("toPythonGUI.txt");
			fw.write("Welcome to javaTpoint.");
			fw.close();
		}catch(Exception e){System.out.println(e);}
		*/
	}
}

class RetrieveGUIInput {
	protected String playerInput;
	/*
	retrieve from playerinput file the player input(WASD or enter)
	*/
	public void checkIfRecievedNewInput() {
		/*
		Have a variable in toJavaGame.txt that changes from 0 to 1 or 1 to 0
		every time there is new information. 

		while 
		*/
	}
}