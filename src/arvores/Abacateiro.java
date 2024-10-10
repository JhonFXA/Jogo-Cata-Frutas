package arvores;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Abacateiro extends Arvore{

	public Abacateiro(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/arvores/abacateiro.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
