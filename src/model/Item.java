package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {	
	
	private int itemLargura, itemAltura; 
	private BufferedImage item;
	private int x, y, count;
	private Rectangle bounds;
	private Personagem personagem;
	private boolean pegou = false;
	private int id;
	
	
	public Item(int itemLargura, int itemAltura,int x, int y, String enderecoItem, Personagem personagem, int id) {
		
		try {
			this.item = ImageIO.read(getClass().getClassLoader().getResourceAsStream(enderecoItem));
		} catch (IOException e) {
			System.out.println("Não foi possivel carregar a imagem do item");
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.itemLargura = itemLargura;
		this.itemAltura = itemAltura;
		this.personagem = personagem;
		this.id = id;
		count = 0;
		
		
		bounds = new Rectangle(x, y, itemLargura, itemAltura);
	}
	
	public void draw(Graphics g) {
		g.drawImage(getItem(), getX(), getY(), getItemLargura(), getItemAltura(), null);
		
		//((Graphics2D) g).draw(getBounds()); // visualizar o bounds dos itens
	}
	
	public void tick() {
		if(personagem.getBounds().intersects(bounds)) {
			pegou = true;
			
		}
		
		
		
	}
	
	public boolean colisao(Rectangle colisao) {
		
		return this.bounds.intersects(colisao);
		
	}
	
	public void setLocale(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public BufferedImage getItem() {
		return item;
	}

	public void setItem(BufferedImage item) {
		this.item = item;
	}	
	
	public int getItemLargura() {
		return itemLargura;
	}

	public void setItemLargura(int itemLargura) {
		this.itemLargura = itemLargura;
	}

	public int getItemAltura() {
		return itemAltura;
	}

	public void setItemAltura(int itemAltura) {
		this.itemAltura = itemAltura;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

	public boolean isPegou() {
		return pegou;
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	
	
	
	
}
