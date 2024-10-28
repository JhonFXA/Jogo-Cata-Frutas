package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Competidor;

public abstract class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	protected Competidor jogador;
	
	public KeyHandler(Competidor jogador) {
		this.jogador = jogador;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
