package main;

import javax.swing.*;

import arvores.*;

import java.awt.*;

import frutas.*;
import grama.Grama;
import pedra.Pedra;

public class Floresta extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;


	
	Thread gameThread;
	private final int FPS = 60;
	
	ConfiguracaoJogo configuracao;
	Grama grama;
	
    public Floresta(ConfiguracaoJogo configuracao) {
    	
    	this.configuracao = configuracao;
    	configuracao.gerarTerreno();
    	grama = new Grama(0, 0, configuracao);
        

        this.setPreferredSize(new Dimension(configuracao.getLarguraJanela(), configuracao.getAlturaJanela()));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Teste de Terreno");
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        startGameThread();
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

        grama.desenhar(g2);
        
        for (Pedra pedra : configuracao.pedras) {
        	pedra.desenhar(g2);
        }
        
        for (Fruta fruta : configuracao.frutas) {
        	fruta.desenhar(g2);
        }

        
        for(Arvore arvore: configuracao.arvores) {
        	arvore.desenhar(g2);
        }
        
        g2.dispose();
    }

}
