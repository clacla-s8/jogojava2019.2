package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class Menu extends Panel {
	
	private Botao buttonJogar, buttonSair;
	private BufferedImage fundo;
	
	public Menu() {
		
		try {
			this.fundo = ImageIO.read(getClass().getClassLoader().getResource("backgroundMenu.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		buttonJogar = new Botao(310, 350, 90,92, "play.png");
		buttonSair = new Botao(425, 350, 90, 92, "sair.png");
		
		add(buttonJogar);
		add(buttonSair);		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(fundo, 0, 0, null);
	}

	public Botao getButtonJogar() {
		return buttonJogar;
	}

	public Botao getButtonSair() {
		return buttonSair;
	}
	
	

}
