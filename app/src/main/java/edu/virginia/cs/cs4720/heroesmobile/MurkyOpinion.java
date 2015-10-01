package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MurkyOpinion extends AppCompatActivity {
    private String opinion = "";

    public void radioSelect(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.option_one:
                if (checked)
                    // Murky is OP
                    opinion = getApplicationContext().getString(R.string.murky_answer_one);
                    break;
            case R.id.option_two:
                if (checked)
                    // Murky sucks
                    opinion = getApplicationContext().getString(R.string.murky_answer_two);
                    break;
            case R.id.option_three:
                if (checked)
                    // No opinion
                    opinion = getApplicationContext().getString(R.string.murky_answer_three);
                    break;
        }
    }

    public void clickButton(View view)
    {
        if (!opinion.isEmpty()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                    Intent intent = new Intent(MurkyOpinion.this, MainMenu.class);


                    try {
                        JSONObject json = MainMenu.readObjectFromInternalStorage(getApplicationContext(), "MurkyDB.json");
                        json.put("opinion", opinion);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }

                    startActivity(intent);
                    MurkyOpinion.this.finish();
                }
            }, 0);
        } else {
            Toast.makeText(getBaseContext(),"Please tell me what you think of Murky",Toast.LENGTH_SHORT ).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murky_opinion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_murky_opinion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
