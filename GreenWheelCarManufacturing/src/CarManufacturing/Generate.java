package CarManufacturing;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generate {

	public static List<Dealership> Dealership(int n) {
		List<Dealership> listOfDealership = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			listOfDealership.add(generateDealership());
		}
		return listOfDealership;
				
	}
	
	public static List<Car> Car(int n,String oldOrNew) {
		List<Car> listOfCar = new ArrayList<>();
		for(int i=0; i<n; i++) {
			listOfCar.add(generateCar(i+1,oldOrNew));
		}
		return listOfCar;
	}
	
	private static Dealership generateDealership() {
                
        List<Car> stock = new ArrayList<Car>();
               
        return new Dealership(generateDealershipName(),generateDealershipAdress(),stock);
    }
	
	private static String generateDealershipName() {
		String[] names = {"Mylo", "Lowe", "Ralph", "Harrison", "Edwin", "Richards", "Reuben", "Duncan",
        				"Eden", "Lee", "Nathaniel", "Spencer", "Mateo", "Clark", "Christopher", "Young",
        				"Bentley", "Dixon", "Lachlan", "Hawkins", "Walkthrough", "Poem", "Joe", "Marshall",
        				"Noah", "Atiba", "Armstrong", "Montgomery", "Jones", "Jeremiah", "Henderson", "Ethan",
        				"Kennedy", "Powell", "Hugo", "King", "Bennett", "Khalid", "Riri", "Maryam",
        				"Isobel", "Martha", "Amelia", "Aliza", "Newman", "Lacey", "Flora", "Ronaldo",
        				"Emilia", "Lana", "Edith", "Natalia", "Alba", "Ryan", "Reid", "Nzonzi",
        				"Davidson", "Aliza", "Webb", "Leigh", "Flora", "Ted", "Marshall", "Tia",
        				"Iris", "Alexandra", "Mel", "Skyler", "Flora", "Barney","Robin", "Andreas",
        				"Anaya", "Murray", "Marley", "Jenkins", "Flora", "Micheal","Scherbatsky", "Marcelo",
        				"Nina", "Lucia", "Gale", "Atkinson", "Morgan", "Riley","Flora", "Mary",
        				"Phillips", "Gardner", "Marley", "Aaren", "River", "Richard","Flora", "Stella", };
		
		return names[new Random().nextInt(names.length)] + "'s GreenWheel Dealership";
	}
	
	private static String generateDealershipAdress() {
		
		String[] roads = {"Ironmonger Lane","King Edward","King","King William","King's Bench Walk","Knightrider","Lawrence Lane","Leadenhall", 
        		"Lime", "Little Britain","Lombard","London Wall","Long Lane","Lothbury","Ludgate Circus","Ludgate Hill","Mansion House ",
        		"123","124","125","126","130","131","132","133","134", "135","136","147","138","139","140","141","142",
        		"Mark Lane","Milk","Mincing Lane","Minories","Monkwell Square","Moorgate","Newgate","Norton Folgate","Oat Lane",
        		"Old Broad ","Old Jewry","Paternoster Row","Pepys","Philpot Lane","Pleydell","Poultry","Pudding Lane","Puddle Dock",
        		"Queen", "Queen Victoria","Queenhithe","Russia Row","St. Martin's Le Grand","Savage Gardens","Silk" ,"Snow Hill","St Mary Axe"};
        
        String[] streets= { "Aldersgate","Aldgate","Amen Corner","America Square","Angel","Ave Maria Lane","Bartholomew Lane",
        		"Beech","Beer Lane","Bevis Marks","Bishopsgate","Bleeding Heart Yard","Bouverie","Bread","Bull and Mouth",
        		"Byward","Camomile","Cannon", "Chancery Lane","Charterhouse ","Cheapside","Chiswell ","City ","Cloth Fair",
        		"Cock Lane","Coleman","Cornhill","Cripplegate","Cripplegate","Crosswall","Devereux Court","Eastcheap","Exchange Alley",
        		"Fann", "Fen Court","Fenchurch","Fetter Lane","Finsbury Pavement","Fleet","Fore","Foster Lane","Friday","Giltspur", 
        		"Golden Lane","Gracechurch","Great Tower ","Gresham","Gropecunt Lane","Grub","High Holborn","Holborn Viaduct","Houndsditch" };
        
        String[] states= { "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia", 
        	    "Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts",
        	    "Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey",
        	    "New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island",
        	    "South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming" };
             
        
    	return roads[new Random().nextInt(roads.length)] +" road, "+  streets[new Random().nextInt(streets.length)]+ " street, " + 
    			states[new Random().nextInt(states.length)];
	}
			
	private static Car generateCar(int i,String oldOrNew) {
		
		return new Car(generateCarName(),i,generateGearboxes(),generateTransmission(),
											generateEngine(),generateNumberOfDoors(),generateWheelSizes(),generateColour(),oldOrNew);
	}
		
	private static String generateCarName() {
		String[] names = {"GreenWheelX1", "GreenWheelX2", "GreenWheelX3", "GreenWheelX4", "GreenWheelX5",
						"GreenWheelX6", "GreenWheelX7", "GreenWheelX8", "GreenWheelX9", "GreenWheelX10"};
		return names[new Random().nextInt(names.length)];
	}
	
	private static String generateGearboxes() {
		int[] gearboxes = { 5, 6, 8 };
		return gearboxes[new Random().nextInt(gearboxes.length)] +" Speed";
	}
	
	private static String generateTransmission() {
		
		String[] transmissions = { "Automatic","Manual"};
		return  transmissions[new Random().nextInt(transmissions.length)]+ " Transmission" ;
	}
	
	private static String generateEngine() {
		String engineType,engineSize;
		
		String[] engineTypes = {"Diesel","Petrol","Electric"};
		int number = new Random().nextInt(engineTypes.length);
		engineType= engineTypes[number];
		
		int scale = (int) Math.pow(10, 1);
	    double dieselOrPetrolSize=(double) Math.round((new Random().nextDouble()*(4.0-1.0)+1.0) * scale) / scale;
	    
	    
		if(number == 2) {
			
			engineSize = " "+((new Random().nextInt((34-5)+1)+5)*10) + " HP";
			//engineSize:50 hp to 340 hp (electric)
		}
		else {
			engineSize = " "+ dieselOrPetrolSize;
		}
		
		
		return engineType + engineSize;
		
	}
		
	private static int generateNumberOfDoors() {
		int[] numberOfDoors = {2,3,4,5};
		return numberOfDoors[new Random().nextInt(numberOfDoors.length)];
	}
	
	private static int generateWheelSizes() {
		int[] wheelSizes = {16,17,18,19,20};
		return wheelSizes[new Random().nextInt(wheelSizes.length)];
	}
	
	public static String generateColour() {
		String[] colours = {"Yellow", "Green", "Red", "Blue", "Pink","White", "Gray", "Black", "Gold", "Brown",
							"Cherry Red", "sky Blue", "Autumn Orange", "Sunset Yellow", "Midnight Blue", "Panther Black"};
		return colours[new Random().nextInt(colours.length)];
	}
		
}
