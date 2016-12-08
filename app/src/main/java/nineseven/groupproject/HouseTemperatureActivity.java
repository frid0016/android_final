/* File: HouseTemperatureActivity.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class extends AppCompatActivity and represents a house temperature activity.
 */
public class HouseTemperatureActivity extends AppCompatActivity {

    TextView curTempValueTV;
    EditText newTempValueET;
    Button htSetButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    /**
     * This method initializes house temperature activity, sets layout, handles
     * button click and toast.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_temperature);

        curTempValueTV = (TextView) findViewById(R.id.curTempValueTV);
        newTempValueET = (EditText) findViewById(R.id.newTempValueET);
        htSetButton = (Button) findViewById(R.id.htSetButton);
        sharedPreferences = getSharedPreferences("temperature", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        curTempValueTV.setText(sharedPreferences.getString("houseTemp", " "));

        htSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(newTempValueET.getText().toString()) < 15
                            || Integer.parseInt((newTempValueET.getText().toString())) > 25) {
                        Toast.makeText(getApplicationContext(), "Enter a temperature between 15 and 25", Toast.LENGTH_LONG).show();
                    } else {
                        editor.putString("houseTemp", newTempValueET.getText().toString());
                        editor.commit();
                        curTempValueTV.setText(sharedPreferences.getString("houseTemp", " "));
                        Toast.makeText(getApplicationContext(), "House temperature has been set", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Enter a temperature between 15 and 25", Toast.LENGTH_LONG).show();
                }
                newTempValueET.setText("");
            }
        });
    } // end of method onCreate

    /**
     * This method inflates menu resource from xml layout.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

    /**
     * This method handles the case when an item ID is selected,
     * inflates appropriate help dialog
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(HouseTemperatureActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(HouseTemperatureActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(HouseTemperatureActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(HouseTemperatureActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_house_temperature, null))
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

} // end of class HouseTemperatureActivity
