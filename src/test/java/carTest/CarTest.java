package carTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import car.CarActionImpl;
import car.conts.Command;
import car.conts.Orientation;
import car.entity.Car;
import car.entity.CarPark;
import car.exception.OutOfBoundaryException;

public class CarTest {

	private CarPark carPark= new CarPark(4,4);
	
	@Test
	//Car in x=1,y=1,North; Turns Clockwise one step; 
	//Expected result: Car in x=1,y=1,East.
	public void testTurnClockwise() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.NORTH);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(1,0), car);
		assertEqualsForCar(car,1,1,Orientation.EAST);
	}
	
	@Test
	//Car in x=1,y=1,North; Moves forward one step; 
	//Expected result: Car in x=1,y=2,North.
	public void testMoveForward1() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.NORTH);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(0,1), car);
		assertEqualsForCar(car,1,2,Orientation.NORTH);
	}
	
	@Test
	//Car in x=1,y=1,East; Moves forward one step; 
	//Expected result: Car in x=2,y=1,East.
	public void testMoveForward2() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.EAST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(0,1), car);
		assertEqualsForCar(car,2,1,Orientation.EAST);
	}
	
	@Test
	//Car in x=1,y=1,West; Moves forward one step; 
	//Expected result: Car in x=0,y=1,East; throws exception.
	public void testMoveException() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.WEST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		OutOfBoundaryException exception = null;
		
		try {
			carActionImpl.move(new Command(0,1), car);
		}catch (OutOfBoundaryException ex) {
			exception = ex;
			System.out.println(ex);
		} 
		assertNotNull(exception);
	}
	
	@Test
	//Car in x=1,y=1,East; Moves forward two steps; 
	//Expected result: Car in x=3,y=1,East.
	public void testMoveSteps() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.EAST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(0,2), car);
		assertEqualsForCar(car,3,1,Orientation.EAST);
	}
	
	private void assertEqualsForCar(Car car, int x, int y, Orientation orientation) {
		assertEquals(orientation, car.getOrientation());
		assertEquals(x,car.getPositionX());
		assertEquals(y,car.getPositionY());
	}
}
