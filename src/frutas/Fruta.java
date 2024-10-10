package frutas;

import main.ConfiguracaoJogo;
import main.ElementoDinamico;

public abstract class Fruta extends ElementoDinamico{

	public Fruta(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
		getImagem();
	}

}
