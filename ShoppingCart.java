import java.util.Scanner;

public class ShoppingCart {

	static int totalItems;
	static String [] items;
	static double [] prices;
	static int [] quantity;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to my store.");
		totalItems = getNumberOfItems("How many items do you want to buy? ");
		items = new String[totalItems];
		prices = new double[totalItems];
		quantity = new int[totalItems];
		
		int count = 0;
		while (count < totalItems) {
			
			getItemDetails(count);
			count++;
			
		}
		
		displayCart();
	}
	
	private static void getItemDetails(int index) {
		items[index] = getItemName("What is the name of the item" + (index+1) + "? ");
		prices[index] = getItemPrice("What is the price of item" + (index+1) + "? $");
		quantity[index] = getItemQuantity("How many of item" + (index+1) + "? ");
	}
	
	private static void displayCart() {
		System.out.println("-------------------------------");
		System.out.println("Cart Details");
		System.out.println("-------------------------------");
		
		for (int i=0; i < totalItems; i++) {
			showLineItem(i);
		}
		
		System.out.println("-------------------------------");
		double subtotal = calculateSubtotal();
		double tax = subtotal * 10/100;
		double total = subtotal + tax;
				
		System.out.println("Subtotal: $" + subtotal);
		System.out.println("Sales tax @ 10% : " + tax);
		System.out.println("Total Cost: $" +total);
		System.out.println("Average Cost of All Items: $" + subtotal / getTotalItems());
		
	}
	
	public static double calculateSubtotal() {
		double total=0;
		
		for (int i=0; i < totalItems; i++) {
		total+= prices[i] * quantity [i];
		}
		return total;
	}
	
	private static void showLineItem(int index) {
		
		String quantityText = quantity[index] + "\t--\t"; //3 -- Pencils
		String itemText = items[index] + "      @      $"; //Pencils
		String priceText = prices[index] + " = $" + prices[index] * quantity[index];
		
		System.out.println(quantityText + itemText + priceText);
	}
	
	private static int getTotalItems() {
		int sum = 0;
		for (int item : quantity)
			sum += item;
		
		return sum;
	}
	
	private static double getItemPrice(String m) {
		System.out.print(m);
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	private static String getItemName(String m) {
		System.out.print(m);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static int getItemQuantity(String m) {
		System.out.print(m);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static int getNumberOfItems(String m) {
		System.out.print(m);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
}
