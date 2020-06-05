package car;

import car.conts.Command;
import car.entity.Car;
import car.exception.OutOfBoundaryException;

public interface CarAction {

	public Car move(Command command, Car car) throws OutOfBoundaryException;
	
}
