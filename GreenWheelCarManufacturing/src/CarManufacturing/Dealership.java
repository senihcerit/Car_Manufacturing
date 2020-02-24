package CarManufacturing;
import java.util.List;

public class Dealership {
	private String name;
	private String address;
	private List<Car> inventory; 
	
	
	public Dealership(String name, String address, List<Car> inventory) {
		super();
		this.name = name;
		this.address = address;
		this.inventory = inventory;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Car> getInventory() {
		return inventory;
	}
	public void setInventory(List<Car> inventory) {
		this.inventory = inventory;
	}
	
	public void AddCar(Car car) {
		inventory.add(car);
	} 
	String[] allCarNames = new String[] {
			"GreenWheelSportsCar", "SmallGreenMini", "MediumGreenSaloon", "GreenBus", 
			"GreenWheelX1", "GreenWheelX2", "GreenWheelX3", "GreenWheelX4", "GreenWheelX5",
			"GreenWheelX6", "GreenWheelX7", "GreenWheelX8", "GreenWheelX9", "GreenWheelX10"
	};
	int[] numberList = new int[14];
	String[] colourList = new String[14];
	
	
	public String stockString() {
		for(int j=0;j<colourList.length;j++) {
			colourList[j] = "";
		}
		
		for(int i = 0; i<inventory.size();i++) {
			for(int j=0; j< allCarNames.length;j++) {
				if(inventory.get(i).getName()==allCarNames[j]) {
					numberList[j]++;
					colourList[j]+= inventory.get(i).getColour() + " ";
				}
			}
		}
		selectionSortAllArrays();
		
		String stocks="";
		int k=0;
		while(numberList[k]!=0) {
			stocks+= numberList[k]+" "+ allCarNames[k] + " in " + colourList[k]+ "\n";
			k++;
		}
		return stocks;
		
	}
	 void selectionSortAllArrays() 
	    { 
	        int n = numberList.length; 
	  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int max_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (numberList[j] > numberList[max_idx]) 
	                    max_idx = j; 
	  
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = numberList[max_idx]; 
	            numberList[max_idx] = numberList[i]; 
	            numberList[i] = temp; 
	            
	            String temp2 = allCarNames[max_idx]; 
	            allCarNames[max_idx] = allCarNames[i]; 
	            allCarNames[i] = temp2;
	            
	            String temp3 = colourList[max_idx]; 
	            colourList[max_idx] = colourList[i]; 
	            colourList[i] = temp3;
	        } 
	    } 
	
	
	public String toStringWithStock() {
		return name + "'s GreenWheel Dealership of " + address + "\nPresents:\n"+
				stockString();
				
	}
	
	
}
