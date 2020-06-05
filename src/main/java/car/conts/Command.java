package car.conts;

public class Command {

	private boolean isTurn ;
	private int moveStep;
	
	public Command (boolean isTurn, int moveStep) {
		this.isTurn = isTurn;
		this.moveStep = moveStep;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public int getMoveStep() {
		return moveStep;
	}

	public void setMoveStep(int moveStep) {
		this.moveStep = moveStep;
	}
	
}
