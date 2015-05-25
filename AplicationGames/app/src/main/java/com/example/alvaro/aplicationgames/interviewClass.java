package com.example.alvaro.aplicationgames;

/**
 * Created by ALVARO on 08/04/2015.
 */
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class interviewClass extends Activity  {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private ArrayList<String> strArr;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.interview);
        mainListView = (ListView) findViewById( R.id.listView1 );
         String[] planets = new String[] { "- El juego es intutivo", "- Le gusta la app", "- Desea otros juegos", "- Pudo descargarlo con facilidad",
                "- Tiene alguna otra preferencia", "- Desea tener otro juego", "- La encontro interesante la app", "- Buena app"};
       strArr = new ArrayList<String>();
       for(int i=0; i < 7;i++)
           strArr.add(planets[i]);
        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_checked, strArr);
        mainListView.setChoiceMode(mainListView.CHOICE_MODE_MULTIPLE);
        mainListView.setTextFilterEnabled(true);
        mainListView.setBackgroundColor(Color.BLACK);
         mainListView.setAdapter( listAdapter );
    }
    public void onClick3(View view)
    {
        startActivity(new Intent("com.example.alvaro.aplicationgames.menuClass"));
        super.finish();
    }
    public void onClick4(View view)
    {
        startActivity(new Intent("com.example.alvaro.aplicationgames.menuClass"));
        super.finish();
    }

}


