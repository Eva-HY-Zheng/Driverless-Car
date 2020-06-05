package car.entity;

import car.conts.Orientation;

public class Car {
	
	private int positionX;
	private int positionY;
	private Orientation orientation;
	
	public Car () {
		
	}
	
	public Car (int x, int y, Orientation orientation) {
		this.positionX = x;
		this.positionY = y;
		this.orientation = orientation;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
