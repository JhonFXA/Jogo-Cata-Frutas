package arvores;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Goiabeira extends Arvore{

	public Goiabeira(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/arvores/goiabeira.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
