package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao extends JButton {
	
	private int x, y, largura, altura;

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

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	
	

}
