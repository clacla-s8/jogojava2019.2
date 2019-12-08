package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
	
	private Item item;
	private ArrayList<Item> itens;	
	private int contador;		
	private int missao;	
	
	public ItemManager(Item item) {
		this.item = item;
		itens = new ArrayList<>();			
		missao = 0;
	}
	
	
	
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}	
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void tick() {
		Iterator<Item> iterador = itens.iterator();
		while(iterador.hasNext()) {
			Item i = iterador.next();
			i.tick();
			if(i.isPegou()) {
				iterador.remove();
				if(i.getId() == missao) {
					contador++;
					
					for (Item item : itens) {
						if (item.getId() == missao) {
							return;
						}
					}
					missao++;			
					
				}else {
					contador--;
				}
				
			}
			
			
		}
		
		
	
	}
	
	public void draw(Graphics g) {
		for (Item item : itens) {
			item.draw(g);
			
		}
		
	}
	
	public void addItem(Item it) {
		itens.add(it);

	}

	public int getContador() {
		return contador;
	}

	public int getMissao() {
		return missao;
	}

	public void setMissao(int missao) {
		this.missao = missao;
	}
	
	
	
}
