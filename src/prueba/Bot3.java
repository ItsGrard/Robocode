package prueba;


import static robocode.util.Utils.normalRelativeAngleDegrees;


import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import javax.management.RuntimeErrorException;
import javax.security.auth.x500.X500Principal;

import prueba.Bot3.Posicion;
import robocode.Robot;

/**
 * 
 */

/**
 * @date 2018-03-22
 * 
 * Plantilla para la definici�n de un robot en Robocode
 *
 */
public class Bot3 extends Robot {
	public Posicion arbol;
	public Problema problema;
	public PriorityQueue<Posicion> abiertos;
	public PriorityQueue<Posicion> cerrados;
	public Posicion posFinal;
	//The main method in every robot
	public void run() {
		

		System.out.println("Iniciando ejecuci�n del robot");
		
		// Nuestro robot ser� rojo
		setAllColors(Color.red);

		//DATOS QUE DEBEN COINCIDIR CON LOS DEL PROGRAMA main DE LA CLASE RouteFinder
		long semilla = 0;
		int nFil = 16;
		int nCol = 12;
		int nObst = 40;
		int tamCelda = 50;
		
		//Orientamos inicialmente el robot hacia arriba
		turnRight(normalRelativeAngleDegrees(0 - getHeading()));
		
		//A continuaci�n nuestro robot girar� un poco sobre s� mismo		
		int k = 0;
		while(k < 20){
			turnRight(90);
			k++;
		}
		
		System.out.println("Posicion inicial : " + problema.getNColIni() + "," + problema.getNFilIni() + " Posicion final : " + problema.getNColFin() + "," + problema.getNFilFin());
		
		// AQU� DEBE:
		//  1. GENERARSE EL PROBLEMA DE B�SQUEDA
		//  2. BUSCAR LA SOLUCI�N CON UN ALGORITMO DE B�SQUEDA
		//  3. EJECUTAR LA SOLUCI�N ENCONTRADA
		

		
		
		abiertos= new PriorityQueue<>();
		cerrados= new PriorityQueue<>();
		problema=new Problema(nFil,nCol,tamCelda,nObst,semilla);
		arbol = new Posicion[nFil*nCol];

		posFinal= new Posicion(null, problema.getNFilFin(), problema.getNColFin(),null);
		posFinal.SetdistMan(0.0);
		Posicion posactual = new Posicion(null, problema.getNColIni(), problema.getNFilIni(),posFinal);
		
		abiertos.add(posactual);
		//djikstra(abiertos,cerrados,posactual,posFinal);
		while(posactual.getPosX()!=problema.getNFilFin() || posactual.getPosY()!=problema.getNColFin()) {
			if(abiertos.isEmpty()) {
				throw new RuntimeException("FRACASO");
			}
			posactual=abiertos.poll();
			cerrados.add(posactual);

			if(posactual.distMan==0.0) {
				int cont=0;
				while(posactual.padre!=null) {
					arbol[cont]= posactual;
					cont++;
					posactual=posactual.padre;
				}
			}else {
			
				if((posactual.posX-1>=0) && (problema.getMalla()[posactual.posX-1][posactual.getPosY()]!=1)) {
					Posicion posHijo = new Posicion(posactual, posactual.posX-1, posactual.posY, posFinal);
					if(!abiertos.contains(posHijo)) {
						if(!cerrados.contains(posHijo)) {
							abiertos.add(posHijo);
						}else {
							cerrados.add(posHijo);
						}
					}
				}
				if((posactual.posY-1>=0) && (problema.getMalla()[posactual.posX][posactual.getPosY()-1]!=1)) {
					Posicion posHijo = new Posicion(posactual, posactual.posX, posactual.posY-1, posFinal);
					if(!abiertos.contains(posHijo)) {
						if(!cerrados.contains(posHijo)) {
							abiertos.add(posHijo);
						}else {
							cerrados.add(posHijo);
						}
					}
				}
				if((posactual.posX+1<problema.getnCol()) && (problema.getMalla()[posactual.posX+1][posactual.getPosY()]!=1)) {
					Posicion posHijo = new Posicion(posactual, posactual.posX+1, posactual.posY, posFinal);
					if(!abiertos.contains(posHijo)) {
						if(!cerrados.contains(posHijo)) {
							abiertos.add(posHijo);
						}else {
							cerrados.add(posHijo);
						}
					}
				}
				if((posactual.posY+1<problema.getnFil()) && (problema.getMalla()[posactual.getPosX()][posactual.getPosY()+1]!=1)) {
					Posicion posHijo = new Posicion(posactual, posactual.posX, posactual.posY+1, posFinal);
					if(!abiertos.contains(posHijo)) {
						if(!cerrados.contains(posHijo)) {
							abiertos.add(posHijo);
						}else {
							cerrados.add(posHijo);
						}
					}
				}
			
			}
			
		}
		
		int cont = 0;
		arbol= ordenararbol(arbol,cont );
		// Ahora que el arbol esta ordenado, hay que hacer que el robot se mueva;
		posactual = new Posicion(null, problema.getNColIni(), problema.getNFilIni(),posFinal);
		while(!posactual.equals(posFinal)) {
			//mover el robot;
		}
		
		/*
		
		
		int n=0;
		int padre=0;
		int fin=0;
		posFinal= new Posicion(null, problema.getNFilFin(), problema.getNColFin(),null);
		posFinal.SetdistMan(0.0);
		Posicion[] abierto = new Posicion[problema.getnCol()*problema.getnFil()];
		abierto[0]= new Posicion(null,problema.getNFilIni(),problema.getNColIni(),posFinal);
		Posicion[] finall = new Posicion[problema.getnCol()*problema.getnFil()]; 
		
		while(!(abierto[n].posX==abierto[padre].posX)&&(abierto[n].posY==abierto[padre].posY)) {
			a�adirIzq();
			a�adirDer();
			a�adirArr();
			a�adirAba();
			padre++;
		}
	//	terminar(abierto,finall,padre,fin);
	}

	private void terminar(Posicion[] abierto,Posicion[] finall,int padre,int fin) {
		if(abierto[padre].getPadre()!=null) {
			finall[fin]=abierto[padre];
			fin++;
			terminar(abierto[padre].getPadre());
		}
		else {
			finall[fin]=abierto[padre];
			
			//invertir array
		}
	}      EL TERMINAR NO FURULA


	private void a�adirAba() {
		// TODO Auto-generated method stub
		
	}

	private void a�adirArr() {
		// TODO Auto-generated method stub
		
	}

	private void a�adirIzq() {
		// TODO Auto-generated method stub
		
	}

	private void a�adirDer() {
		// TODO Auto-generated method stub
		
	}
	
	*/

}

	private Posicion ordenararbol(Posicion arbol2,int cont) {
		Posicion  aux=new Posicion(arbol2,cont);
		
		for(int c=0;c<cont; c++) {
			aux =arbol2[cont-c-1];
		}
		return aux;
	}
	private void moverAba(double tamCelda) {
		back(tamCelda);
		
	}

	private void moverArr(double tamCelda) {
		ahead(tamCelda);
		
	}

	private void moverDer(double tamCelda) {
		turnRight(90);
		ahead(tamCelda);
	}

	private void moverIzq(double tamCelda) {
		turnLeft(90);
		ahead(tamCelda);
		
	}

class Posicion{
	Posicion padre;
	int posX;
	int posY;
	double distMan;
	public Posicion(Posicion pad,int x, int y,Posicion posFinal) {
		padre=pad;
		posX=x;
		posY=y;
		distMan= distManhattan(x,y,posFinal.posX,posFinal.posY);
	}
	public Posicion(Posicion[] arbol, int cont) {
		// TODO Auto-generated constructor stub
	}
	public Posicion getPadre() {
		return padre;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public double distManhattan(int posXAc,int posYAc, int posXFi,int posYFi) {
		return 	Math.abs(posXFi - posXAc) + Math.abs(posYFi - posYAc);
	}
	public void SetdistMan(double num) {
		distMan=num;
	}
	public boolean equals(Object o) {
		if(o instanceof Posicion) {
			Posicion pos= (Posicion) o;
			return (posX==pos.posX) && (posY==pos.posY);
		}
		return false;
	}
	public int hashCode() {
		return posX+ posY;
	}		

}
}