package frutas;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Coco extends Fruta{

	public Coco(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/frutas/coco.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
