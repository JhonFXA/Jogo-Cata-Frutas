package arvores;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Amoreira extends Arvore{

	public Amoreira(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
//	public void desenhar(Graphics2D g2) {
//		g2.setColor(Color.GREEN.darker());
//
//	    g2.fillRect(this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro);
//		g2.setColor(Color.BLACK); 
//
//
//	    String texto = "Amoreira";
//
//	    FontMetrics metrics = g2.getFontMetrics();
//	    int xTexto = this.getPosicaoX() + (tamanhoQuadro - metrics.stringWidth(texto)) / 2;
//	    int yTexto = this.getPosicaoY() + (tamanhoQuadro - metrics.getHeight()) / 2 + metrics.getAscent();
//
//	    g2.drawString(texto, xTexto, yTexto);
//	}
	public void getImagem() {
		try {
			imagem = ImageIO.read(getClass().getResourceAsStream("/arvores/amoreira.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
