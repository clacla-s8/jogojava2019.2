package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Personagem;

public class EventoTeclado extends KeyAdapter{
	
	Personagem personagem;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP:
			ControlePersonagem.mover = "cima";
			break;
		case KeyEvent.VK_DOWN:
			ControlePersonagem.mover = "baixo";
			break;
		case KeyEvent.VK_RIGHT:
			ControlePersonagem.mover = "direita";
			break;
		case KeyEvent.VK_LEFT:					
			ControlePersonagem.mover = "esquerda";
			break;

		default: 
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();

		switch (codigo) {
		case KeyEvent.VK_UP:
			ControlePersonagem.mover = "";
			break;
		case KeyEvent.VK_DOWN:
			ControlePersonagem.mover = "";
			break;
		case KeyEvent.VK_RIGHT:
			ControlePersonagem.mover = "";
			break;
		case KeyEvent.VK_LEFT:
			ControlePersonagem.mover = "";
			break;
		default:
			break;
		}

	}

}

