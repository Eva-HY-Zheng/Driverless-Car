package car.conts;

public class Command {

	private int turnStep ;
	private int moveStep;
	
	public Command (int turnStep, int moveStep) {
		this.turnStep = turnStep;
		this.moveStep = moveStep;
	}

	public int getTurnStep() {
		return turnStep;
	}

	public void setTurnStep(int turnStep) {
		this.turnStep = turnStep;
	}

	public int getMoveStep() {
		return moveStep;
	}

	public void setMoveStep(int moveStep) {
		this.moveStep = moveStep;
	}
	
}
