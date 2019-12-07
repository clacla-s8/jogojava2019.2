package view;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao extends JButton {
	
	int x, y, largura, altura;

	public Botao(int x, int y, int largura, int altura, String caminho) {
		super();
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
		
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		setIcon(new ImageIcon(getClass().getClassLoader().getResource(caminho)));
		setBounds(x, y, largura, altura);
	}
	
	
	

}
