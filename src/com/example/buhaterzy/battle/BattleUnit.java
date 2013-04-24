package com.example.buhaterzy.battle;

import com.example.buhaterzy.units.Unit;

public class BattleUnit {
	private Unit mUnit;
	private int mCount;
	private Position mPosition;
	private int mSide; //ATT or DEF
	private int mHp;
	
	public static final int ATT = 0;
	public static final int DEF = 1;
	
	public BattleUnit(Unit u, int count, int slot, int side){
		mUnit = u;
		mCount = count;
		mSide = side;
		mPosition = new Position();
		mPosition.x = (side == ATT)?0:10;
		mPosition.y = 2*slot;
		mHp = u.hp;
	}
	
	/**
	 * @return if unit died
	 */
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
	
	public int getSide(){
		return mSide;
	}
	
	public Position getPosition(){
		return new Position(mPosition);
	}
	
	public void setPosition(Position pos){
		mPosition = pos;
	}
	
	public void move(Position p){
		mPosition = new Position(p);
	}
}
