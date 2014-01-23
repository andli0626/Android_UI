package com.lilin.test;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Tab1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        EditText et=(EditText)findViewById(R.id.EditText1);
        
        ImageGetter imageGetter = new ImageGetter() {

    		public Drawable getDrawable(String source) {
    			int id = Integer.parseInt(source);
    			Drawable d = getResources().getDrawable(id);
    			d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
    			return d;
    		} 
    	};
    	et.append("hello");
    	et.append(Html.fromHtml("<img src='"+ R.drawable.smile +"'/>", imageGetter, null));  
    	et.append("fasdf");
    	et.append(Html.fromHtml("<img src='"+ R.drawable.smile +"'/>", imageGetter, null));  
    	Button b = (Button)findViewById(R.id.Button01);
    	b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(Tab1.this, Tab2.class);
				startActivity(i);
			}
		});
    }

	
}