package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends AppCompatActivity {

    public void setName(View v) {

        Toast toasty = Toast.makeText(getBaseContext(),"",Toast.LENGTH_SHORT );
        toasty.setGravity(Gravity.TOP,0,0);
        //retrieve user input and use that as their name
        EditText box = (EditText) findViewById(R.id.editText);
        String str = box.getText().toString();

        if (str.length() <= 0) {
            //ask them to try again
            toasty.setText("Please enter your name.");
            toasty.show();
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


    private Location loc;

    public void showGPS(View v) {
        Toast toasty = Toast.makeText(getBaseContext(),"",Toast.LENGTH_SHORT );
        toasty.setGravity(Gravity.TOP,0,0);
        Log.i("Location", "Show GPS Started");
        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.i("GPS", "" + locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
        if (!locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            toasty.setText("Location is not enabled.\nLocation cannot be found.");
            toasty.show();
        } else {
            Location lkl;
            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    Log.i("NetworkLocListener", "onLocationChanged executed");
                    loc = location;
                    Log.v("NetworkLocListener", "IN ON LOCATION CHANGE, lat=" + loc.getLatitude() + ", lon=" + loc.getLongitude());
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                @Override
                public void onProviderEnabled(String provider) {
                }

                @Override
                public void onProviderDisabled(String provider) {
                }
            };
            try {
                boolean requisite = true;
                int c = 0;
                lkl = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Log.i("GPS", lkl.toString());
                locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                Log.i("GPS", "starting while loop");
                while (requisite) {
                    c++;
                    if (loc != null || c > 1000) {
                        Log.i("GPS", "" + c);
                        requisite = false;
                        locManager.removeUpdates(locationListener);
                        Log.i("GPS", "listener turned off");
                        if (c > 1000) {
                            Log.i("GPS", "loc evaluates to "+(loc==null));
                            loc = lkl;
                            toasty.setText("Current location unable to be updated.\nUsing last known location.");
                            toasty.show();
                        }
                    }
                }
            } catch (SecurityException e) {
                Toast.makeText(getBaseContext(),
                        "You didn't let me use your location.",
                        Toast.LENGTH_LONG).show();
            }
        /*
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getBaseContext(),
                    "Location is not enabled. Location cannot be found.",
                    Toast.LENGTH_LONG).show();
        } else {
            loc = null;
            // TODO remove above line
            if (loc == null) {
                // Log.i("GPS","LKN == null");
                // Define a listener that responds to location updates
                LocationListener locationListener = new LocationListener() {
                    private final String TAG = "debug.LocationListener";

                    public void onLocationChanged(Location location) {
                        Log.i(TAG, "onLocationChanged executed");
                        loc = location;
                        Log.v(TAG, "IN ON LOCATION CHANGE, lat=" + loc.getLatitude() + ", lon=" + loc.getLongitude());
                    }

                    // assume default behavior on these 3 methods
                    public void onProviderEnabled(String p) {
                        Log.i(TAG, "Provider enabled");
                    }

                    public void onProviderDisabled(String p) {
                        Log.i(TAG, "Provider disabled");
                    }

                    public void onStatusChanged(String p, int status, Bundle extras) {
                        Log.i(TAG, "Status changed");
                    }
                };

                try {
                    // Log.i("GPS","loc == null");
                    GregorianCalendar cal = new GregorianCalendar();
                    while (loc == null) {
                        Log.i("GPS", "Entering the while loc==null loop");
                        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                    }
                    //loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    // Log.i("GPS", "loc == null evaluates to " + String.valueOf(loc==null));
                    Log.i("GPS", "starting timer");
                    long start = cal.getTimeInMillis();
                    // Log.i("GPS", "Location "+loc.toString());
                    while (loc.getAccuracy() > 68) {

                        if (cal.getTimeInMillis() - start > 5000) {
                            Toast.makeText(getBaseContext(),
                                    "Location not found.",
                                    Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                    locManager.removeUpdates(locationListener);
                    Log.i("GPS", "listener turned off");


                } catch (SecurityException e) {
                    Toast.makeText(getBaseContext(),
                            "You didn't let me use your location.",
                            Toast.LENGTH_LONG).show();
                }
            }

            */
            //Edit TextViews Latitude and Longitude to output the lat and long
            double lat = loc.getLatitude();
            double lon = loc.getLongitude();
            Log.i("GPS", loc.toString());
            TextView latBox = (TextView) findViewById(R.id.latitude);
            latBox.setText("Your Latitude: " + lat);
            TextView lonBox = (TextView) findViewById(R.id.longitude);
            lonBox.setText("Your Longitude: " + lon);

            //when the GPS button is pressed, make it disappear
            (findViewById(R.id.button2)).setVisibility(View.GONE);
            (findViewById(R.id.textView2)).setVisibility(View.GONE);

            (findViewById(R.id.textView4)).setVisibility(View.VISIBLE);
            findViewById(R.id.latitude).setVisibility(View.VISIBLE);
            findViewById(R.id.longitude).setVisibility(View.VISIBLE);
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
