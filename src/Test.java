import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Snack chips = new Snack("Potato Chips", 1.0);
		Snack doritos = new Snack("Doritos", 5.0);
		Snack oreos = new Snack("Oreos", 1.5);
		Snack water = new Snack("Water", 1.0);
		Snack mountainDew = new Snack("Mountain Dew", 0.50);
		Snack gatorade = new Snack("Gatorade", 3.0);
		
		VendingMachine machine = new VendingMachine(2, 3, new Snack[] {chips, doritos, oreos, water, mountainDew, gatorade});
		machine.pickSnack(scan.nextLine());
		System.out.println("Please enter the amount of dollars you would like to insert.");
		machine.insertMoney(scan.nextInt());
		scan.nextLine();
		machine.promptConfirmPurchase();
		machine.confirmPurchase(scan.nextLine());
	}
}
