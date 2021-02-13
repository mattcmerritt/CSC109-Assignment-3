
public class VendingMachine {

	private int snacksPerRow;
	private int rows;
	private Snack[][] snackList;
	
	public VendingMachine(int snacksPerRow, int rows, Snack[] inputSnacks) {
		this.snacksPerRow = snacksPerRow;
		this.rows = rows;
		
		// creating the grid of snacks offered
		snackList = new Snack[rows][snacksPerRow];
		
		// filling it in with the snacks from the top-left to the bottom-right
		for (int i = 0; i < inputSnacks.length; i++) {
			snackList[i / snacksPerRow][i % snacksPerRow] = inputSnacks[i];
		}		
		
		// startup instructions printed to console
		welcome();
	}
	
	// method outputs the welcome message and initial instructions
	public void welcome() {
		System.out.println("Hello, welcome to the vending machine.");
		System.out.println("The items inside are the following: ");
		System.out.println(this);
		
		System.out.println("To order an item, input the slot for that item.");
		System.out.println("For example, put in A1 to order " + snackList[0][0].getName());
	}
	
	// returns the contents of the vending machine in the format
	// "slot: name - $price
	public String toString() {
		String output = "";
		for (int row = 0; row < snackList.length; row++) {
			for (int col = 0; col < snackList[row].length; col++) {
				String slot = "" + (char) ('A' + row) + (col + 1); // gets the current slot name (i.e. A1)
				// adds the current slot, item name, and price to the output string
				output += slot + ": " + snackList[row][col].getName() + " - $" + snackList[row][col].getPrice() + "\n"; 
				
			}
		}
		return output;
	}
	
}