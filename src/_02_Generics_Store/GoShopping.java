package _02_Generics_Store;

import java.util.ArrayList;

public class GoShopping {
	// 1. Look through other classes to see how they all interact.
	//
	// There is a generic Cart class that can hold different
	// types of objects.
	//
	// Candy and Cereal are Food objects
	// Clothing and Toy are NonFood objects.

	public static void main(String[] args) {
		//ArrayList<Candy> oreos = new ArrayList<>();
		//ArrayList<Cereal> cheerios = new ArrayList<>();
		// 2. Create a Cart object of type Candy
		//Cart<Candy> cartCandy = new Cart<Candy>();
		// 3. Create another Cart object of type Cereal
		//Cart<Cereal> cartCereal = new Cart<Cereal>();
		// 4. Add a few items to EACH cart
		//for (int i = 0; i < 5; i++) {
			//oreos.add(new Candy());
			//cheerios.add(new Cereal());
		//}
		//for (int i = 0; i < 5; i++) {
			//cartCandy.add(oreos.get(i));
			//cartCereal.add(cheerios.get(i));
		//}

		// 5. Call the showCart() method on EACH cart
		//cartCandy.showCart();
		//cartCereal.showCart();
		// 6. Run the code
		
		// 7. Comment out the code you have so far
		
		// 8. Repeat steps 2-5 for a Clothing Cart and a Toy Cart
		Cart<Clothing> cartClothes = new Cart<Clothing>();
		Cart<Toy> cartToys = new Cart<Toy>();
		ArrayList<Clothing> shirts = new ArrayList<>();
		ArrayList<Toy> legos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			shirts.add(new Clothing());
			legos.add(new Toy());
			cartClothes.add(shirts.get(i));
			cartToys.add(legos.get(i));
		}
		cartClothes.showCart();
		cartToys.showCart();
		
		// Why are there errors?

		// 9. Modify the Cart class so that this code compiles
		// HINT: There are 3 lines of code to edit

		// 10. Run the code. Does it work?

	}
}
