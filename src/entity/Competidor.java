package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import controle.KeyHandler;
import frutas.*;
import main.ConfiguracaoJogo;
import main.ElementoDinamico;
import main.Mochila;
import pedra.Pedra;

public abstract class Competidor extends ElementoDinamico {
	public KeyHandler keyH;
    protected ConfiguracaoJogo configuracao;

    private boolean upPressedLast = false;
    private boolean downPressedLast = false;
    private boolean leftPressedLast = false;
    private boolean rightPressedLast = false;
    
    int terrenoOffsetX;
    int terrenoOffsetY;
    int larguraTerreno;
    int alturaTerreno;
    int tamanhoQuadro;
    
    public String nome;
    private int pontos;
    private int forcaDeAtaque;
    private int forcaDeDefesa;
    private boolean podeMover;
    protected boolean envenenado;
    
    

	public BufferedImage frente, costa, esquerda, direita;
    public String direcao;
    
    public Mochila mochila;
    
	public Competidor(int x, int y, ConfiguracaoJogo configuracao, String nome) {
		super(x,y, configuracao);
		this.configuracao = configuracao;
		this.terrenoOffsetX = configuracao.getTerrenoOffsetX();
	    this.terrenoOffsetY = configuracao.getTerrenoOffsetY();
	    this.larguraTerreno = configuracao.getLarguraTerreno();
	    this.alturaTerreno = configuracao.getAlturaTerreno();
	    this.tamanhoQuadro = configuracao.getTamanhoQuadro();
	    
	    girarDados();
	    forcaDeAtaque = 0;
	    forcaDeDefesa = 0;
	    podeMover = true;
	    
	    this.direcao = "baixo";
	    this.nome = nome;
	    mochila = new Mochila(configuracao.getCapacidadeMochila());
	    getImagem();
	}
	
	public abstract void getImagem();
	
	public void girarDados() {
		Random random = new Random();
		int dadoUm = random.nextInt(6) + 1;
		int dadoDois = random.nextInt(6) + 1;
		pontos = dadoUm + dadoDois;
		
	}
	
	
	public void mover(String direcao) {
		switch(direcao) {
		
		case "cima":
			upPressedLast = true;
			this.setPosicaoY(this.getPosicaoY() - tamanhoQuadro);
			this.direcao = "cima";
			if(this.getPosicaoY() >= terrenoOffsetY)
				pontos--;
			break;
			
		case "baixo":
			downPressedLast = true;
			this.setPosicaoY(this.getPosicaoY() + tamanhoQuadro);
			this.direcao = "baixo";
			if(this.getPosicaoY() <= terrenoOffsetY + alturaTerreno - tamanhoQuadro)
				pontos--;
			break;
			
		case "esquerda":
			leftPressedLast = true;
			this.setPosicaoX(this.getPosicaoX() - tamanhoQuadro);
			this.direcao = "esquerda";
			if(this.getPosicaoX() >= terrenoOffsetX)
				pontos--;
			break;
			
		case "direita":
			rightPressedLast = true;
			this.setPosicaoX(this.getPosicaoX() + tamanhoQuadro);
			this.direcao = "direita";
			if(this.getPosicaoX() <= terrenoOffsetX + larguraTerreno - tamanhoQuadro)
				pontos--;
			break;
		}
	}
	
	public void pularPedra(String direcao) {
		if(pontos>=3) {
			pontos -= 2;
			switch (direcao) {
			case "cima":
				this.setPosicaoY(this.getPosicaoY() - tamanhoQuadro);
				break;
			case "baixo":
				this.setPosicaoY(this.getPosicaoY() + tamanhoQuadro);
				break;
			case "esquerda":
				this.setPosicaoX(this.getPosicaoX() - tamanhoQuadro);
				break;
			case "direita":
				this.setPosicaoX(this.getPosicaoX() + tamanhoQuadro);
				break;
			}			
		}
	}

	
	public void verificarMovimento() {
		if (keyH.upPressed && !upPressedLast && pontos > 0 && podeMover) {
			
			//Se não houver pedra
			if(!verificarPedra(this.getPosicaoX(), this.getPosicaoY() - tamanhoQuadro)) {
				mover("cima");				
			} else {
				//Se a pedra nao estiver numa quina
				if(this.getPosicaoY() - tamanhoQuadro*2 >= terrenoOffsetY) {
					//Se nao houver pedra atrás de pedra
					if(!verificarPedra(this.getPosicaoX(), this.getPosicaoY() - tamanhoQuadro*2))
						pularPedra("cima");
				}
			}
            
        } else if (!keyH.upPressed) {
            upPressedLast = false;
        }

        if (keyH.downPressed && !downPressedLast && pontos > 0 && podeMover) {
        	
        	//Se não houver pedra
        	if(!verificarPedra(this.getPosicaoX(), this.getPosicaoY() + tamanhoQuadro)) {
				mover("baixo");				
			} else {
				//Se a pedra nao estiver numa quina
				if(this.getPosicaoY() + tamanhoQuadro*2 <= terrenoOffsetY  + alturaTerreno - tamanhoQuadro) {
					//Se nao houver pedra atrás de pedra
					if(!verificarPedra(this.getPosicaoX(), this.getPosicaoY() + tamanhoQuadro*2))
						pularPedra("baixo");
				}
			}
	
        } else if (!keyH.downPressed) {
            downPressedLast = false;
        }

        if (keyH.leftPressed && !leftPressedLast && pontos > 0 && podeMover) {
        	
        	//Se não houver pedra
        	if(!verificarPedra(this.getPosicaoX() - tamanhoQuadro, this.getPosicaoY())) {
				mover("esquerda");				
			} else {
				//Se a pedra nao estiver numa quina
				if(this.getPosicaoX() - tamanhoQuadro*2 >= terrenoOffsetX) {
					//Se nao houver pedra atrás de pedra
					if(!verificarPedra(this.getPosicaoX() - tamanhoQuadro*2, this.getPosicaoY()))
						pularPedra("esquerda");
				}
			}
		
        } else if (!keyH.leftPressed) {
            leftPressedLast = false;
        }

        if (keyH.rightPressed && !rightPressedLast && pontos > 0 && podeMover) {
           	//Se não houver pedra
        	if(!verificarPedra(this.getPosicaoX()  + tamanhoQuadro, this.getPosicaoY())) {
				mover("direita");				
			} else {
				//Se a pedra nao estiver numa quina
				if(this.getPosicaoX() + tamanhoQuadro*2 <= terrenoOffsetX  + alturaTerreno - tamanhoQuadro) {
					//Se nao houver pedra atrás de pedra
					if(!verificarPedra(this.getPosicaoX() + tamanhoQuadro*2, this.getPosicaoY()))
						pularPedra("direita");
				}
			}
			
        } else if (!keyH.rightPressed) {
            rightPressedLast = false;
        }
        
        coletarFruta(this.getPosicaoX(), this.getPosicaoY());

        //Impedir o jogador de sair dos limites do terreno
        if (this.getPosicaoX() < terrenoOffsetX) 
        	this.setPosicaoX(terrenoOffsetX);
        if (this.getPosicaoY() < terrenoOffsetY)
        	this.setPosicaoY(terrenoOffsetY);
        if (this.getPosicaoX() > terrenoOffsetX + larguraTerreno - tamanhoQuadro)
        	this.setPosicaoX(terrenoOffsetX + larguraTerreno - tamanhoQuadro);
        if (this.getPosicaoY() > terrenoOffsetY + alturaTerreno - tamanhoQuadro)
        	this.setPosicaoY(terrenoOffsetY + alturaTerreno - tamanhoQuadro);
        
	}
	
	public boolean verificarPedra(int x, int y) {
		for(Pedra pedra: configuracao.pedras) {
			if(x == pedra.getPosicaoX() && y == pedra.getPosicaoY()) {
				return true;
			}
		}
		return false;  		
	}

	public boolean verificarJogador(int x,int y) {
		for(Competidor jogador: configuracao.jogadores) {
			if(x == jogador.getPosicaoX() && y == jogador.getPosicaoY()){
				System.out.println("x:" + jogador.getPosicaoX() + "y:" +  jogador.getPosicaoY());
				return true;
			}
		}
		return false;  		
	}

    public void coletarFruta(int x, int y){
        for (Fruta fruta : configuracao.frutas){
            if(x == fruta.getPosicaoX() && y == fruta.getPosicaoY()){
            	if(mochila.frutasJogador.size() < configuracao.getCapacidadeMochila()) {
            		mochila.guardarFruta(fruta);
            		if(fruta.isBichada()) {
    					envenenado = true;
    					try {
							frente = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 poisoned front.png"));
							costa = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 poisoned back.png"));
							esquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 poisoned left.png"));
							direita = ImageIO.read(getClass().getResourceAsStream("/jogador/p1 poisoned right.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}
    				}
            		forcaDeAtaque = mochila.frutasJogador.size();
            		forcaDeDefesa = mochila.frutasJogador.size();
            		configuracao.frutas.remove(fruta);            		
            	}
            	return;
            }
        }
		return;
    }
    
    public void comerFruta(int frutaCode) {
    	switch (frutaCode) {
    	case 1:
    		for(Fruta fruta: mochila.frutasJogador) {
    			if(fruta instanceof Laranja) {
    				mochila.frutasJogador.remove(fruta);
    				mochila.setLaranjaQuant(mochila.getLaranjaQuant() - 1);
    				envenenado = false;
    				this.getImagem();
    				break;
    				
    			}
    		}
    		break;
    	case 2:
    		for(Fruta fruta: mochila.frutasJogador) {
    			if(fruta instanceof Coco) {
    				mochila.frutasJogador.remove(fruta);
    				mochila.setCocoQuant(mochila.getCocoQuant() - 1);
    				pontos*=2;
    				break;
    				
    			}
    		}
    		break;
    	case 3:
    		for(Fruta fruta: mochila.frutasJogador) {
    			if(fruta instanceof Abacate) {
    				mochila.frutasJogador.remove(fruta);
    				mochila.setAbacateQuant(mochila.getAbacateQuant() - 1);
    				forcaDeAtaque*=2;
    				break;
    				
    			}
    		}
    		break;
    		
    	}
    	
    	forcaDeAtaque = mochila.frutasJogador.size();
    	forcaDeDefesa = mochila.frutasJogador.size();
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
	
    public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getForcaDeAtaque() {
		return forcaDeAtaque;
	}

	public int getForcaDeDefesa() {
		return forcaDeDefesa;
	}

	public boolean isEnvenenado() {
		return envenenado;
	}

	public boolean isPodeMover() {
		return podeMover;
	}

	public void setPodeMover(boolean podeMover) {
		this.podeMover = podeMover;
	}
    
	
//	public void desenhar(Graphics2D g2) {
//		g2.setColor(Color.BLUE);
//		
//	
//	    g2.fillRect(this.getPosicaoX(), this.getPosicaoY(), tamanhoQuadro, tamanhoQuadro);
//	    
//		g2.setColor(Color.BLACK); 
//
//
//	    String texto = "Jogador";
//
//	    FontMetrics metrics = g2.getFontMetrics();
//	    int xTexto = this.getPosicaoX() + (tamanhoQuadro - metrics.stringWidth(texto)) / 2;
//	    int yTexto = this.getPosicaoY() + (tamanhoQuadro - metrics.getHeight()) / 2 + metrics.getAscent();
//
//	    g2.drawString(texto, xTexto, yTexto);
//	}

}
