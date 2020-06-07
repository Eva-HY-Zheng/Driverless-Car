package car;

import car.conts.Command;
import car.conts.Orientation;
import car.entity.Car;
import car.entity.CarPark;
import car.exception.OutOfBoundaryException;

public class CarActionImpl implements CarAction {

	private CarPark carPark;
	
	public CarActionImpl (CarPark carPark) {
		this.carPark = carPark;
	}
	
	public Car move(Command command, Car car) throws OutOfBoundaryException{
		
		if (command.getTurnStep() > 0) {
			for (int t=0; t<command.getTurnStep(); t++) {
				turnClockwise(car);
			}
		}
		
		if (command.getMoveStep() > 0 ) {
			for (int i=0; i<command.getMoveStep(); i++) {
				moveForward(car);
			}
		}
		
		return car;
	}

	private void turnClockwise(Car car) {
		Orientation orientation = car.getOrientation();
		switch (orientation) {
			case EAST : car.setOrientation(Orientation.SOUTH); break;
			case SOUTH : car.setOrientation(Orientation.WEST); break;
			case WEST : car.setOrientation(Orientation.NORTH); break;
			case NORTH : car.setOrientation(Orientation.EAST); break;
		}
	}
	
	private void moveForward(Car car) throws OutOfBoundaryException{
		Orientation orientation = car.getOrientation();
		int x = car.getPositionX();
		int y = car.getPositionY();
		
		switch (orientation) {
			case EAST : x++; car.setPositionX(x); break;
			case SOUTH : y--; car.setPositionY(y); break;
			case WEST : x--; car.setPositionX(x); break;
			case NORTH : y++; car.setPositionY(y); break;
		}
		
		//Check boundaries
		if (x < 1 || y < 1 || x > carPark.getX() || y > carPark.getY()) {
			throw new OutOfBoundaryException(car,carPark);
		}
		
	}

}
