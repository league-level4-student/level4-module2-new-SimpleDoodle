package _06_Console_Store;

import java.util.Scanner;

import _02_Generics_Store.Cart;
import _02_Generics_Store.Clothing;
import _02_Generics_Store.Toy;

public class ConsoleStore {

	/*
	 * Write a program that simulates shopping in a store using the Scanner and the
	 * classes in Generics_Store.
	 * 
	 * Note: You may need to modify existing code in Generics Store and/or add
	 * additional items and pictures to fulfill all the requirements. You are also
	 * free to add any additional methods or classes in Console Store that might be
	 * helpful to you.
	 * 
	 * Requirements:
	 * 
	 * -Use Ternary operators in place of simple if/else statements and do-while
	 * loops instead of while loops where appropriate.
	 * 
	 * - There should be at least four unique items the user can buy. These can be
	 * food items, nonfood items or both.
	 * 
	 * - The user should have a stipend of money to spend and each item should have
	 * its own price.
	 * 
	 * -The user should have the ability to add items to their cart, remove items,
	 * view items or check out.
	 * 
	 * -The program should continue until the user chooses to check out.
	 * 
	 * -When the user checks out you should let them know if they do not have enough
	 * money to purchase all their items and offer to put items back.
	 * 
	 * -If the user successfully purchases the items you should remove the amount
	 * from their stipend, show them the pictures of what they bought and print out
	 * a receipt showing their name, the individual prices of the items and their
	 * total.
	 */
	static String checkOut;
	static boolean overflow = false;

	public static void main(String[] args) {
		int wallet = 740;
		Scanner purchaseTracker = new Scanner(System.in);
		Cart<Clothing> consoleCart = new Cart<Clothing>();
		Cart<Toy> games = new Cart<Toy>();
		System.out.println("What is your name?");
		String name = purchaseTracker.next().trim();
		int consolesBuy = 0;
		int gamesBuy = 0;
		System.out.println("You have $" + wallet);
		do {
			System.out.println(
					"An xbox and playstation are $500 each and zelda and mario kart are $60 each, what would you like to purchase?");
			purchaseTracker.nextLine();
			String purchase = purchaseTracker.nextLine();

			System.out.println("How many " + purchase + "s would you like to purchase?");
			int amount = purchaseTracker.nextInt();
			if (purchase.equalsIgnoreCase("xbox")) {
				wallet -= (amount * 500);
				consolesBuy += amount;
				for (int i = 0; i < amount; i++) {
					consoleCart.add(new Clothing("xbox.png"));
				}
			} else if (purchase.equalsIgnoreCase("playstation")) {
				wallet -= (amount * 500);
				consolesBuy += amount;
				for (int i = 0; i < amount; i++) {
					consoleCart.add(new Clothing("playstation.png"));
				}
			} else if (purchase.equalsIgnoreCase("zelda")) {
				wallet -= (amount * 60);
				gamesBuy += amount;
				for (int i = 0; i < amount; i++) {
					games.add(new Toy("TOTK.png"));
				}
			} else if (purchase.equalsIgnoreCase("mario kart")) {
				wallet -= (amount * 60);
				gamesBuy += amount;
				for (int i = 0; i < amount; i++) {
					games.add(new Toy("mariokart.jpg"));
				}
			}
			System.out.println("Would you like to view your cart? Y/N?");
			String checkItem = purchaseTracker.next();
			if (checkItem.equalsIgnoreCase("y")) {
				System.out.println("You have " + consolesBuy + " console(s)");
				System.out.println("You have " + gamesBuy + " game(s)");
				System.out.println("The total cost of these items is $" + (gamesBuy * 60 + consolesBuy * 500)
						+ ". Keep in mind that you have a total of $740");
			}
			if (consoleCart.length() > 0 || games.length() > 0 || overflow == true) {
				System.out.println("Would you like to remove an item from your cart? Y/N?");
				purchaseTracker.nextLine();
				String removeItem = purchaseTracker.nextLine();
				if (removeItem.equalsIgnoreCase("Y")) {
					System.out.println("Would you like to remove an xbox, playstation, zelda, or mario kart?");
					String removal = purchaseTracker.nextLine();
					System.out.println("How many " + removal + "s would you like to remove?");
					int removeAmount = purchaseTracker.nextInt();
					if (removal.equalsIgnoreCase("xbox")) {
						wallet += (removeAmount * 500);
						// for (int i = 0; i < removeAmount; i++) {
						consoleCart.remove(new Clothing("xbox.png"), removeAmount);
						consolesBuy -= removeAmount;
						// }
					} else if (removal.equalsIgnoreCase("playstation")) {
						wallet += (removeAmount * 500);
						// for (int i = 0; i < removeAmount; i++) {
						consoleCart.remove(new Clothing("playstation.png"), removeAmount);
						consolesBuy -= removeAmount;
						// }
					} else if (removal.equalsIgnoreCase("zelda")) {
						wallet += (removeAmount * 60);
						// for (int i = 0; i < removeAmount; i++) {
						games.remove(new Toy("TOTK.png"), removeAmount);
						gamesBuy -= removeAmount;
						// }
					} else if (removal.equalsIgnoreCase("mario kart")) {
						wallet += (removeAmount * 60);
						// for (int i = 0; i < removeAmount; i++) {
						games.remove(new Toy("mariokart.jpg"), removeAmount);
						gamesBuy -= removeAmount;
						// }
					}
				}
			}
			System.out.println("Would you like to check out? Y/N?");
			checkOut = purchaseTracker.next();
			if (wallet < 0 && checkOut.equalsIgnoreCase("Y")) {
				System.out.println("You don't have enough funds to purchase all items. Please remove some items.");
				overflow = true;
				checkOut = "N";
			}
			// checkOut = wallet < 0 ? "Y" : "N";
			// System.out.println(checkOut);

		} while (checkOut.equalsIgnoreCase("N"));
		purchaseTracker.close();
		System.out.println("You have $" + wallet + " remaining");
		consoleCart.showCart();
		games.showCart();
		System.out.println("Receipt for " + name);
		System.out.println(consolesBuy + " console(s)" + " $" + consolesBuy * 500);
		System.out.println(gamesBuy + " game(s)" + " $" + gamesBuy * 60);
		System.out.println("Total cost: $" + (consolesBuy * 500 + gamesBuy * 60));
	}

}
