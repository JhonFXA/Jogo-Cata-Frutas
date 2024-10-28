package frutas;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Abacate extends Fruta{

	public Abacate(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
	}
	
	public void getImagem() {
		try {
			imagem = ImageIO.read(getClass().getResourceAsStream("/frutas/abacate.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void desenhar(Graphics2D g2) {
//		g2.setColor(Color.RED);
//
//	    g2.fillRect(this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro);
//		g2.setColor(Color.BLACK); 
//
//
//	    String texto = "Abacate";
//
//	    FontMetrics metrics = g2.getFontMetrics();
//	    int xTexto = this.getPosicaoX() + (tamanhoQuadro - metrics.stringWidth(texto)) / 2;
//	    int yTexto = this.getPosicaoY() + (tamanhoQuadro - metrics.getHeight()) / 2 + metrics.getAscent();
//
//	    g2.drawString(texto, xTexto, yTexto);
//	}
	

}
