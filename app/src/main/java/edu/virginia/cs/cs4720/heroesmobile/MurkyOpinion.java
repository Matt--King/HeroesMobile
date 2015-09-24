package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MurkyOpinion extends AppCompatActivity {

    public void clickButton(View view)
    {
        EditText answerText = (EditText)(findViewById(R.id.murky_ans));
        final String str = answerText.getText().toString();
        if(str.length() <= 0)
        {
            Toast.makeText(getBaseContext(),"Please tell me what you think of Murky",Toast.LENGTH_SHORT ).show();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                    Intent intent = new Intent(MurkyOpinion.this, MainMenu.class);
                    intent.putExtra("User Opinion", str);
                    startActivity(intent);
                    MurkyOpinion.this.finish();
                }
            }, 0);
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
