package controle;

import java.awt.event.KeyEvent;

import entity.Competidor;

public class KeyControlP1 extends KeyHandler {
	
	public KeyControlP1(Competidor jogador) {
		super(jogador);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_1) {
			jogador.comerFruta(1);
		}
		if(code == KeyEvent.VK_2) {
			jogador.comerFruta(2);
		}
		if(code == KeyEvent.VK_3) {
			jogador.comerFruta(3);
		}
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
	}
}
