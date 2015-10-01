package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class MainMenu extends AppCompatActivity {

    public void goToGPSScreen(View view)
    {
        Intent intent = new Intent(MainMenu.this, GPSScreen.class);
        startActivity(intent);
    }

    public void goToBattlegroundsScreen (View view)
    {
        Intent intent = new Intent(MainMenu.this, BattlegroundScreen.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Pull the user's opinion on Murky from the previous page's intent
        Intent intent = getIntent();
        TextView opinionBox = (TextView)(findViewById(R.id.murky_is_blank));
        //Display the user's input
        // TODO add action bar to change this functionality
        //Display the user's input
        String str = "it didn\'t work";

        try {
            JSONObject json = MainMenu.readObjectFromInternalStorage(getApplicationContext(), "MurkyDB.json");
            str = json.get("opinion").toString();
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        } catch (Exception e ) {
            e.printStackTrace();
        }

        opinionBox.setText(str);
    }

    public static JSONObject readObjectFromInternalStorage(Context context, String filename) throws Exception{
        StringBuffer datax = new StringBuffer("");
        FileInputStream fIn =  context.openFileInput(filename);
        InputStreamReader isr = new InputStreamReader ( fIn ) ;
        BufferedReader buffreader = new BufferedReader ( isr ) ;

        String readString = buffreader.readLine ( ) ;
        while ( readString != null ) {
            datax.append(readString);
            readString = buffreader.readLine ( ) ;
        }
        isr.close ( ) ;

        JSONObject j = new JSONObject(datax.toString());
        return j;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the GPSScreen/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
