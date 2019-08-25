public class Door {
	private int posUp;
	private int posAcross;

	private int setPlayerPosUp;
	private int setPlayerPosAcross;

	private boolean requiresKey;
	private boolean hasExit;
	private String exit;
	private String keyID;

	Door(int posUp, int posAcross, boolean requiresKey, boolean hasExit) {
		this.posUp = posUp;
		this.posAcross = posAcross;

		this.requiresKey = requiresKey;
		this.hasExit = hasExit;
	}

	Door(int posUp, int posAcross, boolean requiresKey, int setPlayerPosUp, int setPlayerPosAcross, boolean hasExit, String exit) {
		this.posUp = posUp;
		this.posAcross = posAcross;

		this.setPlayerPosUp = setPlayerPosUp;
		this.setPlayerPosAcross = setPlayerPosAcross;

		this.requiresKey = requiresKey;
		this.hasExit = hasExit;
		this.exit = exit;
	}
	
	Door(int posUp, int posAcross, boolean requiresKey, int setPlayerPosUp, int setPlayerPosAcross, boolean hasExit, String exit, String keyID) {
		this.posUp = posUp;
		this.posAcross = posAcross;

		this.setPlayerPosUp = setPlayerPosUp;
		this.setPlayerPosAcross = setPlayerPosAcross;

		this.requiresKey = requiresKey;
		this.hasExit = hasExit;
		this.exit = exit;
		
		this.keyID = keyID;
	}
	
	public String getKeyID() {
		return keyID;
	}

	public int getSetPlayerPosUp() {
		return setPlayerPosUp;
	}

	public int getSetPlayerPosAcross() {
		return setPlayerPosAcross;
	}

	public int getPosUp() {
		return posUp;
	}

	public int getPosAcross() {
		return posAcross;
	}

	public boolean getIfRequiresKey() {
		return requiresKey;
	}
	
	public void unlockDoor() {
		requiresKey = false;
	}

	public boolean getIfHasExit() {
		return hasExit;
	}

	public String getExit() {
		return exit;
	}
}