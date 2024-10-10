package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Elemento {
	private int posicaoX;
	private int posicaoY;

	private ConfiguracaoJogo configuracao;
	protected int tamanhoQuadro;
	protected BufferedImage imagem;
	
	public Elemento(int posicaoX, int posicaoY, ConfiguracaoJogo configuracao) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.configuracao = configuracao;
		this.tamanhoQuadro = configuracao.getTamanhoQuadro();
	}
	
	public void desenhar(Graphics2D g2) {
		g2.drawImage(imagem, this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro, null);
	}
	
	public abstract void getImagem();
	
	public int getPosicaoX() {
		return posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
}
