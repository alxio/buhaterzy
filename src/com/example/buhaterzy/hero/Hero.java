package com.example.buhaterzy.hero;

import com.example.buhaterzy.units.Unit;
import com.example.buhaterzy.units.UnitBuilder;
import com.example.buhaterzy.units.X;

public class Hero {
	private class Squad{
		int count;
		Unit unit;
	}
	
	private Squad[] units = new Squad[4];
	
	public Unit getUnit(int i){
		return units[i].unit;
	}
	
	public int getCount(int i){
		return units[i].count;
	}
	
	public void updateCount(int i, int count){
		units[i].count = count;
	}
	
	
	
	//only for tests
	//hero with 4 troops: a1 alfons, a2 alfons, d1 dziwka, d2 dziwka
	public Hero(int a1, int a2, int d1, int d2){
		for(int i=0;i<4;i++)
			units[i] = new Squad();
		units[0].unit = UnitBuilder.getUnit(X.ALFONS);
		units[1].unit = UnitBuilder.getUnit(X.ALFONS);
		units[2].unit = UnitBuilder.getUnit(X.DZIWKA);
		units[3].unit = UnitBuilder.getUnit(X.DZIWKA);
		units[0].count = a1;
		units[1].count = a2;
		units[2].count = d1;
		units[3].count = d2;
	}
}
