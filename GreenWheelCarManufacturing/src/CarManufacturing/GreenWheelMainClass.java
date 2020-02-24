package CarManufacturing;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreenWheelMainClass {

	public static List<Dealership> listOfDealerships;
	public static List<Car> listOfOldCars;
	public static List<Car> listOfNewCars;

	public static void main(String[] args) {
		listOfDealerships = Generate.Dealership(50);
		listOfOldCars = Generate.Car(1000, "OLD");
		listOfNewCars = new ArrayList<>();
		
		Remanufacturing.ProduceNewCars(500);

		DistributeToDealerships();

		Menu m= new Menu();
		m.show();
	}

	public static void DistributeToDealerships() {

		int randomNumber;
		List<Car> oldCars = copyList(listOfOldCars);
		List<Car> newCars = copyList(listOfNewCars);
		for (int i = 0; i < listOfDealerships.size(); i++) {

			for (int j = 0; j < 10; j++) {

				randomNumber = new Random().nextInt(oldCars.size());
				listOfDealerships.get(i).AddCar(oldCars.get(randomNumber));
				oldCars.remove(randomNumber);

			}
			for (int k = 0; k < 10; k++) {

				randomNumber = new Random().nextInt(newCars.size());
				listOfDealerships.get(i).AddCar(newCars.get(randomNumber));
				newCars.remove(randomNumber);
			}

		}

	}

	public static List<Car> copyList(List<Car> oldList){
		List<Car> newList = new ArrayList<Car>();
		for(int i=0;i<oldList.size();i++) {
			newList.add(oldList.get(i));
		}
		return newList;
 	}
}
