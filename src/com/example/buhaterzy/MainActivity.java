package com.example.buhaterzy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.buhaterzy.battle.BattleActivity;
import com.example.buhaterzy.utils.StringReader;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StringReader.setActivity(this);
		
		Button b = (Button)findViewById(R.id.start_battle);
	    b.setOnClickListener(new OnClickListener() 
	    {   public void onClick(View v) 
	        {   
	            Intent intent = new Intent(MainActivity.this, BattleActivity.class);
	            startActivity(intent);      
	            finish();
	        }   
	    });
		
		
		
		
		
		
	}
	
	
	
	
}
