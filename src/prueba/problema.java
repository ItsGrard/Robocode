package prueba;

import java.util.Random;

public class Problema {
	private int numPixelFila;
	private int numPixelCol;
	private int tamCelda; 
	private int numObstaculos;
	private Random rnd;
	private long semilla;  
	private int nFil = numPixelFila / tamCelda;
	private int nCol = numPixelCol  / tamCelda;
	private int[][]malla;
	
	private int NFilIni;
	private int NColIni;
	
	private int NFilFin;
	private int NColFin;
	


	public Problema(int nPixelF,int nPixelC,int tamc,int nObs,long sem) {
		numPixelFila=nPixelF;
		numPixelCol=nPixelC;
		tamCelda=tamc;
		numObstaculos=nObs;
		semilla=sem;
		
		Random rnd= new Random();
		rnd.setSeed(semilla);
		
		int nFil = numPixelFila / tamCelda;
		int nCol = numPixelCol  / tamCelda;
		
		int[][] malla = new int[nFil][nCol];

		int x = rnd.nextInt(nFil);
		int y = rnd.nextInt(nCol);
		
		int numObs=0;
		while(numObs<numObstaculos) {
			x = rnd.nextInt(nFil);
			y = rnd.nextInt(nCol);
			
			if(malla[x][y] !=1) {
				malla[x][y]=1;
				numObs++;
			}
		}
		

		
		do {
			NFilFin= rnd.nextInt(nFil);
			NColFin= rnd.nextInt(nCol);
		}while(malla[NFilFin][NColFin]==1);


		do {
		NFilIni= rnd.nextInt(nFil);
		NColIni= rnd.nextInt(nCol);
		}while(malla[NFilIni][NColIni]==1);
		malla[NFilIni][NColIni]=2;
	}

	public int getnFil() {
		return nFil;
	}

	public int getnCol() {
		return nCol;
	}

	public int getNFilIni() {
		return NFilIni;
	}

	public int getNColIni() {
		return NColIni;
	}

	public int getNFilFin() {
		return NFilFin;
	}

	public int getNColFin() {
		return NColFin;
	}
	public int[][] getMalla() {
		return malla;
	}
	
}
