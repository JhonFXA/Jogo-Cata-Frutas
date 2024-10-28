package main;

import javax.swing.*;
import entity.Competidor;
import entity.JogadorDois;
import entity.JogadorUm;
import arvores.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import frutas.*;
import grama.Grama;
import pedra.Pedra;

public class Jogo extends JPanel implements Runnable {

	Thread gameThread;
	private final int FPS = 60;
	
	ConfiguracaoJogo configuracao;
	Grama grama;
	JogadorUm jogadorUm;
	JogadorDois jogadorDois;
	
	public int gameState = 0;
	public int rodada = 1;
	public String turno = "Jogador 1";
	public final int titleState = 0;
	public int[] posicaoJ1;
	public int[] posicaoJ2;
	
	private boolean jogoTerminado = false;
	private String vencedor = "";
	

	

    public Jogo(ConfiguracaoJogo configuracao) {
    	
    	this.configuracao = configuracao;
        
        int xJogador1 = configuracao.gerarPosicaoX();
        int yJogador1 = configuracao.gerarPosicaoY();
        int xJogador2 = configuracao.gerarPosicaoX();
        int yJogador2 = configuracao.gerarPosicaoY();
        
        posicaoJ1 = new int[]{xJogador1, yJogador1};
        posicaoJ2 = new int[]{xJogador2, yJogador2};
        
        jogadorUm = new JogadorUm(xJogador1, yJogador1, configuracao, configuracao.getNomeJogadorUm());
        jogadorDois = new JogadorDois(xJogador2, yJogador2, configuracao, configuracao.getNomeJogadorDois());
        configuracao.posicoesUsadas.add(posicaoJ1);
        configuracao.posicoesUsadas.add(posicaoJ2);
        configuracao.gerarTerreno();
        configuracao.posicoesUsadas.remove(posicaoJ1);
        configuracao.posicoesUsadas.remove(posicaoJ2);
        grama = new Grama(0, 0, configuracao);
        

        this.setPreferredSize(new Dimension(configuracao.getLarguraJanela(), configuracao.getAlturaJanela()));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(jogadorUm.keyH);
        this.addKeyListener(jogadorDois.keyH);
        this.setFocusable(true);
        
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Cata-Frutas");
        
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
		
        startGameThread();
    }
    

    public void update() {
    		
    	jogadorUm.verificarMovimento();
    	jogadorDois.verificarMovimento();
    	
    	if(jogadorUm.getPontos() == 0) {
    		jogadorUm.setPodeMover(false);
    		jogadorDois.setPodeMover(true);
    		turno = "Jogador 2";
    	} 
    	if(jogadorDois.getPontos() == 0) {
    		jogadorUm.setPodeMover(true);
    		jogadorDois.setPodeMover(false);
    		rodada++;
    		jogadorUm.girarDados();
    		jogadorDois.girarDados();
    		turno = "Jogador 1";
    		if(rodada % 2 == 0) {
    			if(configuracao.maracujasNoTerreno < configuracao.getMaracujasNoJogo()) {
    				configuracao.adicionarObjetos(Maracuja.class, configuracao.getMaracujasNoChao(), configuracao.frutas);
    				configuracao.maracujasNoTerreno++;
    			}	
    		}
    		verificarVitoria(jogadorUm);
    		verificarVitoria(jogadorDois);
    	}
    }
    
    public void verificarVitoria(Competidor jogador) {
    	if(jogador.mochila.getMaracujaQuant() >= (configuracao.getMaracujasNoJogo()/2) + 1) {		
    		jogoTerminado = true;
	        vencedor = jogador.nome;
	        repaint();
    	}
    	
    }
  
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // 0.01666 segundos
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (jogoTerminado) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            
            // Exibir o texto do vencedor no centro da tela
            String textoVitoria = vencedor + " venceu o jogo!";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int x = (getWidth() - metrics.stringWidth(textoVitoria)) / 2;
            int y = getHeight() / 2;
            g.drawString(textoVitoria, x, y);
        } else {
	        Graphics2D g2 = (Graphics2D) g;
	       
	        grama.desenhar(g2);
	        
	        for (Pedra pedra : configuracao.pedras) {
	        	pedra.desenhar(g2);
	        }
	        
	        for (Fruta fruta : configuracao.frutas) {
	        	fruta.desenhar(g2);
	        }
	        
	        jogadorUm.desenhar(g2);
	        
	        jogadorDois.desenhar(g2);
	        
	        for (Arvore arvore : configuracao.arvores) {
	            boolean jogadorNaMesmaPosicao = 
	                    (arvore.getPosicaoX() == jogadorUm.getPosicaoX() && arvore.getPosicaoY() == jogadorUm.getPosicaoY()) ||
	                    (arvore.getPosicaoX() == jogadorDois.getPosicaoX() && arvore.getPosicaoY() == jogadorDois.getPosicaoY());
	
	            if (jogadorNaMesmaPosicao) {
	                // Define a opacidade para 50% se um jogador estiver na mesma posição
	                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
	            } else {
	                // Restaura a opacidade normal
	                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	            }
	
	            arvore.desenhar(g2);
	        }
	
	
	        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	
	        
	        g2.setColor(Color.WHITE);
	        g2.setFont(new Font("Arial", Font.BOLD, 20));
	        g2.drawString("Jogador 1: " + configuracao.getNomeJogadorUm(), 20, 40);
	        
	        
	        g2.setFont(new Font("Arial", Font.BOLD, 16));
	        g2.drawString("Pontos: ", 20, 80);
	        g2.setColor(Color.GREEN);
	        g2.drawString(String.valueOf(jogadorUm.getPontos()), 100, 80);
	        
	        g2.setColor(Color.WHITE);
	        g2.drawString(">> MOCHILA (capacidade: " + jogadorUm.mochila.getCapacidade() + ") <<", 20, 130);
	        g2.drawString("Maracujá: " + jogadorUm.mochila.getMaracujaQuant(), 20, 160);
	        g2.drawString("Laranja: " + jogadorUm.mochila.getLaranjaQuant() + " (Aperte 1 para comer)", 20, 180);
	        g2.drawString("Coco: " + jogadorUm.mochila.getCocoQuant() + " (Aperte 2 para comer)", 20, 200);
	        g2.drawString("Abacate: " + jogadorUm.mochila.getAbacateQuant() + " (Aperte 3 para comer)", 20, 220);
	        g2.drawString("Goiaba: " + jogadorUm.mochila.getGoiabaQuant(), 20, 240);
	        g2.drawString("Amora: " + jogadorUm.mochila.getAmoraQuant(), 20, 260);
	        g2.drawString("Acerola: " + jogadorUm.mochila.getAcerolaQuant(), 20, 280);
	        
	        if(jogadorUm.isEnvenenado()) {
	        	g2.setColor(Color.GREEN);
	        	g2.drawString("ENVENENADO!", 20, 310);        	
	      	
	        }
	        
	        
	        g2.setColor(Color.WHITE);
	        g2.setFont(new Font("Arial", Font.BOLD, 20));
	        g2.drawString("Jogador 2: " + configuracao.getNomeJogadorDois(), 1000, 40);
	        
	        
	        g2.setFont(new Font("Arial", Font.BOLD, 16));
	        g2.drawString("Pontos: ", 1000, 80);
	        g2.setColor(Color.GREEN);
	        g2.drawString(String.valueOf(jogadorDois.getPontos()), 1080, 80);
	        
	        g2.setColor(Color.WHITE);
	        g2.drawString(">> MOCHILA (capacidade: " + jogadorDois.mochila.getCapacidade() + ") <<", 1000, 130);
	        g2.drawString("Maracujá: " + jogadorDois.mochila.getMaracujaQuant(), 1000, 160);
	        g2.drawString("Laranja: " + jogadorDois.mochila.getLaranjaQuant() + " (Aperte 1 para comer)", 1000, 180);
	        g2.drawString("Coco: " + jogadorDois.mochila.getCocoQuant() + " (Aperte 2 para comer)", 1000, 200);
	        g2.drawString("Abacate: " + jogadorDois.mochila.getAbacateQuant() + " (Aperte 3 para comer)", 1000, 220);
	        g2.drawString("Goiaba: " + jogadorDois.mochila.getGoiabaQuant(), 1000, 240);
	        g2.drawString("Amora: " + jogadorDois.mochila.getAmoraQuant(), 1000, 260);
	        g2.drawString("Acerola: " + jogadorDois.mochila.getAcerolaQuant(), 1000, 280);
	        
	        if(jogadorDois.isEnvenenado()) {
	        	g2.setColor(Color.GREEN);
	        	g2.drawString("ENVENENADO!", 1000, 310);        	
	      	
	        }
	        
	        g2.setColor(Color.WHITE);
	        g2.setFont(new Font("Arial", Font.BOLD, 30));
	        g2.drawString("RODADA: " + rodada, 20, 600);
	        g2.drawString("TURNO: " + turno, 20, 650);
	        
	        g2.dispose();
        }
    }
}
