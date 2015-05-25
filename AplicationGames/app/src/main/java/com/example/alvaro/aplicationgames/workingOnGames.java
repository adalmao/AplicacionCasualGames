package com.example.alvaro.aplicationgames;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


/**
 * Created by ALVARO on 08/04/2015.
 */
public class workingOnGames extends Activity{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workingon);
    }
     public void onClick2(View view)
       {

           new AlertDialog.Builder(this)
                   .setMessage("Do you want to calified this app?")
                   .setCancelable(false)
                   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int id) {
                           startActivity(new Intent("com.example.alvaro.aplicationgames.interviewClass"));
                           workingOnGames.this.finish();
                       }
                   })
                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int id) {
                       startActivity(new Intent("com.example.alvaro.aplicationgames.menuClass"));
                           workingOnGames.this.finish();

                   }}) .show();


       }
    public void onBackPressed1() {

        //super.finish();
    }

}
