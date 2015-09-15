package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
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
        EditText box = (EditText) findViewById(R.id.editText);
        String str = box.getText().toString();

        if (str.length() <= 0) {
            //ask them to try again
            Toast.makeText(getBaseContext(),
                    "Please enter your name.",
                    Toast.LENGTH_SHORT).show();
        } else {

            //Customize the name for the user

            String nameText = String.format(getApplicationContext().getString(R.string.hello_name), str);

            TextView nameTextView = (TextView) findViewById(R.id.textView2);
            nameTextView.setText(nameText);

            //switch the layout visibility so that the GPS prompt is visible
            //make the current screen disappear
            (findViewById(R.id.button)).setVisibility(View.GONE);
            box.setVisibility(View.GONE);
            (findViewById(R.id.textView3)).setVisibility(View.GONE);


            //make everything else pop up
            nameTextView.setVisibility(View.VISIBLE);
            (findViewById(R.id.button2)).setVisibility(View.VISIBLE);

        }
    }

    public void showGPS(View v) {




        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            //Edit TextViews Latitude and Longitude to output the lat and long
            double lat = location.getLatitude();
            double lon = location.getLongitude();

            TextView latBox = (TextView)findViewById(R.id.latitude);
            latBox.setText("Your Latitude: " + lat);
            TextView lonBox = (TextView)findViewById(R.id.longitude);
            lonBox.setText("Your Longitude: " + lon);

            //when the GPS button is pressed, make it disappear
            (findViewById(R.id.button2)).setVisibility(View.GONE);
            (findViewById(R.id.textView2)).setVisibility(View.GONE);


            (findViewById(R.id.textView4)).setVisibility(View.VISIBLE);
            latBox.setVisibility(View.VISIBLE);
            lonBox.setVisibility(View.VISIBLE);

        } catch(SecurityException e){
            Toast.makeText(getBaseContext(),
                    "You didn't let me use your location.",
                    Toast.LENGTH_LONG).show();
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
