package nineseven.groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HouseActivity extends AppCompatActivity {

    ListView listView;
    String[] houseItems = {"Garage Door", "Garage Light", "House Temperature", "Outside Weather"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.House_Toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        listView = (ListView) findViewById(R.id.House_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, houseItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent garageDoorIntent = new Intent(HouseActivity.this, GarageDoorActivity.class);
                        startActivity(garageDoorIntent);
                        break;

                    case 1:
                        Intent garageLightIntent = new Intent(HouseActivity.this, GarageLightActivity.class);
                        startActivity(garageLightIntent);
                        break;

                    case 2:
                        Intent houseTemperatureIntent = new Intent(HouseActivity.this, HouseTemperatureActivity.class);
                        startActivity(houseTemperatureIntent);
                        break;

                    case 3:
                        Intent outsideWeatherIntent = new Intent(HouseActivity.this, OutsideWeatherActivity.class);
                        startActivity(outsideWeatherIntent);
                        break;

                } // end of switch statement

            } // end of method onItemClick
        });

    } // end of method onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

} // end of class KitchenActivity
