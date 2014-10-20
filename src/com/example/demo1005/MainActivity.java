package com.example.demo1005;

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


public class MainActivity extends ActionBarActivity implements 
		OnItemClickListener,
		OnItemLongClickListener,
		OnClickListener,
		OnLongClickListener
{

	TextView tv2,tv4;
	Button bt1,bt2,bt3;
	ListView lv1;	
	String[] menu ={"���n��l��","�s�x���u����","�z�[���B�����K��","���s�u�û]Ţ","Ĩۣ�z�F�s","�{�ߩ�����L��","�U�����J��"};
	int menuLength =  menu.length;
	//String[] mainFood=new String[menu.length];
	String msg;
	int[] rc = {0,0,0,0,0,0,0};
	int[] price = {100,200,300,400,500,600,700};
	int sum=0;
	int times=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       ArrayAdapter<String>  aa = new ArrayAdapter<String>(this,
    		   android.R.layout.simple_list_item_1,
    		   	menu);
       
        tv2 = (TextView)findViewById(R.id.textView2);
        tv4 = (TextView)findViewById(R.id.textView4);
        bt1 = (Button)findViewById(R.id.button1);
        bt2 = (Button)findViewById(R.id.button2);
        bt3 = (Button)findViewById(R.id.button3);
        lv1 = (ListView)findViewById(R.id.listView1);
        
        lv1.setAdapter(aa);
        lv1.setOnItemClickListener(this);
        lv1.setOnItemLongClickListener(this);
        bt1.setOnClickListener(this); 
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        tv4.setOnLongClickListener(this);
 }
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.main, menu);
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
		
		rc[position]=rc[position]+1;
		sum=sum+price[position];
		tv2.setText("�`�p : "+sum+"��");
		msg="";
		
		for(int i=0 ; i<menuLength ; i++)
		{
			int num =rc[i];
			
			if( num > 0)
			{
				msg =msg+menu[i]+"x"+ num +"\n";
				
			}
		}
		
		tv4.setText("Total : \n"+msg);
	}
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		
		if(rc[position] > 0)
		{
			rc[position]=rc[position]-1;
			sum=sum-price[position];
			tv2.setText("�`�p : "+sum+"��");
			msg="";
			
			for(int i=0 ; i<menuLength ; i++)
			{	
				int num =rc[i];
				
				if( num > 0)
				{
					msg =msg+menu[i]+"x"+ num +"\n";
				}				
			}
			
			tv4.setText("Total : \n"+msg);
		}
		return true;
	}
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
			// 	�e�X�s
			case R.id.button1:
				
				//�N�M�檺�����M�ƶq �N�JfoodAndRecord�̨æV�U��
				String[] sa = msg.split("\n");
				String[] foodAndRecord = new String[sa.length*2];
				String saSpilitx="";
				int length = sa.length;
				
				for(int t = 0 ; t< length ; t++ )
				{
					saSpilitx=saSpilitx+sa[t]+"x";
				}
				foodAndRecord=saSpilitx.split("x");
				// �ǤJ it ��				
				if(sum > 0)
				{
					Intent it =new Intent(this , Second.class);	
					
					it.putExtra("sum", sum);
					it.putExtra("food",foodAndRecord);
					it.putExtra("many", rc);
					it.putExtra("menu",menu);
					startActivity(it);
				}
				
				break;
				
			// 	�M�\�ɯ�	
			case R.id.button2:
				
				if( rc[1] > 0 && rc[4] > 0 && times == 0)
				{
					++times;
					
					sum=sum-500*((rc[1]<=rc[4]) ? rc[1]:rc[4]);
					
					Toast.makeText(this,"�s�x , �F�s �� ���s�M�\"+"x"+((rc[1]<=rc[4]) ? rc[1]:rc[4]),Toast.LENGTH_LONG).show();
					
					tv2.setText("�`�p : "+sum+"��");
				}	
				
				break;
				
			//	�M�� Clear	
			case R.id.button3:
				
				for(int z=0;z< menu.length;z++)
				{
					rc[z]=0;
				}
				times=0;
				msg= "Total : ";
				tv4.setText("Total : ");
				sum=0;
				tv2.setText("�`�p : "+sum+"��");
						
				break;
		}	
		
}
	@Override
	public boolean onLongClick(View v) {
		
		return false;
	}
	}
	