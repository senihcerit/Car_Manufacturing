package CarManufacturing;

public class Car {

	private String name;
	private int vinNumber;
	private String gearbox;
	private String transmission;
	private String engine;
	private int numberOfDoors;
	private int wheelSize;
	private String colour;
	private String oldOrNew; 
	private String[] donorCarInformations= new String[]{"gearbox","transmission","engine","numberofdoors","wheelsize"};;
	
		
	Car() {
		this.name = "";
		this.vinNumber = 0;
		this.gearbox = "NONE";
		this.transmission = "NONE";
		this.engine = "NONE";
		this.numberOfDoors = 0;
		this.wheelSize = 0;
		this.colour = "NONE";
		this.oldOrNew = "NONE";
		
	}
	Car(String name,int vinNumber,String colour,String oldOrNew) {
		this.name = name;
		this.vinNumber = vinNumber;
		this.gearbox = "NONE";
		this.transmission = "NONE";
		this.engine = "NONE";
		this.numberOfDoors = 0;
		this.wheelSize = 0;
		this.colour = colour;
		this.oldOrNew = oldOrNew;
		
	}

	public Car(String name, int vinNumber, String gearboxes,String transmission, String engine,int numberOfDoors, int wheelSize, String colour,String oldOrNew) {
		super();
		this.name = name;
		this.vinNumber = vinNumber;
		this.gearbox = gearboxes;
		this.transmission = transmission;
		this.engine = engine;
		this.numberOfDoors = numberOfDoors;
		this.wheelSize = wheelSize;
		this.colour = colour;
		this.oldOrNew = oldOrNew;
				
	}

		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public int getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(int vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearboxes(String gearbox) {
		this.gearbox = gearbox;
	}
	
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public int getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getOldOrNew() {
		return oldOrNew;
	}

	public void setOldOrNew(String oldOrNew) {
		this.oldOrNew = oldOrNew;
	}

	public String[] getDonorCarInformations() {
		return donorCarInformations;
	}
	public void setDonorCarInformations(String[] oldCarInformations) {
		this.donorCarInformations = oldCarInformations;
	}
	
	public void setDonorCarInformation(String value,int index) {
		donorCarInformations[index]= value;
	}
	public String getDonorCarInformation(int index) {
		return donorCarInformations[index];
	}
	public String getCarNameAndVin() {
		return "(" + name + "(vin:"+ vinNumber + "))";
	}
	public String toLine() {
		return name + "(vin : "+ vinNumber + ")";
	}
	public String toString() {
		return name + "(vin : "+ vinNumber + ")\n"+
				engine + ", " + gearbox + " " +transmission + "\n" +
				wheelSize + "Inch Alloy Wheels, " + numberOfDoors + " Doors, in " + colour ;
	}
	
	public String toStringWithDonor() {
		return name + "(vin : "+ vinNumber + ")\n"+
				engine + " " + donorCarInformations[2] + ",\n" +
				gearbox + donorCarInformations[0] + ", " +transmission + donorCarInformations[1] +  "\n" +
				wheelSize + " inch Alloy Wheels, "+ donorCarInformations[4] + numberOfDoors + " Doors"+ donorCarInformations[3] +", in " + colour ;
	}
	
}
