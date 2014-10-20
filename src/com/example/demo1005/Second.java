package com.example.demo1005;

//import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends ActionBarActivity implements 
		OnItemClickListener,
		OnItemLongClickListener,
		OnClickListener,
		OnLongClickListener
		{
	ArrayAdapter<String>  cc;
		TextView tv1;
		String[] foodAndRecord;
		String[] menu;
		Intent it2 ;
		ListView lv1;
		Button bt1,bt2;	
		Toast tos;
		
		int times=0;
		int sum;
		//ArrayList<String> had = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		it2 = getIntent();
		sum = it2.getIntExtra("sum", sum);
		foodAndRecord = it2.getStringArrayExtra("food");
		int foodAndRecordLength = foodAndRecord.length;
		//int[] record = new int[foodAndRecordLength/2];
		String[] mainFood= new String[foodAndRecordLength/2];
		menu = it2.getStringArrayExtra("menu");		
		bt2 = (Button)findViewById(R.id.button2);
		bt1 = (Button)findViewById(R.id.button1);
		lv1 = (ListView)findViewById(R.id.listView1);
		tv1 =  (TextView)findViewById(R.id.textView1);
		/*for(int ci=0 ; ci < foodAndRecordLength; ci++)
		{
			if(ci%2==0)
			{
				mainFood[ci/2]=foodAndRecord[ci];				
			}
			/*else
			{
				//record[fat]=foodAndRecord[ci];
			}
		}*/
		cc = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
				foodAndRecord);
		
        tv1.setText("總計: "+sum+"元");
        bt1.setOnClickListener(this); 
        bt2.setOnClickListener(this); 

   		lv1.setAdapter(cc);
   		lv1.setOnItemClickListener(this);
   		lv1.setOnItemLongClickListener(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		}

	@Override
	public boolean onLongClick(View v) {
		
		return false;
	}
	@Override
	public void onClick(View v) {
		/*if(v.getId()== R.id.button2)
		{
				if( record[1] > 0 && record[4] > 0 && times == 0)
				{
					++times;
					
					sum=sum-500*((record[1]<=record[4]) ? record[1]:record[4]);
					
					Toast.makeText(this,"龍膽 , 沙龍 的 海龍套餐"+"x"+((record[1]<=record[4]) ? record[1]:record[4]),Toast.LENGTH_LONG).show();
					
						/*record[1]=record[1]-1;
						record[4]=record[4]-1;
						record=new int[record.length+1];
						record[record.length-1]=1;
						menu=new String[menu.length+1];
						menu[menu.length-1]="海龍套餐";*/
			/*	}
		}		
		else
		{			
			finish();
		}
        tv1.setText("總計: "+sum+"元");*/
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		
		// SelectedItem();

		return false;
	}
}
