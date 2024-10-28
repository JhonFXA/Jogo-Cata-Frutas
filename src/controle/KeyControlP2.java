package controle;

import java.awt.event.KeyEvent;

import entity.Competidor;

public class KeyControlP2 extends KeyHandler{
	
	public KeyControlP2(Competidor jogador) {
		super(jogador);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_NUMPAD1) {
			jogador.comerFruta(1);
		}
		if(code == KeyEvent.VK_NUMPAD2) {
			jogador.comerFruta(2);
		}
		if(code == KeyEvent.VK_NUMPAD3) {
			jogador.comerFruta(3);
		}
		
		if(code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = true;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_DOWN) {
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		
	}
}
