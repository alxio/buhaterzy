package com.example.buhaterzy;
import java.util.HashMap;

public class UnitFactory {
	private static HashMap<Integer,Unit> sUnits;
	public static Unit getUnit(int id, int imageId){
		Unit u = sUnits.get(id);
		if(u != null) return u;
		String data = StringReader.read(id);
		u = new Unit(data, imageId);
		sUnits.put(id, u);
		return u;
	}
}
