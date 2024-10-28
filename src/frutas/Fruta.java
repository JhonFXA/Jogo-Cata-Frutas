package frutas;

import java.util.Random;

import main.ConfiguracaoJogo;
import main.ElementoDinamico;

public abstract class Fruta extends ElementoDinamico{
	
	private boolean bichada;

	public Fruta(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
		getImagem();
		bichada = definirBichada(configuracao.getChanceBichada());
	}

	public boolean isBichada() {
		return bichada;
	}

	private boolean definirBichada(double chanceBichada) {
		Random random = new Random();
		double numAleatorio = random.nextDouble() * 100;
		
		return numAleatorio < chanceBichada;
	}

}
