package herbert_coffee_shop;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		CoffeeGui coffeeGui = new CoffeeGui();
		coffeeGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		coffeeGui.setSize(1200,750);
		coffeeGui.setVisible(true);
		//coffeeGui.setResizable(false);
	}

}
