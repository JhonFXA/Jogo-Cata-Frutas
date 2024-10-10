package frutas;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Laranja extends Fruta{

	public Laranja(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/frutas/laranja.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
