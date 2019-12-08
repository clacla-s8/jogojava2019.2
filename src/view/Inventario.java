package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Fase;
import model.Item;
import model.ItemManager;

public class Inventario extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Botao voltar;	
	private int pontuacao;
	private BufferedImage background;
	private String missao = "";	
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
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Pontuação: "+ cont*10, 40, 50);
		g.drawString(missao, 30, 150);
		
		
	}

	public Botao getVoltar() {
		return voltar;
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



	public String getMissao() {
		return missao;
	}



	public void setMissao(int missao) {
		
		switch (missao) {
		case 0:
			this.missao = "Colete Papel";			
			break;
		case 1:
			this.missao = "Colete Metal";			
			break;
		case 2:
			this.missao = "Colete Plastico";			
			break;
		case 3:
			this.missao = "Colete Vidro";			
			break;

		default:
			break;
		}
		
	}
	
	
	

}
