package edu.virginia.cs.cs4720.heroesmobile;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

   /* public String name;
    //TODO How do we correctly save global variables?
*/
    public void setName(View view) {
        //retrieve user input and use that as their name
        TextView box = (TextView)findViewById(R.id.textView3);
        String str = box.getText().toString();

        if(str.length() <= 0) {
            Toast.makeText(getBaseContext(),
                    "Please enter your name.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Resources res = getResources();
            String text = String.format(res.getString(R.string.hello_name), str);

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
