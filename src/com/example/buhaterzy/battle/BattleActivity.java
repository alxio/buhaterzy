package com.example.buhaterzy.battle;   

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.buhaterzy.R;
import com.example.buhaterzy.hero.Hero;
 

public class BattleActivity extends Activity implements OnClickListener {
	
	private Button mButtonCast;
	private Button mButtonRun;
	private Button mButtonWait;
	private Button mButtonStats;
	private LinearLayout mBattleLayout;
	private BattleGround mBattleGround;
	
	private ArrayList<ArrayList<FieldButton>> mFields;
	
	@Override
	public void onClick(View v){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    LayoutInflater inflater = getLayoutInflater();
	    View alertView = inflater.inflate(R.layout.stats_layout, null);
	    
		BattleUnit bu = mBattleGround.getCurrentUnit();
		((TextView)alertView.findViewById(R.id.count)).setText(""+bu.getCount());
		((TextView)alertView.findViewById(R.id.hp)).setText(""+bu.getUnit().hp);
		((TextView)alertView.findViewById(R.id.left)).setText(""+bu.getHp());
		((TextView)alertView.findViewById(R.id.dmg)).setText(""+bu.getUnit().dmg);
		((TextView)alertView.findViewById(R.id.speed)).setText(""+bu.getUnit().speed);
	    ((ImageView)alertView.findViewById(R.id.image)).setImageResource(bu.getUnit().imageBig);
	    builder.setView(alertView);
		AlertDialog alertDialog = builder.create();
		alertDialog.setTitle(bu.getUnit().name); 		
		alertDialog.show();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battle);
		initButtons();
		createBattleField();
		runBattle();
	}
	
	private void initButtons() {
		mButtonCast = (Button)findViewById(R.id.battle_button_cast);
		mButtonRun = (Button)findViewById(R.id.battle_button_run);
		mButtonWait = (Button)findViewById(R.id.battle_button_wait);
		mButtonStats = (Button)findViewById(R.id.battle_button_stats); 
		mButtonCast.setOnClickListener(this);
	}
	private void createBattleField() {
		mBattleLayout = (LinearLayout)findViewById(R.id.battle_grid);
		mFields = new ArrayList<ArrayList<FieldButton>>();
		for(int i=0;i<BattleGround.W;i++){
			LinearLayout column = new LinearLayout(this);
			column.setOrientation(LinearLayout.VERTICAL);
			ArrayList<FieldButton> list = new ArrayList<FieldButton>();
			for(int j=0;j<BattleGround.H;j++){
				FieldButton b = new FieldButton(this,i,j);
				column.addView(b);
				list.add(b);
			}
			mBattleLayout.addView(column);
			mFields.add(list);
		}
	}
	
	private void nextTurn(){
		for(ArrayList<FieldButton>a : mFields)
			for(FieldButton fb : a)
				fb.setImageResource(android.R.color.transparent);
		 
		for(BattleUnit u : mBattleGround.units){
			Position p = u.getPosition();
			mFields.get(p.x).get(p.y).setImageResource(u.getUnit().imageId);
		}
		int[][] moves = mBattleGround.getPossibleMoves();
		for(int i=0;i<moves.length;i++)
			for(int j=0;j<moves[i].length;j++){
				int move = moves[i][j];
				int status = FieldButton.NORMAL;  
				if(move == -2) status = FieldButton.ATTACKABLE;
				if(move == 1) status = FieldButton.CURRENT;;
				if(move > 1) status = FieldButton.AVAIBLE;
				mFields.get(i).get(j).setState(status);
			}
	}
	
	private void runBattle(){
		Hero h1 = new Hero(1,2,3,4);
		Hero h2 = new Hero(4,3,2,1);
		mBattleGround = new BattleGround(h1, h2);
		nextTurn();
	}

	public void buttonClicked(int x, int y, int state) {
		Log.i("Button Clicked","X: " + x + " Y: " + y);
		if(state == FieldButton.AVAIBLE){
			mBattleGround.moveAction(new Position(x, y));
			nextTurn();
		}
	}
}
