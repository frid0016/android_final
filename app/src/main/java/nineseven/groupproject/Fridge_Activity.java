/* File: Fridge_Activity.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Mahesh Bagde
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

/**
 * this class loads the fragment into portrait mode when fridge activity is called
 */
public class Fridge_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge_activity_layout);

        if (savedInstanceState == null) {
            Fridge_Fragment fridgeFragment = new Fridge_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fridge_Activity_Container, fridgeFragment)
                    .commit();
        } else {
            Fridge_Fragment fridgeFragment = new Fridge_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fridge_Activity_Container, fridgeFragment)
                    .commit();
        }
    } // end of onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

    // Depending on the icon clicked on the toolbar menu options, it starts the relevant activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch (item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(Fridge_Activity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(Fridge_Activity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(Fridge_Activity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(Fridge_Activity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.fridge_dialog, null))
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


} // end of class Fridge_Activity
