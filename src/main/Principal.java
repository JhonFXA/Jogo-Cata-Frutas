package main;

import javax.swing.JFrame;

public class Principal {
	public static void main(String args[]) {
		JFrame window = new JFrame("Criador de Terreno");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		CriadorDeTerreno criador = new CriadorDeTerreno();
		window.add(criador);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
