package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

public class Personagem extends Elemento{ 

	private static int VELOCIDADE = 3;

	public Personagem(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);

	}

	@Override
	public void animar(String direcao) {

		if(!direcao.equals(""))
			setAparencia(getAparencia() + 1);

		if(direcao == "cima")
		{
			if(getAparencia() > 8 || getAparencia()< 6) // numero referente a posição da imagem da sprite na matriz
				setAparencia(6);
		}
		if(direcao == "baixo")
		{
			if(getAparencia() > 2)
				setAparencia(0);
		}
		if(direcao == "direita")
		{
			if(getAparencia() > 5 || getAparencia() < 3)
				setAparencia(3);
		}
		if(direcao == "esquerda")
		{
			if(getAparencia() > 11 || getAparencia() < 9)
				setAparencia(9);
		}

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), getLarguraPersonagem(), getAlturaPersonagem(), null);
		
	}

	@Override
	public void mover(String direcao) {		
		
		if(direcao == "cima")
		{
			if(getY() > 0)
			setY((getY() - VELOCIDADE));
		}
		if(direcao == "baixo")
		{
			if(getY() < 946 )
			setY((getY() + VELOCIDADE));
		}
		if(direcao == "direita")
		{
			if(getX() < 784 )
			setX((getX() + VELOCIDADE));
			
		}
		if(direcao == "esquerda")
		{	
			if(getX() > 0)
			setX((getX() - VELOCIDADE));
		}		

	}

	public boolean collision(List<Rectangle> tmp, int x,int y) {

		Rectangle personagem = new Rectangle(getX()+x+10, getY()+y+10, 
				getLarguraPersonagem()-10, getAlturaPersonagem()-10);
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(personagem)){
				return true;
			}
		}
		return false;
	}



	@Override
	public void setX(int x) {
		if(!collision(Fase.colisao, x-getX(), 0))
			super.setX(x);//this.x = x;

	}

	@Override
	public void setY(int y) {
		if(!collision(Fase.colisao, 0, y-getY()))
			super.setY(y);//this.y = y;
	}


}
