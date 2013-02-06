package com.example.diceapp;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Button b = (Button)findViewById(R.id.roll);
        Button b = new Button(this);
        b.setText("Roll Dice");

        
        // Go fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        GLSurfaceView view = new GLSurfaceView(this);
        final OpenGLRenderer rend = new OpenGLRenderer();
        view.setRenderer(rend);
        setContentView(view);
        this.addContentView(b,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        b.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
                //new AlertDialog.Builder(MainActivity.this).setMessage("Roll Dice").show();
                rend.mCube.rollFlag = true;
                SystemClock.sleep(5000);
                rend.mCube.rollFlag = false;
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
