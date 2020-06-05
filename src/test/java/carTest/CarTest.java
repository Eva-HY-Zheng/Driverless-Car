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
	public void testTurnClockwise() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.NORTH);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(true,0), car);
		assertEqualsForCar(car,1,1,Orientation.EAST);
	}
	
	@Test
	public void testMoveForward1() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.NORTH);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(false,1), car);
		assertEqualsForCar(car,1,2,Orientation.NORTH);
	}
	
	@Test
	public void testMoveForward2() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.EAST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(false,1), car);
		assertEqualsForCar(car,2,1,Orientation.EAST);
	}
	
	@Test
	public void testMoveException() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.WEST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		OutOfBoundaryException exception = null;
		
		try {
			carActionImpl.move(new Command(false,1), car);
		}catch (OutOfBoundaryException ex) {
			exception = ex;
			System.out.println(ex);
		} 
		assertNotNull(exception);
	}
	
	@Test
	public void testMoveSteps() throws OutOfBoundaryException{
		Car car = new Car(1,1,Orientation.EAST);
		CarActionImpl carActionImpl = new CarActionImpl(carPark);
		car = carActionImpl.move(new Command(false,2), car);
		assertEqualsForCar(car,3,1,Orientation.EAST);
	}
	
	private void assertEqualsForCar(Car car, int x, int y, Orientation orientation) {
		assertEquals(orientation, car.getOrientation());
		assertEquals(x,car.getPositionX());
		assertEquals(y,car.getPositionY());
	}
}
