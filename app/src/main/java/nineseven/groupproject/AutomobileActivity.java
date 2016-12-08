package nineseven.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.ListView;

public class AutomobileActivity extends AppCompatActivity {
    String[] Automobile = {"GPS", "Temperature", "Lights", "Radio", "Drive"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.automobile_Toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.Automobile_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Automobile);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
    }

}
