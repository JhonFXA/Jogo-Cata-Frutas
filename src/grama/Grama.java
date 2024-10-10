package grama;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;
import main.ElementoEstatico;

public class Grama extends ElementoEstatico{
	public BufferedImage imagens[];
	int tipoGrama[][];
	 
	int dimensao;
	int tamanhoQuadro;
    int terrenoOffsetX;
    int terrenoOffsetY;
	
	public Grama(int x, int y, ConfiguracaoJogo configuracao) {
		super(x, y, configuracao);
		
		this.dimensao = configuracao.getDimensao();
		this.tamanhoQuadro = configuracao.getTamanhoQuadro();
		this.terrenoOffsetX = configuracao.getTerrenoOffsetX();
	    this.terrenoOffsetY = configuracao.getTerrenoOffsetY();
	    imagens = new BufferedImage[4];
	    tipoGrama = new int[dimensao][dimensao];
	    inicializaTipoGrama();
		getImagem();
	}
	
	public void inicializaTipoGrama() {
		Random random = new Random();
		int numAleatorio;
		for(int i = 0; i < dimensao; i++) {
			for(int j = 0; j < dimensao; j++) {
				numAleatorio = random.nextInt(4);
				tipoGrama[i][j] = numAleatorio;
			}
		}
	}
	
	@Override
	public void getImagem() {
		try {
			imagens[0] = ImageIO.read(getClass().getResourceAsStream("/grama/grama.png"));
			imagens[1] = ImageIO.read(getClass().getResourceAsStream("/grama/grama2.png"));
			imagens[2] = ImageIO.read(getClass().getResourceAsStream("/grama/grama3.png"));
			imagens[3] = ImageIO.read(getClass().getResourceAsStream("/grama/grama4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void desenhar(Graphics2D g2) {

		for(int i = 0; i < dimensao; i++) {
			for(int j = 0; j < dimensao; j++) {
				g2.drawImage(imagens[tipoGrama[i][j]], terrenoOffsetX + tamanhoQuadro * i, terrenoOffsetY + tamanhoQuadro * j, tamanhoQuadro, tamanhoQuadro, null);
				
			}
			
		}
	}
}
