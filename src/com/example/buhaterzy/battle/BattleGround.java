package com.example.buhaterzy.battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.example.buhaterzy.hero.Hero;

public class BattleGround {
	public static final int W = 10;
	public static final int H = 7;   
	public ArrayList<BattleUnit> units;
	private int current = 0;
	
	
	public BattleGround(Hero att, Hero def){
		units = new ArrayList<BattleUnit>();
		for(int i=0;i<4;i++){
			int count = att.getCount(i);
			if(count > 0){
				BattleUnit bu = new BattleUnit(att.getUnit(i), count, i, BattleUnit.ATT);
				units.add(bu);
			}
		}
		for(int i=0;i<4;i++){
			int count = def.getCount(i);
			if(count > 0){
				BattleUnit bu = new BattleUnit(def.getUnit(i), count, i, BattleUnit.DEF);
				units.add(bu);
			}
		}
		Collections.sort(units,new SpeedComparator());
	}
	
	public void attackAction(Position from, Position target){
		move(from);
		BattleUnit attacker = units.get(current);
		BattleUnit defender = findUnit(target);
		int dmg = attacker.getDmg();
		if(defender.takeHit(dmg)){ //defender died
			units.remove(defender);
			updateEnd();
		}
	}
	
	private void updateEnd() {
		// TODO Check if one of army has died
	}
	
	public boolean isEnd(){
		return false;
	}

	public void moveAction(Position dest){
		move(dest);
		current = (current+1)%units.size();
	}
	
	//can not work - check Position.equals()
	private BattleUnit findUnit(Position pos){
		for(BattleUnit bu : units){
			if(bu.getPosition().equals(pos)) return bu;
		}
		return null;
	}
	
	private void move(Position dest){
		BattleUnit u = units.get(current);
		u.setPosition(dest);
	}
	
	//Positive values on map are accessible. -2 on enemy unit u can attack.
	public int[][] getPossibleMoves(){
		int[][] map = new int[W][H];
		BattleUnit u = units.get(current);
		for(BattleUnit bu : units){
			if(bu.getSide() == u.getSide())
				map[bu.getPosition().x][bu.getPosition().y] = -3;
			else
				map[bu.getPosition().x][bu.getPosition().y] = -1;
		}
		int x = u.getPosition().x;
		int y = u.getPosition().y;
		map[x][y] = 1;
		bfs(map, u.getPosition(), u.getSpeed());
		return map;
	}

	private void bfs(int[][] map, Position pos, int range) {
		Queue<Position>q = new LinkedList<Position>();
		q.add(pos);
		while(!q.isEmpty()){
			Position p = q.poll();
			if(map[p.x][p.y] == range) continue;
			
			Position[] neigh = new Position[4];
			neigh[0] = new Position(p.x-1, p.y);
			neigh[1] = new Position(p.x+1, p.y);
			neigh[2] = new Position(p.x, p.y-1);
			neigh[3] = new Position(p.x, p.y+1);
			
			for(Position next : neigh){
				if(!validate(map,next))continue;
				if(map[next.x][next.y] == -1){
					map[next.x][next.y] = -2;
				}
				if(map[next.x][next.y] < 0) continue;
				map[next.x][next.y] = map[p.x][p.y] + 1;
				q.add(next);
			} 
		}
	}

	private boolean validate(int[][] map, Position p) {
		if(p.x < 0) return false;
		if(p.x >= W) return false;
		if(p.y < 0) return false;
		if(p.y >= H) return false;
		return map[p.x][p.y] < 1;
	}
}
