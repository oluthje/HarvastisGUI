import java.io.*;

public class Test {
	public static void main(String[] args) throws Exception {
		File file = new File("pythonjava.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String output = "";
		String input;
		while ((input = br.readLine()) != null) {
			output = "Hello there, " + input + "!";
			//System.out.println(output);
		}
		br.close();

		//PrintWriter writer = new PrintWriter("pythonjava.txt");
		//writer.println(output);

		BufferedWriter writer = new BufferedWriter(new FileWriter("pythonjava.txt"));
		writer.write(output);
		writer.close();
	}
}