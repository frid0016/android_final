package nineseven.groupproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class AutomobileActivity extends AppCompatActivity {
    String[] Automobile = {"GPS", "Temperature", "Lights", "Radio", "Drive"};
    ListView listView;
    FrameLayout container;
    FragmentManager myFragmentManager = getFragmentManager();

    Auto_Drive_Fragment ad = new Auto_Drive_Fragment();
    Auto_GPS_Fragment ag = new Auto_GPS_Fragment();
    Auto_Lights_Fragment al = new Auto_Lights_Fragment();
    Auto_Radio_Fragment ar = new Auto_Radio_Fragment();
    Auto_Temp_Fragment at = new Auto_Temp_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.automobile_Toolbar);
        setSupportActionBar(toolbar);

        container = (FrameLayout) findViewById(R.id.container);
        listView = (ListView) findViewById(R.id.Automobile_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Automobile);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Configuration configuration = getResources().getConfiguration();
                if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                switch (position) {

                    case 0:
                        Intent GPSIntent = new Intent(AutomobileActivity.this, GPSActivity.class);
                        startActivity(GPSIntent);
                        break;

                    case 1:
                        Intent temperatureIntent = new Intent(AutomobileActivity.this, TemperatureActivity.class);
                        startActivity(temperatureIntent);
                        break;

                    case 2:
                        Intent lightsIntent = new Intent(AutomobileActivity.this, LightsActivity.class);
                        startActivity(lightsIntent);
                        break;
                    case 3:
                        Intent radioIntent = new Intent(AutomobileActivity.this, RadioActivity.class);
                        startActivity(radioIntent);
                        break;
                    case 4:
                        Intent driveIntent = new Intent(AutomobileActivity.this, DriveActivity.class);
                        startActivity(driveIntent);
                        break;
                    }
                }
                else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    switch (position) {
                        case 0:
                            Auto_GPS_Fragment ag2 = new Auto_GPS_Fragment();
                            if (ag2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, ag);

                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, ag);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 1:
                            Auto_Temp_Fragment at2 = new Auto_Temp_Fragment();
                            if (at2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, at);

                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, at);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 2:
                            Auto_Lights_Fragment al2 = new Auto_Lights_Fragment();
                            if (al2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, al);

                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, al);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 3:
                            Auto_Radio_Fragment ar2 = new Auto_Radio_Fragment();
                            if (ar2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, ar);

                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, ar);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 4:
                            Auto_Drive_Fragment ad2 = new Auto_Drive_Fragment();
                            if (ad2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, ad);

                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, ad);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                            break;
                    }
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(AutomobileActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(AutomobileActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(AutomobileActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(AutomobileActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_car, null))
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
    }

}
