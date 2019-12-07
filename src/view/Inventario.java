package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inventario extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Botao voltar;
	private int itensPegos;
	private int pontuacao;
	private BufferedImage background;
	
	private int cont;
	
	
	public Inventario() {
		
		try {
			this.background = ImageIO.read(getClass().getClassLoader().getResource("fundoInventario.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		voltar = new Botao(50, 350, 91,92 , "home.png");
		add(voltar);
		
		setVisible(true);		
		
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0,null);
		g.drawString("Itens: "+ itensPegos, 40, 50);
		
	}

	public Botao getVoltar() {
		return voltar;
	}

	public int getItensPegos() {
		return itensPegos;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	
	

}
