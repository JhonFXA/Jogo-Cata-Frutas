package entity;

import main.ElementoDinamico;
import main.KeyHandler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ConfiguracaoJogo;

public class Competidor extends ElementoDinamico {
	
    protected ConfiguracaoJogo configuracao;
    public KeyHandler keyH = new KeyHandler();

    private boolean upPressedLast = false;
    private boolean downPressedLast = false;
    private boolean leftPressedLast = false;
    private boolean rightPressedLast = false;
    
    int terrenoOffsetX;
    int terrenoOffsetY;
    int larguraTerreno;
    int alturaTerreno;
    int tamanhoQuadro;
    
    public BufferedImage frente, costa, esquerda, direita;
    public String direcao;
    
	public Competidor(int x, int y, ConfiguracaoJogo configuracao) {
		super(x,y, configuracao);
		this.configuracao = configuracao;
		this.terrenoOffsetX = configuracao.getTerrenoOffsetX();
	    this.terrenoOffsetY = configuracao.getTerrenoOffsetY();
	    this.larguraTerreno = configuracao.getLarguraTerreno();
	    this.alturaTerreno = configuracao.getAlturaTerreno();
	    this.tamanhoQuadro = configuracao.getTamanhoQuadro();
	    
	    this.getImagem();
	    this.direcao = "baixo";
	}
	
	public void getImagem() {
		try {
			frente = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 front.png"));
			costa = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 back.png"));
			esquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 left.png"));
			direita = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 right.png"));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void mover() {
		if (keyH.upPressed && !upPressedLast) {
            this.setPosicaoY(this.getPosicaoY() - tamanhoQuadro);
            upPressedLast = true;
            direcao = "cima";
        } else if (!keyH.upPressed) {
            upPressedLast = false;
        }

        if (keyH.downPressed && !downPressedLast) {
        	this.setPosicaoY(this.getPosicaoY() + tamanhoQuadro);
            downPressedLast = true;
            direcao = "baixo";
        } else if (!keyH.downPressed) {
            downPressedLast = false;
        }

        if (keyH.leftPressed && !leftPressedLast) {
        	this.setPosicaoX(this.getPosicaoX() - tamanhoQuadro);
            leftPressedLast = true;
            direcao = "esquerda";
        } else if (!keyH.leftPressed) {
            leftPressedLast = false;
        }

        if (keyH.rightPressed && !rightPressedLast) {
        	this.setPosicaoX(this.getPosicaoX() + tamanhoQuadro);
            rightPressedLast = true;
            direcao = "direita";
        } else if (!keyH.rightPressed) {
            rightPressedLast = false;
        }

       // Impedir o jogador de sair dos limites do terreno
        if (this.getPosicaoX() < terrenoOffsetX) 
        	this.setPosicaoX(terrenoOffsetX);
        if (this.getPosicaoY() < terrenoOffsetY)
        	this.setPosicaoY(terrenoOffsetY);
        if (this.getPosicaoX() > terrenoOffsetX + larguraTerreno - tamanhoQuadro)
        	this.setPosicaoX(terrenoOffsetX + larguraTerreno - tamanhoQuadro);
        if (this.getPosicaoY() > terrenoOffsetY + alturaTerreno - tamanhoQuadro)
        	this.setPosicaoY(terrenoOffsetY + alturaTerreno - tamanhoQuadro);
	}
	
	public void desenhar(Graphics2D g2) {
		
		BufferedImage imagem = null;
		
		switch(direcao) {
		case "cima":
			imagem = costa;
			break;
		case "baixo":
			imagem = frente;
			break;
		case "esquerda":
			imagem = esquerda;
			break;
		case "direita":
			imagem = direita;
			break;
		}
		
		g2.drawImage(imagem, this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro, null);
	}

}
