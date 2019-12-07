package view;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Fase;
import model.Personagem;

public class TelaExibicao extends TelaGeral {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Inventario inventario;
	private FaseView fase;
	private Menu menu;
	private JPanel jogo;
	
	
	//Creditos Creditos;

	CardLayout cardLayout;
	
	public TelaExibicao() {

		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		fase = new FaseView();
		inventario = new Inventario();
		menu = new Menu();
//		
		//add(fase);
		
		jogo = new JPanel();
		jogo.setLayout(null);
////		jogo.setVisible(false);
		
		jogo.add(fase).setBounds(0, 0, 600, TelaGeral.ALTURA);
		jogo.add(inventario).setBounds(600, 0, 200, TelaGeral.ALTURA);
		
		add(menu, "m");
		add(jogo, "j");
		

		setVisible(true);
	}

	public FaseView getFase() {
		return fase;
	}
	
	public void mostrar(String tela) {
		cardLayout.show(getContentPane(), tela);
		
	}

	public Inventario getInventario() {
		return inventario;
	}

	public Menu getMenu() {
		return menu;
	}	
	

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getJogo() {
		return jogo;
	}

	
	
	
	

}

