package com.example.buhaterzy.units;
import java.util.HashMap;

import com.example.buhaterzy.utils.StringReader;

public class UnitBuilder {
	private static HashMap<Integer,Unit> sUnits = new HashMap<Integer, Unit>();
	public static Unit getUnit(X x){
		Unit u = sUnits.get(x.id);
		if(u != null) return u;
		String data = StringReader.read(x.id);
		u = new Unit(data, x.image, x.imageBig);
		sUnits.put(x.id, u);
		return u;
	}
}