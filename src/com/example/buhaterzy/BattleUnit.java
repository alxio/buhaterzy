package com.example.buhaterzy;

import java.util.Comparator;

public class BattleUnit {
	private Unit mUnit;
	private int mCount;
	private Position mPosition;
	private boolean mSide; //true if attacker
	private int mHp;
	
	public BattleUnit(Unit u, int count, int slot, boolean side){
		mUnit = u;
		mCount = count;
		mSide = side;
		mPosition = new Position();
		mPosition.x = side?0:10;
		mPosition.y = 2*slot;
		mHp = u.hp;
	}
	
	//return if unit died
	public boolean takeHit(int damage){
		int dead = damage/mUnit.hp;
		int rest = damage%mUnit.hp;
		if(mHp <= rest) dead++;
		mHp = (mUnit.hp + mHp - rest - 1) % mUnit.hp + 1;
		mCount -= dead;
		if(mCount < 0) mCount = 0;
		return mCount == 0;
	}
	
	public int getDmg(){
		return mCount*mUnit.dmg;
	}
	
	public int getSpeed(){
		return mUnit.speed;
	}
	
	public int getRange(){
		return mUnit.range;
	}
	
	public boolean getSide(){
		return mSide;
	}
	
	public Position getPosition(){
		return new Position(mPosition);
	}
	
	public void move(Position p){
		mPosition = new Position(p);
	}
}
