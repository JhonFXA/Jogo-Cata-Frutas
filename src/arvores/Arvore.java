package arvores;

import main.ConfiguracaoJogo;
import main.ElementoEstatico;

public abstract class Arvore extends ElementoEstatico {
	public Arvore(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
		getImagem();
	}
}
