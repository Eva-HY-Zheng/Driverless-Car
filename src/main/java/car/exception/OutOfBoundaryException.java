package car.exception;

import car.entity.Car;
import car.entity.CarPark;

public class OutOfBoundaryException extends Exception{

	public OutOfBoundaryException() {
		
	}
	
	public OutOfBoundaryException (Car car, CarPark carPark) {
		super("The Car ( "+car.getPositionX()+" / "+car.getPositionY()
			+" ) is out of the Car Park ( 1 ~ "+carPark.getX()
			+" / 1 ~ "+carPark.getY()+" )");
	}
}
