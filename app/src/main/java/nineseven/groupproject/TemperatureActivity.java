package nineseven.groupproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {

    TextView front, back;
    Button set1, set2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        front = (TextView)findViewById(R.id.car_front_temp);
        back = (TextView)findViewById(R.id.car_back_temp);
        set1 = (Button) findViewById(R.id.button_front);
        set2 = (Button) findViewById(R.id.button_back);

        set1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try {
                    if (Integer.parseInt(front.getText().toString()) < 1) {
                        Snackbar.make(v, "Enter valid number", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        SharedPreferences sp = getSharedPreferences("Front temp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("Front temp", front.getText().toString());
                        editor.commit();

                        Snackbar.make(v, "Front temperature is set", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } catch (NumberFormatException e) {
                    Snackbar.make(v,  "Please enter the temperature", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        set2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(back.getText().toString()) < 1) {
                        Snackbar.make(v, "Enter valid number", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        SharedPreferences sp2 = getSharedPreferences("Back temp", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sp2.edit();
                        editor2.putString("Back temp", back.getText().toString());
                        editor2.commit();

                        Snackbar.make(v, "Back temperature is set", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } catch (NumberFormatException e) {
                    Snackbar.make(v,  "Please enter the temperature", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
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
        SharedPreferences prefs = getSharedPreferences("Front temp", Context.MODE_PRIVATE);
        front.setText( prefs.getString("Front temp", "num"));

        SharedPreferences prefs2 = getSharedPreferences("Back temp", Context.MODE_PRIVATE);
        back.setText( prefs2.getString("Back temp", "temp"));
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
                Intent houseIntent = new Intent(TemperatureActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(TemperatureActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(TemperatureActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(TemperatureActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_car_temp, null))
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
