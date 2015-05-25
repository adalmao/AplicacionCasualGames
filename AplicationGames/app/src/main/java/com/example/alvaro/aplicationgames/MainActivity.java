package com.example.alvaro.aplicationgames;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    String tag="Lifecycle";
    private CLogin pCLogin;
    public MainActivity(){
        pCLogin= new CLogin();
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // PlusCient mPlusClient= new PlusClient(this,this,this).setVisibleActivities("http://schemas.google.com/AddActivity","http://schemas.google.com/BuyActivity").build();
        //Log.d(tag,"In the onCreate() event");
    }
    public void onClick(View view)
    {
        startActivity(new Intent("com.example.alvaro.aplicationgames.menuClass"));
    }
    public void onClickgooglePlus(View view)
    {
        String correo="";
        if(!(pCLogin.omLogin(correo))) {

        }

        startActivity(new Intent("com.example.alvaro.aplicationgames.menuClass"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    /*public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    public void onStart(){
        super.onStart();
        Log.d(tag,"In the onStart() event");
    }

    public void onRestart(){
        super.onRestart();
        Log.d(tag,"In the onRestart() event");
    }

    public void onResume(){
        super.onResume();
        Log.d(tag,"In the onResume() event");
    }

    public void onPause(){
        super.onPause();
        Log.d(tag,"In the onPause() event");
    }

    public void onStop(){
        super.onStop();
        Log.d(tag,"In the onStop() event");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"In the onDestroy() event");
    }
}
