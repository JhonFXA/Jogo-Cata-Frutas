package frutas;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Amora extends Fruta{

	public Amora(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/frutas/amora.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
