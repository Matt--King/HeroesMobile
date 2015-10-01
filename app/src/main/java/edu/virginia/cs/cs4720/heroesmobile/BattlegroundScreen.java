package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class BattlegroundScreen extends AppCompatActivity {
    private Battleground[] bgArray = {
            new Battleground(Battleground.HAUNTED_MINES),
            new Battleground(Battleground.CURSED_HOLLOW),
            new Battleground(Battleground.DRAGON_SHIRE),
            new Battleground(Battleground.BLACKHEARTS_BAY),
            new Battleground(Battleground.GARDEN_OF_TERROR),
            new Battleground(Battleground.SKY_TEMPLE),
            new Battleground(Battleground.TOMB_OF_THE_SPIDER_QUEEN),
            new Battleground(Battleground.BATTLEFIELD_OF_ETERNITY),
            new Battleground(Battleground.INFERNAL_SHRINES)};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battleground_screen);
        ListAdapter list = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 9;
            }

            @Override
            public Battleground getItem(int position) {
                return bgArray[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    //create the new List Item View
                    LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                    convertView = inflater.inflate(R.layout.list_row_group, parent, false);
                }
                //Get a hold of the TextViews in the new View and update them.
                TextView name = (TextView)(convertView.findViewById(R.id.bg_name_text));
                TextView description = (TextView)(convertView.findViewById(R.id.bg_description_text));

                Battleground current = bgArray[position];
                name.setText(current.getName());
                description.setText(current.getDescription());
                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };
        ListView listView = (ListView)(findViewById(R.id.bg_list));
        listView.setAdapter(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battleground_screen, menu);
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
