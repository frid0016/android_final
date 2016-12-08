package nineseven.groupproject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class DriveActivity extends AppCompatActivity {

    EditText km, fuel;
    Button save, save_fuel, fill;
    TextView total, estim;
    Button reset;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        km = (EditText)findViewById(R.id.drive_km);
        save = (Button)findViewById(R.id.save);
        total = (TextView)findViewById(R.id.total_show);
        reset = (Button) findViewById(R.id.reset);
        save_fuel = (Button) findViewById(R.id.save_fuel);
        fuel = (EditText)findViewById(R.id.fuel_level_edit);
        estim = (TextView)findViewById(R.id.km_car);
        fill = (Button)findViewById(R.id.fill_tank);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    if (Integer.parseInt(km.getText().toString()) < 1) {
                        Toast.makeText(getApplicationContext(), "Enter valid number", Toast.LENGTH_LONG).show();
                    } else {
                        SharedPreferences prefs = getSharedPreferences("Default km", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("Default km", km.getText().toString());
                        editor.commit();


                        sum += Integer.parseInt(km.getText().toString());
                        total.setText(sum + "");
                        Toast.makeText(getApplicationContext(), "Number of km saved", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "How far to drive?", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sum = 0;
                total.setText(sum + "");
                Toast.makeText(getApplicationContext(), "Total km is 0", Toast.LENGTH_LONG).show();
            }
        });

        save_fuel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(fuel.getText().toString()) < 0) {
                        Toast.makeText(getApplicationContext(), "Enter valid number", Toast.LENGTH_LONG).show();
                    } else {
                SharedPreferences prefs2 = getSharedPreferences("Fuel lvl", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = prefs2.edit();
                editor2.putString("Fuel lvl", fuel.getText().toString());
                editor2.commit();

                int est_km = Integer.parseInt(fuel.getText().toString());
                int est = est_km*10;
                estim.setText(est + "");
                        Toast.makeText(getApplicationContext(), "Fuel Level Saved", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter fuel level", Toast.LENGTH_LONG).show();
                }
            }
        });

        fill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fuel.setText("70");
                Toast.makeText(getApplicationContext(), "Fuel level is 70", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("Default km", Context.MODE_PRIVATE);
        km.setText( prefs.getString("Default km", "km"));

        SharedPreferences prefs2 = getSharedPreferences("Fuel lvl", Context.MODE_PRIVATE);
        fuel.setText( prefs2.getString("Fuel lvl", "lvl"));
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(DriveActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(DriveActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(DriveActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(DriveActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_drive, null))
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

}

