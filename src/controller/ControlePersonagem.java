package controller;


import model.Fase;
import model.Personagem;


public class ControlePersonagem extends Thread{
	
	private Personagem personagem;	
	protected static String mover = "";
	
		
	public ControlePersonagem(Personagem personagem) {

		this.personagem = personagem;		
		start();
	}	

	@Override
	public void run() {
		while (true) {
			personagem.mover(mover);
			personagem.animar(mover);
			
			try {
				sleep(30);
			} catch (Exception e) {
			}		
			
		}
		
	}
	
	public void mover(Personagem personagem, String direcao)
	{
		if(personagem != null && Fase.colisao != null)
		{
			personagem.mover(direcao);
			personagem.animar(direcao);											
		}
	}	

}

