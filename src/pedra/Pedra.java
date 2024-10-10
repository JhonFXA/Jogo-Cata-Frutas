package pedra;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;
import main.ElementoEstatico;

public class Pedra extends ElementoEstatico{
	
	public Pedra(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
		getImagem();
	}
	
	public void getImagem() {
		try {
			imagem = ImageIO.read(getClass().getResourceAsStream("/pedra/pedra.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}