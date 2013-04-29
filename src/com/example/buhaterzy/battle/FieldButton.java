package com.example.buhaterzy.battle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.buhaterzy.R;

public class FieldButton extends ImageButton implements OnClickListener{
	public static final int NORMAL = 0;
	public static final int AVAIBLE = 1;
	public static final int ATTACKABLE = 2;
	public static final int CURRENT = 3;
	private int state = 0;
	private int x;
	private int y;
	private BattleActivity host;
	public FieldButton(BattleActivity context, int x, int y) {
		super(context);
		this.x = x;
		this.y = y;
		host = context;
		setOnClickListener(this);
		setBackgroundResource(R.drawable.border);
		setMinimumHeight(64);
		setMinimumWidth(64);
		setMaxHeight(64);
		setMaxWidth(64);
	}
	public void setState(int newState){
		if(state == newState)return;
		state = newState;
		switch(state){
		case NORMAL:
			setBackgroundResource(R.drawable.border);
			break;
		case AVAIBLE:
			setBackgroundResource(R.drawable.field);
			break;
		case ATTACKABLE:
			setBackgroundResource(R.drawable.red_field);
			break;
		case CURRENT:
			setBackgroundResource(R.drawable.green_field); 
			break;
		}
	}
	
	@Override
	public void onClick(View v) {
		host.buttonClicked(x,y,state);
	}
}
