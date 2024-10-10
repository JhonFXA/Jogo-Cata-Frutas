package frutas;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Goiaba extends Fruta{

	public Goiaba(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			this.imagem = ImageIO.read(getClass().getResourceAsStream("/frutas/goiaba.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
