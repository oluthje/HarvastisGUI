public class Player {
	private int posUp;
	private int posAcross;
	
	private int goldKeyCount;
	private int emeraldKeyCount;

	public int getPosUp() {
		return posUp;
	}

	public int getPosAcross() {
		return posAcross;
	}

	public void setPosUp(int num) {
		posUp = posUp + num;
	}

	public void setPosAcross(int num) {
		posAcross = posAcross + num;
	}

	public void setPos(int posUp, int posAcross) {
		this.posUp = posUp;
		this.posAcross = posAcross;
	}
	
	public int getKeyCount(String keyType) {
		int key = 0;
		
		if (keyType.equals("goldKeyCount")) {
			key = goldKeyCount;
		} else if (keyType.equals("emeraldKeyCount")) {
			key = emeraldKeyCount;
		}
		
		return key;
	}
	
	public void addToKeyCount(int num, String keyType) {
		if (keyType.equals("goldKeyCount")) {
			goldKeyCount = goldKeyCount + num;
		} else if (keyType.equals("emeraldKeyCount")) {
			emeraldKeyCount = emeraldKeyCount + num;
		}
	}
}