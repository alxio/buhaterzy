package com.example.buhaterzy.utils;

import java.io.InputStream;

import android.app.Activity;
import android.content.res.Resources;

public class StringReader {
	private static Activity a;
	
	public static boolean setActivity(Activity act){
		if(a == null){
			a = act;
			return true;
		}
		return false;
	}
	
	public static String read(int id){
	    try {
	        Resources res = a.getResources();
	        InputStream in_s = res.openRawResource(id);
	        byte[] b = new byte[in_s.available()];
	        in_s.read(b);
	        return new String(b);
	    } catch (Exception e) {
	        return "ID:1\nHP:10\nDMG:2\nRANGE:3\nSPEED:10\nNAME:Dziwka;\n"; 
	    }
	}
}
