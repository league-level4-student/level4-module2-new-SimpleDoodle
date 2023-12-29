package _02_Generics_Store;

import java.util.Random;

import javax.swing.JLabel;

public class Toy extends NonFood {
	public Toy() {
		if(new Random().nextBoolean()) {
			this.item = "TOTK.png";
		}
		else {
			this.item = "mariokart.jpg";
		}
	}
	public Toy(String gameType) {
		this.item = gameType;
	}

	@Override
	public JLabel getNonFood() {
		// TODO Auto-generated method stub
		return new JLabel(loadImage(this.item));
	}
}
