package main;


import javax.swing.JFrame;

public class Principal {
	public static void main(String args[]) {
		JFrame window = new JFrame("Criador de Terreno");
		window.setSize(1280, 720);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		Menu menu = new Menu();
		window.add(menu);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
