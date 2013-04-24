package com.example.buhaterzy.units;

import com.example.buhaterzy.R;

public class X {
	public int id;
	public int image;
	private X(int id, int image){
		this.id = id;
		this.image = image;
	}
	public static final X DZIWKA = new X(R.raw.dziwka,R.drawable.dziwka);
	public static final X ALFONS = new X(R.raw.alfons,R.drawable.alfons);
}
