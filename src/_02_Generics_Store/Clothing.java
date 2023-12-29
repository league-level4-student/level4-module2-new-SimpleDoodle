package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Clothing extends NonFood{
	public Clothing() {
		if(new Random().nextBoolean()) {
			this.item = "playstation.png";
		}
		else {
			this.item = "xbox.png";
		}
	}
	public Clothing(String consoleType) {
		this.item = consoleType;
	}
	

	@Override
	public JLabel getNonFood() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
}
