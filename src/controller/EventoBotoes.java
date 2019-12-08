package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameOver;
import view.Inventario;
import view.Menu;
import view.TelaExibicao;

public class EventoBotoes implements ActionListener {
	private Menu menu;
	private TelaExibicao telaExibicao;
	private Inventario inventario;
	private GameOver gameOver;
	
	public EventoBotoes(Menu menu, TelaExibicao telaExibicao, Inventario inventario, GameOver gameOver) {
		this.menu = menu;
		this.telaExibicao = telaExibicao;
		this.inventario = inventario;
		this.gameOver = gameOver;
		
		menu.getButtonJogar().addActionListener(this);
		gameOver.getButtonhome().addActionListener(this);
		menu.getButtonSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == menu.getButtonSair()) {
					System.exit(0);
				}
				
			}
		});
				
		inventario.getVoltar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == inventario.getVoltar()) {
					telaExibicao.mostrar("m");
				}
				
			}
		});
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getButtonJogar()) {
			telaExibicao.mostrar("j");
			telaExibicao.getFase().requestFocus();
			
		}
		
		if(e.getSource() == gameOver.getButtonhome()) {
			telaExibicao.mostrar("m");
		}
		
	}
}