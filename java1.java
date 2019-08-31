public class Java1 {
	public static void main(String[] args) {
		int mysteryNumber = 0;
		String[] mysteryArray = {"Finn", "Jake", "Bubblegum"};
		for(int i = 0; i < mysteryArray.length; i++)
		{
		    mysteryNumber += mysteryArray[i].length();
		}
		System.out.println("mysteryNumber: " + mysteryNumber);
	}
}