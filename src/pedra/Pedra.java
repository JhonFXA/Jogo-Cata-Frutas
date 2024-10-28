package pedra;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;
import main.ElementoEstatico;

public class Pedra extends ElementoEstatico{
	
	
	
	public Pedra(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		super(posicaoX, posicaoY, configuracao);
		getImagem();
	}
	
//	public void desenhar(Graphics2D g2) {
//		g2.drawImage(imagem, this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro, null);
////		g2.setColor(Color.GRAY);
////
////	    g2.fillRect(this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro);
////	    
////	    g2.setColor(Color.BLACK); 
////
////
////	    String texto = "Pedra";
////
////	    FontMetrics metrics = g2.getFontMetrics();
////	    int xTexto = this.getPosicaoX() + (tamanhoQuadro - metrics.stringWidth(texto)) / 2;
////	    int yTexto = this.getPosicaoY() + (tamanhoQuadro - metrics.getHeight()) / 2 + metrics.getAscent();
////
////	    g2.drawString(texto, xTexto, yTexto);
//	}
	
	public void getImagem() {
		try {
			imagem = ImageIO.read(getClass().getResourceAsStream("/pedra/pedra.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}