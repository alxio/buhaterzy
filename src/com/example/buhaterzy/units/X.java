package com.example.buhaterzy.units;

import com.example.buhaterzy.R;

public class X {
	public int id;
	public int image;
	public int imageBig;
	private X(int id, int image, int imageBig){
		this.id = id;
		this.image = image;
		this.imageBig = imageBig;
	}
	public static final X DZIWKA = new X(R.raw.dziwka,R.drawable.dziwka, R.drawable.dziwka_big);
	public static final X ALFONS = new X(R.raw.alfons,R.drawable.alfons, R.drawable.alfons_big);
}
