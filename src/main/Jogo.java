package main;

import javax.swing.*;
import entity.Competidor;

import arvores.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import frutas.*;
import grama.Grama;
import pedra.Pedra;

public class Jogo extends JPanel implements Runnable {
//    int jogadorX = 0;
//    int jogadorY = 0;

	private final int tamanhoQuadro;


    private int dimensao;
    private int quantidadePedras;
    private double chanceBichada;
    private int capacidadeMochila;
    private int maracujasNoJogo;
    private int maracujasNoChao;
	private int laranjeirasNoJogo;
	private int laranjasNoChao;
	private int abacateirasNoJogo;
	private int abacatesNoChao;
	private int coqueirosNoJogo;
	private int cocosNoChao;
	private int aceroleirasNoJogo;
	private int acerolasNoChao;
	private int amoreirasNoJogo;
	private int amorasNoChao;
	private int goiabeirasNoJogo;
	private int goiabasNoChao;
	
	Thread gameThread;
	private final int FPS = 60;
	
	ConfiguracaoJogo configuracao;
	Competidor jogadorUm;
	Grama grama;
	
	ArrayList<int[]> posicoesUsadas = new ArrayList<>();
	ArrayList<Pedra> pedras = new ArrayList<>();
	ArrayList<Fruta> frutas = new ArrayList<>();
	ArrayList<Arvore> arvores = new ArrayList<>();
	

    public Jogo(ConfiguracaoJogo configuracao) {
    	
    	this.configuracao = configuracao;
    	jogadorUm = new Competidor(0, 0, configuracao);
    	grama = new Grama(0, 0, configuracao);
    	
    	this.tamanhoQuadro = configuracao.getTamanhoQuadro();
        this.dimensao = configuracao.getDimensao();
        this.quantidadePedras = configuracao.getQuantidadePedras();
        this.chanceBichada = configuracao.getChanceBichada();
        this.capacidadeMochila = configuracao.getCapacidadeMochila();
        this.maracujasNoJogo = configuracao.getMaracujasNoJogo();
        this.maracujasNoChao = configuracao.getMaracujasNoChao();
        this.laranjeirasNoJogo = configuracao.getLaranjeirasNoJogo();
        this.laranjasNoChao = configuracao.getLaranjasNoChao();
        this.abacateirasNoJogo = configuracao.getAbacateirasNoJogo();
        this.abacatesNoChao = configuracao.getAbacatesNoChao();
        this.coqueirosNoJogo = configuracao.getCoqueirosNoJogo();
        this.cocosNoChao = configuracao.getCocosNoChao();
        this.aceroleirasNoJogo = configuracao.getAceroleirasNoJogo();
        this.acerolasNoChao = configuracao.getAcerolasNoChao();
        this.amoreirasNoJogo = configuracao.getAmoreirasNoJogo();
        this.amorasNoChao = configuracao.getAmorasNoChao();
        this.goiabeirasNoJogo = configuracao.getGoiabeirasNoJogo();
        this.goiabasNoChao = configuracao.getGoiabasNoChao();
        
        
        

        this.setPreferredSize(new Dimension(configuracao.getLarguraJanela(), configuracao.getAlturaJanela()));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(jogadorUm.keyH);
        this.setFocusable(true);

        gerarTerreno();
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Teste de Terreno");
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        startGameThread();
    }


    
    public int gerarPosicaoX() {
    	Random random = new Random();
    	int x = random.nextInt(dimensao) * tamanhoQuadro + configuracao.getTerrenoOffsetX();
    	return x;
    }
    
    public int gerarPosicaoY() {
    	Random random = new Random();
    	int y = random.nextInt(dimensao) * tamanhoQuadro + configuracao.getTerrenoOffsetY();
    	return y;
    }
    
    public boolean verificarPosicao(int novaPosicao[]) {
    	for(int posicao[]: posicoesUsadas) {
    		if(posicao[0] == novaPosicao[0] && posicao[1] == novaPosicao[1]) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    

    public void gerarTerreno() {

        for (int i = 0; i < quantidadePedras; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        		
        	posicoesUsadas.add(posicao);
            Pedra pedra = new Pedra(x, y, configuracao);
            pedras.add(pedra);
        }

        for (int i = 0; i < maracujasNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        		
        	posicoesUsadas.add(posicao);
            Maracuja maracuja = new Maracuja(x, y, configuracao);
            frutas.add(maracuja);
        }
        
        for (int i = 0; i < laranjasNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Laranja laranja = new Laranja(x, y, configuracao);
        	frutas.add(laranja);
        }
        
   
        for (int i = 0; i < abacatesNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Abacate abacate = new Abacate(x, y, configuracao);
        	frutas.add(abacate);
        }
        
        for (int i = 0; i < cocosNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Coco coco = new Coco(x, y, configuracao);
        	frutas.add(coco);
        }
        
        for (int i = 0; i < acerolasNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Acerola acerola = new Acerola(x, y, configuracao);
        	frutas.add(acerola);
        }
        
        for (int i = 0; i < amorasNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Amora amora = new Amora(x, y, configuracao);
        	frutas.add(amora);
        }

        for (int i = 0; i < goiabasNoChao; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Goiaba goiaba = new Goiaba(x, y, configuracao);
        	frutas.add(goiaba);
        }
        
        for (int i = 0; i < laranjeirasNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Laranjeira laranjeira = new Laranjeira(x, y, configuracao);
        	arvores.add(laranjeira);
        }
        
        for (int i = 0; i < abacateirasNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Abacateiro abacateiro = new Abacateiro(x, y, configuracao);
        	arvores.add(abacateiro);
        }
        
        for (int i = 0; i < coqueirosNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Coqueiro coqueiro = new Coqueiro(x, y, configuracao);
        	arvores.add(coqueiro);
        }
        
        for (int i = 0; i < aceroleirasNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Aceroleira aceroleira = new Aceroleira(x, y, configuracao);
        	arvores.add(aceroleira);
        }
        
        for (int i = 0; i < amoreirasNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Amoreira amoreira = new Amoreira(x, y, configuracao);
        	arvores.add(amoreira);
        }
        
        for (int i = 0; i < goiabeirasNoJogo; i++) {
        	int x;
        	int y;
        	int posicao[];
        	do {
        		x = gerarPosicaoX();
        		y = gerarPosicaoY();
        		posicao = new int[]{x, y};
        	} while(verificarPosicao(posicao));
        	
        	posicoesUsadas.add(posicao);
        	Goiabeira goiabeira = new Goiabeira(x, y, configuracao);
        	arvores.add(goiabeira);
        }

    }

    public void update() {
    	jogadorUm.mover();
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
        Graphics2D g2 = (Graphics2D) g;

        // Definir fonte para o texto
        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        FontMetrics metrics = g2.getFontMetrics();

        grama.desenhar(g2);
        
        for (Pedra pedra : pedras) {
        	pedra.desenhar(g2);
        }
        
        for (Fruta fruta : frutas) {
        	fruta.desenhar(g2);
        }

        
        for(Arvore arvore: arvores) {
        	arvore.desenhar(g2);
        }
        
        // Desenhar o jogador
        jogadorUm.desenhar(g2);
        g2.dispose();
    }

}
