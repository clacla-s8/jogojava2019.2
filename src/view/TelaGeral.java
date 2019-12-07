package view;

import javax.swing.JFrame;

public class TelaGeral extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int LARGURA = 800;
	public static final int ALTURA = 500;
	
	public TelaGeral() {
		super("Save the Nature");
		
		setSize(LARGURA, ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
