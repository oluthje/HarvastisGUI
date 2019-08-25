public class Key {
	private int posUp;
	private int posAcross;
	private boolean collected;
	
	private String keyID;

	// Add variable to determine key type
	Key(int posUp, int posAcross, String keyID) {
		this.posUp = posUp;
		this.posAcross = posAcross;
		
		this.keyID = keyID;

		collected = false;
	}
	
	public String getKeyID() {
		return keyID;
	}

	public void makeCollected() {
		collected = true;
	}

	public boolean getIfCollected() {
		return collected;
	}

	public int getPosUp() {
		return posUp;
	}

	public int getPosAcross() {
		return posAcross;
	}
}
