package edu.virginia.cs.cs4720.heroesmobile;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


    public void switchButtonClick(View view){
                Button button = (Button)findViewById(R.id.mines_button);
                String currentText = button.getText().toString();
                ImageView map = (ImageView)findViewById(R.id.mines_map_image);

                if(currentText.equals(getApplicationContext().getString(R.string.top))){
                    //the user wants to bring up the top map

                    Drawable topMap = getApplicationContext().getResources().getDrawable(R.drawable.minestop);
                    map.setImageDrawable(topMap);
                    button.setText(getApplicationContext().getString(R.string.mines));
                } else {
                    //the user wants the mines map now

                    Drawable minesMap = getApplicationContext().getResources().getDrawable(R.drawable.minesbottom);
                    map.setImageDrawable(minesMap);
                    button.setText(getApplicationContext().getString(R.string.top));
                }

    }


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
                Battleground current = bgArray[groupPosition];

                if(groupPosition == 0) {
                    //Haunted Mines has two maps, and Android and I hate each other, so I'm just making a special case dropdown for Haunted Mines.
                        LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                        convertView = inflater.inflate(R.layout.haunted_mines_child, parent, false);
                    //set the image
                    ImageView hauntedMineImageView =  (ImageView)(convertView.findViewById(R.id.mines_map_image));


                    Drawable map = getApplicationContext().getResources().getDrawable(R.drawable.minestop);
                    hauntedMineImageView.setImageDrawable(map);

                    TextView description = (TextView)(convertView.findViewById(R.id.bg_description));
                    TextView bossBox = (TextView)(convertView.findViewById(R.id.has_boss));

                    //set the description
                    description.setText(current.getDescription());

                    Button switchButton = (Button)convertView.findViewById(R.id.mines_button);
                    switchButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Button button = (Button)findViewById(R.id.mines_button);
                            String currentText = button.getText().toString();
                            ImageView map = (ImageView)findViewById(R.id.mines_map_image);

                            if(currentText.equals(getApplicationContext().getString(R.string.top))){
                                //the user wants to bring up the top map

                                Drawable topMap = getApplicationContext().getResources().getDrawable(R.drawable.minestop);
                                map.setImageDrawable(topMap);
                                button.setText(getApplicationContext().getString(R.string.mines));
                            } else {
                                //the user wants the mines map now

                                Drawable minesMap = getApplicationContext().getResources().getDrawable(R.drawable.minesbottom);
                                map.setImageDrawable(minesMap);
                                button.setText(getApplicationContext().getString(R.string.top));
                            }
                        }
                    });

                    String str;
                    //and the boss line
                    if(current.hasBoss())
                    {
                        str = getApplicationContext().getString(R.string.yes_boss);
                    } else {
                        str = getApplicationContext().getString(R.string.no_boss);
                    }
                    bossBox.setText(str);


                } else {
                        //create the new List Item View
                        LayoutInflater inflater = (LayoutInflater) (getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
                        convertView = inflater.inflate(R.layout.listview_child, parent, false);

                    //Get a hold of the TextViews, ImageViews in the new View and update them.
                    ImageView img = (ImageView)(convertView.findViewById(R.id.map_image_1));

                    TextView description = (TextView)(convertView.findViewById(R.id.bg_description_text));
                    TextView bossBox = (TextView)(convertView.findViewById(R.id.has_boss));

                    //main map image
                    int mapID = current.getMapImageID();
                    Drawable map = getResources().getDrawable(mapID);
                    img.setImageDrawable(map);

                    //set the description
                    description.setText(bgArray[groupPosition].getDescription());

                    String str;
                    //and the boss line
                    if(current.hasBoss())
                    {
                        str = getApplicationContext().getString(R.string.yes_boss);
                    } else {
                        str = getApplicationContext().getString(R.string.no_boss);
                    }
                    bossBox.setText(str);
                }

                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

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
