package com.example.buhaterzy.battle;

import java.util.ArrayList;
import java.util.Collections;

import com.example.buhaterzy.hero.Hero;

public class BattleGround {
	public static final int W = 10;
	public static final int H = 7;
	private ArrayList<BattleUnit> units;
	private int current = 0;
	
	public BattleGround(Hero att, Hero def){
		units = new ArrayList<BattleUnit>();
		for(int i=0;i<4;i++){
			int count = att.getCount(i);
			if(count > 0){
				BattleUnit bu = new BattleUnit(att.getUnit(i), count, i, true);
				units.add(bu);
			}
		}
		for(int i=0;i<4;i++){
			int count = def.getCount(i);
			if(count > 0){
				BattleUnit bu = new BattleUnit(def.getUnit(i), count, i, false);
				units.add(bu);
			}
		}
		Collections.sort(units,new SpeedComparator());
	}
}
