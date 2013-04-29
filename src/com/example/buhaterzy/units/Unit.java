package com.example.buhaterzy.units;

import android.util.Log;

public class Unit {
	public static final int
		ID = 0, HP = 1, DMG = 2, RANGE = 3, SPEED = 4, NAME = 5;
	public int id;
	public  int hp;
	public  int dmg;
	public  int range;
	public  int speed;
	public  int imageId;
	public  int imageBig;
	public final String name;
	
	public Unit(String data, int image, int image2){
		String lines[] = data.split("\n");
		for(int i=0;i<lines.length;i++){
			lines[i] = lines[i].split(":")[1];
		}
		
		try{
		id = Integer.parseInt(lines[ID]);
		hp = Integer.parseInt(lines[HP]);
		dmg = Integer.parseInt(lines[DMG]);
		range = Integer.parseInt(lines[RANGE]);
		speed = Integer.parseInt(lines[SPEED]);
		}
		catch( NumberFormatException ex ) {
			Log.e("parseInt",ex.toString());
			Log.e("parseInt",lines[0] + " " + lines[1] + " " + lines[2] + " " + lines[3] + " " + lines[4]);
			id = hp = dmg = range = speed = 1;
		}
		name = lines[NAME];
		imageId = image;
		imageBig = image2;
	}
}
