package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import controle.KeyControlP2;
import main.ConfiguracaoJogo;

public class JogadorDois extends Competidor {

	public JogadorDois(int x, int y, ConfiguracaoJogo configuracao, String nome) {
		super(x, y, configuracao, nome);
		keyH = new KeyControlP2(this);
		this.setPodeMover(false);
	}
	
	public void getImagem() {
		try {
			frente = ImageIO.read(getClass().getResourceAsStream("/jogador/p2 front.png"));
			costa = ImageIO.read(getClass().getResourceAsStream("/jogador/p2 back.png"));
			esquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/p2 left.png"));
			direita = ImageIO.read(getClass().getResourceAsStream("/jogador/p2 right.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
