
public class VendingMachine {

	private int snacksPerRow;
	private int rows;
	private Snack[][] snackList;
	private Snack selectedSnack;
	private double moneyInside;
	
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
		System.out.println("For example, put in \"A1\" to order " + snackList[0][0].getName());
	}
	
	// returns the contents of the vending machine in the format
	// "slot: name - $price"
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
	
	// method takes the slot input from the user and stores the corresponding Snack in the machine
	// slot will be the value of scan.nextLine()
	public void pickSnack(String slot) {
		// translates the slot to an array index
		int row = slot.charAt(0) - 'A';
		int col = slot.charAt(1) - '1';
		// check to see if slot was valid
		try {
			selectedSnack = snackList[row][col];
			System.out.println("You chose the " + selectedSnack.getName() + " for $" + selectedSnack.getPrice() + ".");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("That slot is invalid, please try running the program again and choosing a correct slot.");
			System.exit(0);
		}
	}
	
	public void insertMoney(int dollars)
	{
		moneyInside = dollars;
		System.out.println("You have inserted " + dollars + " dollars.");
	}
	
	// giving change in dollars and quarters back to the user
	public void giveChange() {
		double change = moneyInside - selectedSnack.getPrice();

		int dollarsChange = 0;
		int quartersChange = 0;
		
		// giving back any extra whole dollars
		while (change >= 1) {
			dollarsChange += 1;
			change -= 1;
		}
		
		// giving back any extra quarters
		while (change >= 0.25) {
			quartersChange += 1;
			change -= 0.25;
		}
		
		// checking for decimal precision issues
		if (Math.abs(change - 0.25) > 0.001) {
			quartersChange += 0.25;
		}
		
		System.out.println("Your change is $" + (moneyInside - selectedSnack.getPrice()) + " (" + dollarsChange + " dollar(s) and " + quartersChange + " quarter(s)).");
	}
}
