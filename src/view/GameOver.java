package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends Panel{
	
	private BufferedImage back;
	private Botao buttonhome;
	
	
	public GameOver() {
		
		try {
			this.back = ImageIO.read(getClass().getClassLoader().getResource("game-over.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buttonhome = new Botao(330, 350, 90,92, "home.png");
		
		add(buttonhome);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, null);
	}

	public Botao getButtonhome() {
		return buttonhome;
	}

	public BufferedImage getBack() {
		return back;
	}
	
		
	

}
