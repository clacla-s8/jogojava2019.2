package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Elemento {
	private int larguraPersonagem, alturaPersonagem;

	protected BufferedImage personagem;
	protected int largura, altura;
	protected int linhas, colunas; // manipular array da sprite
	private int x, y; // posi��o do elemento no mapa
	private BufferedImage[] sprites;
	private int aparencia; // manipular array da sprite

	protected Elemento(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) throws IOException {

		try {

			this.personagem = ImageIO.read(getClass().getClassLoader().getResourceAsStream(endereco));
			this.aparencia = aparencia;
			this.largura = largura;
			this.altura = altura;

			this.linhas = colunas;
			this.colunas = linhas;
			this.x = x;
			this.y = y;

			sprites = new BufferedImage[colunas * linhas];

			for (int i = 0; i < linhas; i++) { // percorrendo a matriz da sprite todas as linhas primeiro e depois passa p coluna
				for (int j = 0; j < colunas; j++) {					

					sprites[(i * colunas) + j] = personagem.getSubimage(j * (largura / colunas),
							i * (altura / linhas), largura / colunas, altura / linhas);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar a Sprite");
		}

		larguraPersonagem = sprites[0].getWidth();
		alturaPersonagem = sprites[0].getHeight();
	}

	public abstract void animar(String direcao);

	public abstract void draw(Graphics g);

	public abstract void mover(String direcao);

	public void setLocale(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public BufferedImage getPersonagem() {
		return personagem;
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

	public int getAparencia() {
		return aparencia;
	}

	public void setAparencia(int aparencia) {
		this.aparencia = aparencia;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public int getLarguraPersonagem() {
		return larguraPersonagem;
	}

	public int getAlturaPersonagem() {
		return alturaPersonagem;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x, y, larguraPersonagem, alturaPersonagem);
	}

}
