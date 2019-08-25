public class Enemy {
	private int posUp;
	private int posAcross;

	private int num;

	private int leftMove;
	private int rightMove;
	private String movementAxis;

	Enemy(int posUp, int posAcross, int objNum, int inputLeftMove, int inputRightMove, String movementAxis) {
		setPosUp(posUp);
		setPosAcross(posAcross);

		num = objNum;

		leftMove = inputLeftMove;
		rightMove = inputRightMove;

		this.movementAxis = movementAxis;
	}

	public void printEnemy() {

	}

	public void moveOnPath() {
		if (movementAxis.equals("Up")) {
			if (leftMove > 0) {
				leftMove--;
				posUp--;
				if (rightMove == 0) {
					rightMove = 1;
				}
			} else if (rightMove > 0) {
				rightMove--;
				posUp++;
				if (leftMove == 0) {
					leftMove = 1;
				}
			}
		} else if (movementAxis.equals("Across")) {
			if (leftMove > 0) {
				leftMove--;
				posAcross--;
				if (rightMove == 0) {
					rightMove = 1;
				}
			} else if (rightMove > 0) {
				rightMove--;
				posAcross++;
				if (leftMove == 0) {
					leftMove = 1;
				}
			}
		}
	}

	public int getNum() {
		return num;
	}

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
}
