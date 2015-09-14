package edu.virginia.cs.cs4720.heroesmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    public void setName(View v) {
        //retrieve user input and use that as their name
        EditText box = (EditText)findViewById(R.id.editText);
        String str = box.getText().toString();

        if(str.length() <= 0) {
            //ask them to try again
            Toast.makeText(getBaseContext(),
                    "Please enter your name.",
                    Toast.LENGTH_SHORT).show();
        } else {

            //Customize the name for the user

            String nameText = String.format(getApplicationContext().getString(R.string.hello_name), str);

            TextView nameTextView = (TextView)findViewById(R.id.textView2);
            nameTextView.setText(nameText);

            //switch the layout visibility so that the GPS prompt is visible
            //make the current screen disappear
            box.setVisibility(View.GONE);
            (findViewById(R.id.textView3)).setVisibility(View.GONE);
            (findViewById(R.id.button)).setVisibility(View.GONE);

            //make everything else pop up
            nameTextView.setVisibility(View.VISIBLE);
            (findViewById(R.id.button2)).setVisibility(View.VISIBLE);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
