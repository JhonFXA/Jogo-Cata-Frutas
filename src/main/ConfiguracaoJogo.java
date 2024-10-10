package main;

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
    
    private final int tamanhoQuadroOriginal = 16; // quadro 16x16
    private final int escala = 3;
    private final int tamanhoQuadro = tamanhoQuadroOriginal * escala; // quadro 48x48
    private final int larguraJanela = 1280; // largura fixa da janela
    private final int alturaJanela = 700;  // altura fixa da janela
    private final int larguraTerreno; // largura do terreno em px
    private final int alturaTerreno; // altura do terreno em px
    private int terrenoOffsetX;
    private int terrenoOffsetY;
    
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
