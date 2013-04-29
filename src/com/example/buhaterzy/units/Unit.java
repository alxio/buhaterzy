package com.example.buhaterzy.units;

public class Unit {
	public static final int
		ID = 0, HP = 1, DMG = 2, RANGE = 3, SPEED = 4, NAME = 5;
	public final int id;
	public final int hp;
	public final int dmg;
	public final int range;
	public final int speed;
	public final int imageId;
	public final String name;
	
	public Unit(String data, int image){
		String lines[] = data.split("\n");
		for(int i=0;i<lines.length;i++){
			lines[i] = lines[i].split(":")[1];
		}
		id = Integer.valueOf(lines[ID]);
		hp = Integer.valueOf(lines[HP]);
		dmg = Integer.valueOf(lines[DMG]);
		range = Integer.valueOf(lines[RANGE]);
		speed = Integer.valueOf(lines[SPEED]);
		name = lines[NAME];
		imageId = image;
	}
}
