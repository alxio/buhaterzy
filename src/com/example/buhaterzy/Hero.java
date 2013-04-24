package com.example.buhaterzy;

import java.util.ArrayList;

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
	
	public Hero(int a1, int a2, int d1, int d2){
		units[0].unit = UnitFactory.getUnit(R.raw.alfons, R.drawable.alfons);
		units[1].unit = UnitFactory.getUnit(R.raw.alfons, R.drawable.alfons);
		units[2].unit = UnitFactory.getUnit(R.raw.dziwka, R.drawable.dziwka);
		units[3].unit = UnitFactory.getUnit(R.raw.dziwka, R.drawable.dziwka);
		units[0].count = a1;
		units[1].count = a2;
		units[2].count = d1;
		units[3].count = d2;
	}
}
