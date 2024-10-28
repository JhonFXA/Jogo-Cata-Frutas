package main;

import java.util.ArrayList;

import frutas.*;

public class Mochila {
     public ArrayList<Fruta> frutasJogador = new ArrayList<>();
     private int maracujaQuant = 0;
     private int laranjaQuant = 0;
     private int abacateQuant = 0;
     private int amoraQuant = 0;
     private int acerolaQuant = 0;
     private int goiabaQuant = 0;
     private int cocoQuant = 0;
     
     private int capacidade;
     
     
     
     public Mochila(int capacidade) {
    	 this.setCapacidade(capacidade);
     }
     
     public void guardarFruta(Fruta fruta) {
    	 frutasJogador.add(fruta);
    	 if(fruta instanceof Maracuja) {
    		 maracujaQuant++;
    	 }
    	 else if(fruta instanceof Laranja) {
    		 laranjaQuant++;
    	 }
    	 else if(fruta instanceof Abacate) {
    		 abacateQuant++;
    	 }
    	 else if(fruta instanceof Amora) {
    		 amoraQuant++;
    	 }
    	 else if(fruta instanceof Acerola) {
    		 acerolaQuant++;
    	 }
    	 else if(fruta instanceof Goiaba) {
    		 goiabaQuant++;
    	 }
    	 else if(fruta instanceof Coco) {
    		 cocoQuant++;
    	 }
     }

	public int getMaracujaQuant() {
		return maracujaQuant;
	}

	public void setMaracujaQuant(int maracujaQuant) {
		this.maracujaQuant = maracujaQuant;
	}

	public int getLaranjaQuant() {
		return laranjaQuant;
	}

	public void setLaranjaQuant(int laranjaQuant) {
		this.laranjaQuant = laranjaQuant;
	}

	public int getAbacateQuant() {
		return abacateQuant;
	}

	public void setAbacateQuant(int abacateQuant) {
		this.abacateQuant = abacateQuant;
	}

	public int getAmoraQuant() {
		return amoraQuant;
	}

	public void setAmoraQuant(int amoraQuant) {
		this.amoraQuant = amoraQuant;
	}

	public int getAcerolaQuant() {
		return acerolaQuant;
	}

	public void setAcerolaQuant(int acerolaQuant) {
		this.acerolaQuant = acerolaQuant;
	}

	public int getGoiabaQuant() {
		return goiabaQuant;
	}

	public void setGoiabaQuant(int goiabaQuant) {
		this.goiabaQuant = goiabaQuant;
	}

	public int getCocoQuant() {
		return cocoQuant;
	}

	public void setCocoQuant(int cocoQuant) {
		this.cocoQuant = cocoQuant;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
}
