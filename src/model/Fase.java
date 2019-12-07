package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import controller.ControlePersonagem;
import controller.EventoTeclado;

public class Fase {

	public static List<Rectangle> colisao;	
	private TileMap mapaChao;
	private TileMap mapaColisao;

	private Personagem personagem;
	private Item lixo;
	private ItemManager itemManager;

	public Fase() {

		try {
			personagem = new Personagem(0, 111, 144, 3, 4, 10, 5, "personagem.png");						
			itemManager = new ItemManager(lixo);			
			itemManager.addItem(new Item(32, 32, 100, 10, "lata.png", personagem));
			itemManager.addItem(new Item(32, 32, 305, 125, "lata.png", personagem));
			itemManager.addItem(new Item(32, 32, 400, 125, "lata.png", personagem));
			itemManager.addItem(new Item(32, 32, 500, 125, "copo.png", personagem));
			itemManager.addItem(new Item(32, 32, 200, 250, "copo.png", personagem));
			itemManager.addItem(new Item(32, 32, 30, 100, "garrafa.png", personagem));
			
			new ControlePersonagem(personagem);
		} catch (IOException e) {
			e.printStackTrace();
		}

		mapaChao = new TileMap(32, 32, 32, "tileset.png", "matrizChao.txt");
		mapaColisao = new TileMap(32, 32, 32, "tileset.png", "colisaoTroncos.txt");
		colisao = mapaColisao.montarColisao();
		

	}

	public static List<Rectangle> getColisao() {
		return colisao;
	}

	public TileMap getMapaChao() {
		return mapaChao;
	}

	public TileMap getMapaColisao() {
		return mapaColisao;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}



}
