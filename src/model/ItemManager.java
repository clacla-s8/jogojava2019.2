package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import view.Inventario;

public class ItemManager {
	
	private Item item;
	private ArrayList<Item> itens;	
	private int contador;	
	private Inventario inventario;
	
	
	public ItemManager(Item item) {
		this.item = item;
		itens = new ArrayList<>();	
		
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
				contador++;
				//inventario.setCont(contador);
			}
			
			System.out.println(contador);
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
	
	
}
