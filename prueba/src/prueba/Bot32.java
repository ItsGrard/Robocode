package prueba;

import static robocode.util.Utils.normalRelativeAngleDegrees;


import java.awt.Color;

import robocode.Robot;

/**
 * 
 */

/**
 * @date 2018-03-22
 * 
 * Plantilla para la definiciÃ³n de un robot en Robocode
 *
 */
public class Bot3 extends Robot {

	//The main method in every robot
	public void run() {
		

		System.out.println("Iniciando ejecuciÃ³n del robot");
		
		// Nuestro robot serÃ¡ rojo
		setAllColors(Color.red);

		//DATOS QUE DEBEN COINCIDIR CON LOS DEL PROGRAMA main DE LA CLASE RouteFinder
		long semilla = RouteFinder.sem;
		int nFil = 16;
		int nCol = 12;
		int nObst = 40;
		int tamCelda = 50;
		
		//Orientamos inicialmente el robot hacia arriba
		turnRight(normalRelativeAngleDegrees(0 - getHeading()));
		
		//A continuaciÃ³n nuestro robot girarÃ¡ un poco sobre sÃ­ mismo		
		int k = 0;
		while(k < 20){
			turnRight(90);
			k++;
		}
		
		
		// AQUÃ� DEBE:
		//  1. GENERARSE EL PROBLEMA DE BÃšSQUEDA
		//  2. BUSCAR LA SOLUCIÃ“N CON UN ALGORITMO DE BÃšSQUEDA
		//  3. EJECUTAR LA SOLUCIÃ“N ENCONTRADA
			
	}
	
	
}
