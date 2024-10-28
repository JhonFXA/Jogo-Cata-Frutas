package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import controle.KeyControlP1;
import main.ConfiguracaoJogo;

public class JogadorUm extends Competidor{

	public JogadorUm(int x, int y, ConfiguracaoJogo configuracao, String nome) {
		super(x, y, configuracao, nome);
		keyH = new KeyControlP1(this);
	}
	
	public void getImagem() {
		try {
			frente = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 front.png"));
			costa = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 back.png"));
			esquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 left.png"));
			direita = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 right.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
