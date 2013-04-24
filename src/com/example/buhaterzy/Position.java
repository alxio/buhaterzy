package com.example.buhaterzy;

public class Position {
	public int x;
	public int y;
	
	public Position(){
		x = y = -1;
	}
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Position(Position p){
		x = p.x;
		y = p.y;
	}
}
