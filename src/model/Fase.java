package model;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import controller.ControlePersonagem;


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
			itemManager.addItem(new Item(32, 32, 400, 250, "papel.png", personagem, 0));
			itemManager.addItem(new Item(32, 32, 250, 750, "papel.png", personagem, 0));
			itemManager.addItem(new Item(32, 32, 450, 600, "papel.png", personagem, 0));
			itemManager.addItem(new Item(32, 32, 700, 400, "papel.png", personagem, 0));
			itemManager.addItem(new Item(32, 32, 400, 750, "lata.png", personagem, 1));
			itemManager.addItem(new Item(32, 32, 305, 125, "lata.png", personagem, 1));
			itemManager.addItem(new Item(32, 32, 400, 20, "lata.png", personagem, 1));
			itemManager.addItem(new Item(32, 32, 280, 450, "lata.png", personagem, 1));
			itemManager.addItem(new Item(32, 32, 400, 500, "copo.png", personagem, 2));
			itemManager.addItem(new Item(32, 32, 500, 125, "copo.png", personagem, 2));
			itemManager.addItem(new Item(32, 32, 200, 250, "copo.png", personagem, 2));
			itemManager.addItem(new Item(32, 32, 500,750, "copo.png", personagem, 2));
			itemManager.addItem(new Item(32, 32, 300, 50, "garrafa.png", personagem, 3));
			itemManager.addItem(new Item(32, 32, 100, 750, "garrafa.png", personagem, 3));
			itemManager.addItem(new Item(32, 32, 700, 250, "garrafa.png", personagem, 3));
			itemManager.addItem(new Item(32, 32, 700, 20, "garrafa.png", personagem, 3));
			
			
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
