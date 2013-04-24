package com.example.buhaterzy;

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
	
	static String read(int id){
	    try {
	        Resources res = a.getResources();
	        //InputStream in_s = res.openRawResource(R.raw.1);
	        InputStream in_s = null;
	        byte[] b = new byte[in_s.available()];
	        in_s.read(b);
	        return new String(b);
	    } catch (Exception e) {
	        return null;
	    }
	}
}
