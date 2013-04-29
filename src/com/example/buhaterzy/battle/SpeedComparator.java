package com.example.buhaterzy.battle;

import java.util.Comparator;

public class SpeedComparator implements Comparator<BattleUnit>{
	@Override
	public int compare(BattleUnit u1, BattleUnit u2) {
		if(u1.getUnit().speed < u2.getUnit().speed) return -1;
		if(u1.getUnit().speed > u2.getUnit().speed) return 1;
		if(u1.getSide() < u2.getSide()) return -1;
		if(u1.getSide() > u2.getSide()) return 1;
		return 0;
	}
}