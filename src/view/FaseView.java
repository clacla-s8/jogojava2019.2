package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class FaseView extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private BufferedImage imagemTela;
	private Graphics2D graficosTela;

	public FaseView() {
		requestFocus();
		imagemTela = new BufferedImage(TelaGeral.LARGURA, TelaGeral.ALTURA, BufferedImage.TYPE_4BYTE_ABGR);
		graficosTela = (Graphics2D) imagemTela.getGraphics();
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) { //metodo responsavel por pintar os componentes da tela 

		g.drawImage(imagemTela, 0, 0, null);//pinto o "plano de fundo"em baixo de todos os componentes 

	}

	

	/**
	 * @return o imagemTela
	 */
	public BufferedImage getImagemTela() {
		return imagemTela;
	}

	/**
	 * @return o graficosTela
	 */
	public Graphics2D getGraficosTela() {
		return graficosTela;
	}


}




