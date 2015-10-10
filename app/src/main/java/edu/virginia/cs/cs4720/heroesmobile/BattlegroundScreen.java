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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

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
        ExpandableListAdapter list = new ExpandableListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return bgArray.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return 1;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return null;
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return null;
            }

            @Override
            public long getGroupId(int groupPosition) {
                return 0;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    //create the new List Item View
                    LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                    convertView = inflater.inflate(R.layout.listview_parent, parent, false);
                }
                //Get a hold of the TextViews in the new View and update them.
                TextView name = (TextView)(convertView.findViewById(R.id.parent_name_box));

                Battleground current = bgArray[groupPosition];
                name.setText(current.getName());
                return convertView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    //create the new List Item View
                    LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                    convertView = inflater.inflate(R.layout.listview_child, parent, false);
                }
                //Get a hold of the TextViews in the new View and update them.
                ImageView img = (ImageView)(convertView.findViewById(R.id.map_image_1));
                TextView description = (TextView)(convertView.findViewById(R.id.bg_description_text));

                if(groupPosition == 0)
                {
                    //Haunted Mines needs the basement map as well, so add that in
                    ImageView secondMap = (ImageView)(convertView.findViewById(R.id.mapImage2));

                }



                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
/*
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    //create the new List Item View
                    LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                    convertView = inflater.inflate(R.layout.listview_child, parent, false);
                }
                //Get a hold of the TextViews in the new View and update them.
                TextView name = (TextView)(convertView.findViewById(R.id.bg_name_text));
                TextView description = (TextView)(convertView.findViewById(R.id.bg_description_text));

                Battleground current = bgArray[position];
                name.setText(current.getName());
                description.setText(current.getDescription());
                return convertView;
            }
*/
            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        ExpandableListView eListView = (ExpandableListView)(findViewById(R.id.bg_list));
        eListView.setAdapter(list);
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
