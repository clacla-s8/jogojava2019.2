package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class TileMap { 

	private int mapaAltura;	
	private int mapaLargura;	
	private int tileSize;	
	private int camada[][];	
	private int larguraTela;	
	private int AlturaTela;

	private BufferedImage tileSet;
	private BufferedImage mapa;

	private Graphics2D dbg;

	public TileMap(int mapaLargura, int mapaAltura, int tileSize, String nomeTileSet, String nomeMapaMatriz) {

		this.mapaLargura = mapaLargura;
		this.mapaAltura = mapaAltura;
		this.tileSize = tileSize;

		larguraTela = mapaLargura * tileSize;
		AlturaTela = mapaAltura * tileSize;

		mapa = new BufferedImage(larguraTela, AlturaTela, BufferedImage.TYPE_4BYTE_ABGR);
		dbg = mapa.createGraphics();

		try {
			tileSet=ImageIO.read(getClass().getClassLoader().getResourceAsStream(nomeTileSet));
		} catch (IOException e) {
			System.out.println("Não conseguiu ler o Tileset");
			e.printStackTrace();
		}

		camada = carregarMatriz(nomeMapaMatriz);
		montarMapa();

	}
	public void montarMapa() {

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileSize;

		for (int i = 0; i < mapaLargura; i++) {
			for (int j = 0; j < mapaAltura; j++) {
				tile = (camada[i][j] != 0) ? (camada[i][j] - 1) : 0;
				tileRow = (tile / colunasTileSet) | 0;
				tileCol = (tile % colunasTileSet) | 0;
				dbg.drawImage(tileSet, (j * tileSize), (i * tileSize), (j * tileSize) + tileSize,
						(i * tileSize) + tileSize, (tileCol * tileSize), (tileRow * tileSize),
						(tileCol * tileSize) + tileSize, (tileRow * tileSize) + tileSize, null);

			}
		}
	}

	public List<Rectangle> montarColisao() {
		List<Rectangle> tmp = new ArrayList<Rectangle>();
		for (int i = 0; i < mapaLargura; i++) {
			for (int j = 0; j < mapaAltura; j++) {
				if(camada[i][j] != 0) {
					tmp.add(new Rectangle( (j * tileSize), (i * tileSize), tileSize, tileSize));
				}		
			}
		}
		return tmp;
	}

	public int[][] carregarMatriz(String nomeMapa) {
		int[][] matz = new int[mapaLargura][mapaAltura];

		InputStream input = getClass().getClassLoader().getResourceAsStream(nomeMapa);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		List<String> linhas = new ArrayList<String>();
		String linha = "";

		try {
			while ((linha = br.readLine()) != null)
				linhas.add(linha);

			int coluna = 0;
			for (int i = 0; i < linhas.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhas.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][coluna] = Integer.parseInt(token.nextToken());
					coluna++;
				}
				coluna = 0;
			}

		} catch (IOException e) {
			System.out.println("Não carregou Matriz");
			e.printStackTrace();
		}

		return matz;
	}


	public BufferedImage getMapa() {
		return mapa;
	}
	public int getLarguraTela() {
		return larguraTela;
	}
	public int getAlturaTela() {
		return AlturaTela;
	}

}

