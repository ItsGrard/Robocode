package prueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSetup;
import robocode.control.RobotSpecification;

public class problema {
	static int obst = 40;
	public static void main(String[] args) {
		int [][] arr;
		
		arr = new int [16][12];
		Random ranF = new Random(16);
		Random ranC = new Random(12);
		
		celda ini = new celda(ranF.nextInt(), ranC.nextInt(), true);
		
		
		ArrayList<celda> mapa = new ArrayList<celda>();
		mapa.add(ini);
		mapa.
	}

}
