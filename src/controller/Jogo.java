package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;

import view.FaseView;

public abstract class Jogo implements Runnable {

	private boolean loop = false;
	private Thread thread;
	
	protected FaseView fase;
	
	protected Graphics2D graficosTela;
	
	public Jogo(FaseView fase) {
		this.fase = fase;
	}
	
	public void run() {

		init();                 
				
		fase.requestFocus();
		graficosTela = fase.getGraficosTela();
		
		
		while(true){
			
			try {
				tick();
				gameDraw();		
				if(loop)
				{
					gameRender();
					draw(graficosTela);
				}
				
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public abstract void draw(Graphics g);
	public abstract void gameRender();
	public abstract void tick();
	public abstract void init();

	private void gameDraw() {
		
		fase.repaint();
	}
	
	public void start()
	{
		if(thread == null)
		{
			thread = new Thread(this);
			thread.start();			
		}
		loop = true;
	}
	
	public void stop()
	{
		loop = false;
	}

}
