package com.example.alvaro.aplicationgames;
/**
 * Created by ALVARO on 08/04/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class menuClass extends Activity{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuclass);
    }
    public void onClick1(View view)
    {
        startActivity(new Intent("com.example.alvaro.aplicationgames.workingOnGames"));
        super.finish();
    }
    public void onClickSalir(View view)
    {

        onBackPressed();
    }
     public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       menuClass.this.finish();
                    }
                })
                    .setNegativeButton("No", null)
                .show();
    }
}
