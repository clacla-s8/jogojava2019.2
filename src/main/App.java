package main;

import controller.Camera;
import controller.ControlePersonagem;
import controller.EventoBotoes;
import controller.EventoTeclado;
import model.Fase;
import view.TelaExibicao;

public class App {
	public static void main(String[] args) {
		
		//view
		TelaExibicao tela = new TelaExibicao();
		
		//models
		Fase fase = new Fase();
		
		//controles
		new Camera(tela.getFase(), fase.getPersonagem(), fase.getItemManager(), tela.getInventario(), tela, fase.getMapaChao(), fase.getMapaColisao());
		
		new ControlePersonagem(fase.getPersonagem()); // controle responsavel pelo movimento do player
		
		tela.getFase().addKeyListener(new EventoTeclado());// adiciono o evento de teclado
		
		new EventoBotoes(tela.getMenu(), tela, tela.getInventario(), tela.getGameOver());
		
	}

}