package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    public void goToGPSScreen(View view)
    {
        Intent intent = new Intent(MainMenu.this, GPSScreen.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Pull the user's opinion on Murky from the previous page's intent
        Intent intent = getIntent();
        String input = intent.getStringExtra("User Opinion");
        TextView opinionBox = (TextView)(findViewById(R.id.murky_is_blank));
        //Display the user's input
        String str = String.format(getApplicationContext().getString(R.string.murky_opinion), input);
        opinionBox.setText(str);
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
