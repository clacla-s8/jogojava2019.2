package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Item;
import model.ItemManager;
import model.Personagem;
import model.TileMap;
import view.FaseView;
import view.TelaGeral;

public class Camera extends Jogo{

	private Personagem personagem;
	private ItemManager itemManager;	
	static int x = 0;
	static int y = 0;

	private TileMap[] maps;
	private BufferedImage imagemMapa;
	private Graphics2D graficosMapa;

	public Camera(FaseView fase, Personagem personagem,ItemManager itemManager , TileMap...maps) {

		super(fase);

		this.personagem = personagem;
		this.itemManager = itemManager;

		this.maps = maps;

		start();
	}

	@Override
	public void gameRender() {

		for(int i = 0; i < maps.length; i++)
		{
			maps[i].montarMapa();

			if(i < 3) {
				graficosMapa.drawImage(maps[i].getMapa(), 0, 0, null);


				personagem.draw(graficosMapa);
				//graficosMapa.draw(personagem.getBounds());
				itemManager.draw(graficosMapa);		
				

			}
			else{
				graficosMapa.drawImage(maps[i].getMapa(), 0, 0, null);
			}			

		}
	}


	@Override
	public void draw(Graphics g) {

		x = Math.min(imagemMapa.getWidth() - TelaGeral.LARGURA, Math.max(0, personagem.getX() - TelaGeral.LARGURA / 2));
		y = Math.min(imagemMapa.getHeight() - TelaGeral.ALTURA, Math.max(0, personagem.getY() - TelaGeral.ALTURA / 2));

		g.drawImage(imagemMapa, -x, -y, null);

	}

	@Override
	public void init() {

		imagemMapa = new BufferedImage(maps[0].getLarguraTela(), maps[0].getAlturaTela(), BufferedImage.TYPE_4BYTE_ABGR);
		graficosMapa = (Graphics2D) imagemMapa.getGraphics();		
	}
	

	@Override
	public void tick() {
		itemManager.tick();
		itemManager.draw(graficosMapa);
		
	}

}
