/* File: HouseActivity.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class HouseActivity extends AppCompatActivity {
    ListView listView;
    String[] houseItems = {"Garage", "House Temperature", "Outside Weather"};
    FrameLayout container;
    FragmentManager myFragmentManager = getFragmentManager();

    Garage_Fragment GDFrag1 = new Garage_Fragment();
    House_Temperature_Fragment HTFrag1 = new House_Temperature_Fragment();
    Outside_Weather_Fragment OWFrag1 = new Outside_Weather_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        Toolbar toolbar = (Toolbar) findViewById(R.id.House_Toolbar);
        setSupportActionBar(toolbar);

        container = (FrameLayout) findViewById(R.id.container);
        listView = (ListView) findViewById(R.id.House_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, houseItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Context appContext = getApplicationContext();
                Configuration configuration = getResources().getConfiguration();
                if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                    switch (position) {
                        case 0:
                            Intent garageIntent = new Intent(HouseActivity.this, GarageActivity.class);
                            startActivity(garageIntent);
                            break;

                        case 1:
                            Intent houseTemperatureIntent = new Intent(HouseActivity.this, HouseTemperatureActivity.class);
                            startActivity(houseTemperatureIntent);
                            break;

                        case 2:
                            Intent outsideWeatherIntent = new Intent(HouseActivity.this, OutsideWeatherActivity.class);
                            startActivity(outsideWeatherIntent);
                            break;
                    }
                }
                else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    switch (position) {
                        case 0:
                            Garage_Fragment GDFrag2 = new Garage_Fragment();
                            if (GDFrag2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, GDFrag1);
                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, GDFrag1);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 1:
                            House_Temperature_Fragment HTFrag2 = new House_Temperature_Fragment();
                            if (HTFrag2 == null) {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.add(R.id.container, HTFrag1);
                                fragmentTransaction1.commit();
                            } else {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.container, HTFrag1);
                                fragmentTransaction1.commit();
                            }
                            break;
                        case 2:
                            Outside_Weather_Fragment OWFrag2 = new Outside_Weather_Fragment();
                            if (OWFrag2 == null) {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.add(R.id.container, OWFrag1);
                                fragmentTransaction1.commit();
                            } else {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.container, OWFrag1);
                                fragmentTransaction1.commit();
                            }
                            break;
                    }
                }
            }
        });

    } // end of method onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(HouseActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(HouseActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(HouseActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(HouseActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_house, null))
                        .setNegativeButton(R.string.dialog_help_button, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        return true;
    } // end of method onOptionsItemSelected

} // end of class HouseActivity
