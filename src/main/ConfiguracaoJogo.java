package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import arvores.Abacateiro;
import arvores.Aceroleira;
import arvores.Amoreira;
import arvores.Arvore;
import arvores.Coqueiro;
import arvores.Goiabeira;
import arvores.Laranjeira;
import entity.Competidor;
import frutas.Abacate;
import frutas.Acerola;
import frutas.Amora;
import frutas.Coco;
import frutas.Fruta;
import frutas.Goiaba;
import frutas.Laranja;
import frutas.Maracuja;
import pedra.Pedra;

public class ConfiguracaoJogo {
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
    
	public int maracujasNoTerreno = 0;
    
	private String nomeJogadorUm;
    private String nomeJogadorDois;
    
    private final int tamanhoQuadroOriginal = 16; // quadro 16x16
    private final int escala = 3;
    private final int tamanhoQuadro = tamanhoQuadroOriginal * escala; // quadro 48x48
    private final int larguraJanela = 1280; // largura fixa da janela
    private final int alturaJanela = 700;  // altura fixa da janela
    private final int larguraTerreno; // largura do terreno em px
    private final int alturaTerreno; // altura do terreno em px
    private int terrenoOffsetX;
    private int terrenoOffsetY;
    
	public List<int[]> posicoesUsadas = new ArrayList<>();
	public List<Pedra> pedras = new ArrayList<>();
	public List<Fruta> frutas = new ArrayList<>();
	public List<Arvore> arvores = new ArrayList<>();
	public List<Competidor> jogadores = new ArrayList<>();
    
    public ConfiguracaoJogo(int dimensao, int quantidadePedras, double chanceBichada, int capacidadeMochila, int maracujasNoJogo, int maracujasNoChao, int laranjeirasNoJogo, int laranjasNoChao, int abacateirasNoJogo, int abacatesNoChao, int coqueirosNoJogo, int cocosNoChao, int aceroleirasNoJogo, int acerolasNoChao, int amoreirasNoJogo, int amorasNoChao, int goiabeirasNoJogo, int goiabasNoChao) {
    	this.dimensao = dimensao;
        this.quantidadePedras = quantidadePedras;
        this.chanceBichada = chanceBichada;
        this.capacidadeMochila = capacidadeMochila;
        this.maracujasNoJogo = maracujasNoJogo;
        this.maracujasNoChao = maracujasNoChao;
        this.laranjeirasNoJogo = laranjeirasNoJogo;
        this.laranjasNoChao = laranjasNoChao;
        this.abacateirasNoJogo = abacateirasNoJogo;
        this.abacatesNoChao = abacatesNoChao;
        this.coqueirosNoJogo = coqueirosNoJogo;
        this.cocosNoChao = cocosNoChao;
        this.aceroleirasNoJogo = aceroleirasNoJogo;
        this.acerolasNoChao = acerolasNoChao;
        this.amoreirasNoJogo = amoreirasNoJogo;
        this.amorasNoChao = amorasNoChao;
        this.goiabeirasNoJogo = goiabeirasNoJogo;
        this.goiabasNoChao = goiabasNoChao;
        
        larguraTerreno = tamanhoQuadro * dimensao;
        alturaTerreno = tamanhoQuadro * dimensao;
        
     // Calcula o deslocamento para centralizar o terreno na tela
        terrenoOffsetX = (larguraJanela - larguraTerreno) / 2;
        terrenoOffsetY = (alturaJanela - alturaTerreno) / 2;
        
//        gerarTerreno();
    }
    
    public int gerarPosicaoX() {
    	Random random = new Random();
    	int x = random.nextInt(dimensao) * tamanhoQuadro + terrenoOffsetX;
    	return x;
    }
    
    public int gerarPosicaoY() {
    	Random random = new Random();
    	int y = random.nextInt(dimensao) * tamanhoQuadro + terrenoOffsetY;
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
    
    public <T> void adicionarObjetos(Class<T> classeObjeto, int quantidade, List<? super T> listaDestino) {
        for (int i = 0; i < quantidade; i++) {
            int x, y;
            int[] posicao;

            do {
                x = gerarPosicaoX();
                y = gerarPosicaoY();
                posicao = new int[]{x, y};
            } while (verificarPosicao(posicao));

            posicoesUsadas.add(posicao);

            try {
                T objeto = classeObjeto.getConstructor(int.class, int.class, ConfiguracaoJogo.class)
                                        .newInstance(x, y, this);
                listaDestino.add(objeto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void gerarTerreno() {
    	
    	adicionarObjetos(Pedra.class, quantidadePedras, pedras);
    	
    	adicionarObjetos(Maracuja.class, maracujasNoChao, frutas);
    	adicionarObjetos(Laranja.class, laranjasNoChao, frutas);
    	adicionarObjetos(Abacate.class, abacatesNoChao, frutas);
    	adicionarObjetos(Coco.class, cocosNoChao, frutas);
    	adicionarObjetos(Acerola.class, acerolasNoChao, frutas);
    	adicionarObjetos(Amora.class, amorasNoChao, frutas);
    	adicionarObjetos(Goiaba.class, goiabasNoChao, frutas);
    	
    	adicionarObjetos(Laranjeira.class, laranjeirasNoJogo, arvores);
    	adicionarObjetos(Abacateiro.class, abacateirasNoJogo, arvores);
    	adicionarObjetos(Coqueiro.class, coqueirosNoJogo, arvores);
    	adicionarObjetos(Aceroleira.class, aceroleirasNoJogo, arvores);
    	adicionarObjetos(Amoreira.class, amoreirasNoJogo, arvores);
    	adicionarObjetos(Goiabeira.class, goiabeirasNoJogo, arvores);

    }
    
    public String getNomeJogadorUm() {
		return nomeJogadorUm;
	}
    
	public void setNomeJogadorUm(String nomeJogadorUm) {
		this.nomeJogadorUm = nomeJogadorUm;
	}

	public String getNomeJogadorDois() {
		return nomeJogadorDois;
	}

	public void setNomeJogadorDois(String nomeJogadorDois) {
		this.nomeJogadorDois = nomeJogadorDois;
	}
    
    public int getDimensao() {
        return dimensao;
    }

    public int getQuantidadePedras() {
        return quantidadePedras;
    }

    public double getChanceBichada() {
        return chanceBichada;
    }

    public int getCapacidadeMochila() {
        return capacidadeMochila;
    }

    public int getMaracujasNoJogo() {
        return maracujasNoJogo;
    }

    public int getMaracujasNoChao() {
        return maracujasNoChao;
    }

    public int getLaranjeirasNoJogo() {
        return laranjeirasNoJogo;
    }

    public int getLaranjasNoChao() {
        return laranjasNoChao;
    }

    public int getAbacateirasNoJogo() {
        return abacateirasNoJogo;
    }

    public int getAbacatesNoChao() {
        return abacatesNoChao;
    }

    public int getCoqueirosNoJogo() {
        return coqueirosNoJogo;
    }

    public int getCocosNoChao() {
        return cocosNoChao;
    }

    public int getAceroleirasNoJogo() {
        return aceroleirasNoJogo;
    }

    public int getAcerolasNoChao() {
        return acerolasNoChao;
    }

    public int getAmoreirasNoJogo() {
        return amoreirasNoJogo;
    }

    public int getAmorasNoChao() {
        return amorasNoChao;
    }

    public int getGoiabeirasNoJogo() {
        return goiabeirasNoJogo;
    }

    public int getGoiabasNoChao() {
        return goiabasNoChao;
    }

    public int getTamanhoQuadroOriginal() {
        return tamanhoQuadroOriginal;
    }

    public int getEscala() {
        return escala;
    }

    public int getTamanhoQuadro() {
        return tamanhoQuadro;
    }

    public int getLarguraJanela() {
        return larguraJanela;
    }

    public int getAlturaJanela() {
        return alturaJanela;
    }

    public int getLarguraTerreno() {
        return larguraTerreno;
    }

    public int getAlturaTerreno() {
        return alturaTerreno;
    }

    public int getTerrenoOffsetX() {
        return terrenoOffsetX;
    }

    public int getTerrenoOffsetY() {
        return terrenoOffsetY;
    }
}
