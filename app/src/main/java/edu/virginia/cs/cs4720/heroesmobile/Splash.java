package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Display the splash page for 1.5 secs, then kill it and start the app
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                JSONObject jsonObj = new JSONObject();
                try {
                    jsonObj.put("opinion","").put("Rexxar","").put("Kharazim","").put("Leoric","").put("Butcher","").put("Johanna","").put("Kael'Thas","").put("Sylvanas","").put("Vikings","").put("Thrall","").put("Jaina","").put("Anub'arak","").put("Azmodan","").put("Chen","").put("Rehgar","").put("Zagara","").put("Murky","").put("Brightwink","").put("LiLi","").put("Tychus","").put("Stiches","").put("Arthas","").put("Diablo","").put("Tyrael","").put("ETC","").put("Sylvanas","").put("Muradin","").put("Kerrigan","").put("Nova","").put("Falstad","").put("Valla","").put("Illidan","").put("Zraynor","").put("Zeratul","").put("Uther","").put("Malfurion","").put("Tassadar","").put("Tyrael","").put("Nazeebo","").put("Gazlowe","").put("Abathur","").put("Hammer","").put("Morales","").put("Artanis","");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent;
                String fname = "MurkyDB.json";
                //Log.i("Debug", fileExistance(fname)+" JSON was made");

                String str = "";



                if (str.isEmpty()){

                    try {
                        FileOutputStream fos = openFileOutput(fname, Context.MODE_PRIVATE);
                        fos.write(jsonObj.toString().getBytes());
                        fos.close();
                       // Log.i("Debug", fileExistance(fname)+" JSON was made");
                    } catch (java.io.IOException e) {
                        Toast.makeText(getBaseContext(), "File Not Found", Toast.LENGTH_SHORT).show();
                    }
                    intent = new Intent(Splash.this, MurkyOpinion.class);
                }
                else{
                    intent = new Intent(Splash.this, MainMenu.class);
                }

                startActivity(intent);
                Splash.this.finish();
            }
        }, 1500);
    }
/*
    public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
