package CarManufacturing;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Remanufacturing {

	public static List<Car> listOfCarsToDistributed = new ArrayList<Car>();
	public static List<Integer> numbers = new ArrayList<Integer>();

	public static void ProduceNewCars(int n) {

		for (int i = 0; i < n; i++) {
			GreenWheelMainClass.listOfNewCars
					.add(new Car(generateCarName(), i + 1001, Generate.generateColour(), "NEW"));
			numbers.add(i);
		}
		DetermineCarsToBeDistributed(n);
		DivideAndDistribute();

	}

	public static void reFillNumbers() {
		numbers.clear();
		for (int i = 0; i < GreenWheelMainClass.listOfNewCars.size(); i++) {
			numbers.add(i);
		}
	}

	public static void DetermineCarsToBeDistributed(int n) {

		for (int i = 0; i < n; i++) {

			int randomNumber = new Random().nextInt(GreenWheelMainClass.listOfOldCars.size());

			listOfCarsToDistributed.add(GreenWheelMainClass.listOfOldCars.get(randomNumber));

			GreenWheelMainClass.listOfOldCars.remove(randomNumber);
		}

	}

	private static void DivideAndDistribute() {

		gearboxDistribute();
		transmissionDistribute();
		engineDistribute();
		doorDistribute();
		wheelDistribute();

	}

	public static void gearboxDistribute() {

		for (int j = 0; j < listOfCarsToDistributed.size(); j++) {

			GreenWheelMainClass.listOfNewCars.get(j).setGearboxes(listOfCarsToDistributed.get(j).getGearbox());
			GreenWheelMainClass.listOfNewCars.get(j)
					.setDonorCarInformation(listOfCarsToDistributed.get(j).getCarNameAndVin(), 0);
		}
	}

	public static void transmissionDistribute() {
		int randomNumber = 0;
		for (int j = 0; j < listOfCarsToDistributed.size(); j++) {

			randomNumber = new Random().nextInt(numbers.size());

			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber))
					.setTransmission(listOfCarsToDistributed.get(j).getTransmission());
			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber))
					.setDonorCarInformation(listOfCarsToDistributed.get(j).getCarNameAndVin(), 1);
			numbers.remove(randomNumber);
		}
	}

	public static void engineDistribute() {
		reFillNumbers();
		boolean toContinue = true;
		int randomNumber = 0;
		String[] donorInfos;
		int times;
		
		for (int j = 0; j < listOfCarsToDistributed.size(); j++) {
			
			toContinue = true;

			while (toContinue) {
				randomNumber = new Random().nextInt(numbers.size());

				donorInfos = GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).getDonorCarInformations();
				times = 0;
				for (int k = 0; k < 2; k++) {

					if (listOfCarsToDistributed.get(j).getCarNameAndVin() == donorInfos[k])
						times++;
				}

				if (times < 2)
					toContinue = false;

			}

			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).setEngine(listOfCarsToDistributed.get(j).getEngine());
			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber))
					.setDonorCarInformation(listOfCarsToDistributed.get(j).getCarNameAndVin(), 2);
			numbers.remove(randomNumber);
		}
	}

	public static void doorDistribute() {
		reFillNumbers();
		boolean toContinue = true;
		int randomNumber = 0;
		String[] donorInfos;
		int times;
		
		for (int j = 0; j < listOfCarsToDistributed.size(); j++) {
			
			toContinue = true;

			while (toContinue) {
				randomNumber = new Random().nextInt(numbers.size());

				donorInfos = GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).getDonorCarInformations();
				times = 0;
				for (int k = 0; k < 3; k++) {

					if (listOfCarsToDistributed.get(j).getCarNameAndVin() == donorInfos[k])
						times++;
				}

				if (times < 2)
					toContinue = false;

			}

			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).setNumberOfDoors(listOfCarsToDistributed.get(j).getNumberOfDoors());
			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber))
					.setDonorCarInformation(listOfCarsToDistributed.get(j).getCarNameAndVin(), 3);
			numbers.remove(randomNumber);
		}
	}

	public static void wheelDistribute() {

		reFillNumbers();
		boolean toContinue = true;
		int randomNumber = 0;
		String[] donorInfos;
		int times;
		
		for (int j = 0; j < listOfCarsToDistributed.size(); j++) {
			
			toContinue = true;

			while (toContinue) {
				randomNumber = new Random().nextInt(numbers.size());

				donorInfos = GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).getDonorCarInformations();
				times = 0;
				for (int k = 0; k < 4; k++) {

					if (listOfCarsToDistributed.get(j).getCarNameAndVin() == donorInfos[k])
						times++;
				}

				if (times < 2)
					toContinue = false;

			}

			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber)).setWheelSize(listOfCarsToDistributed.get(j).getWheelSize());
			GreenWheelMainClass.listOfNewCars.get(numbers.get(randomNumber))
					.setDonorCarInformation(listOfCarsToDistributed.get(j).getCarNameAndVin(), 4);
			numbers.remove(randomNumber);
		}
	}

	private static String generateCarName() {
		String[] names = { "GreenWheelSportsCar", "SmallGreenMini", "MediumGreenSaloon", "GreenBus" };
		return names[new Random().nextInt(names.length)];
	}
}
