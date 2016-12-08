/* File: Kitchen_Activity.java
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
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

    // This class loads the Kitchen List Fragment which is the first launch screen
    // that the user see when clicking on the Kitchen icon.
public class Kitchen_Activity extends AppCompatActivity
        implements Kitchen_List_Fragment.callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_activity_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.Kitchen_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        Kitchen_List_Fragment kitchenListFragment = new Kitchen_List_Fragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.Kitchen_List_Container, kitchenListFragment)
                .commit();
    }

    // checks if the view has loaded the fragment placeholder to determine the orientation of the phone
    // accordingly loads the detail fragment if the placeholder in not null
    // or starts a new activity if the placeholder in null
    @Override
    public void onItemSelected(int position) {
        switch (position) {
            case 0:
                if (findViewById(R.id.Kitchen_Device_Container) != null) {
                    Microwave_Fragment microwaveFragment = new Microwave_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.Kitchen_Device_Container, microwaveFragment)
                            .commit();
                } else {
                    Intent microwaveIntent = new Intent(this, Microwave_Activity.class);
                    startActivity(microwaveIntent);
                } // end if else for case 0
                break;

            case 1:
                if (findViewById(R.id.Kitchen_Device_Container) != null) {
                    Fridge_Fragment fridgeFragment = new Fridge_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.Kitchen_Device_Container, fridgeFragment)
                            .commit();
                } else {
                    Intent fridgeIntent = new Intent(this, Fridge_Activity.class);
                    startActivity(fridgeIntent);
                } // end if else for case 1
                break;

            case 2:
                if (findViewById(R.id.Kitchen_Device_Container) != null) {
                    Kitchen_Light_Fragment kitchenLightFragment = new Kitchen_Light_Fragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.Kitchen_Device_Container, kitchenLightFragment)
                            .commit();
                } else {
                    Intent kitchenLightIntent = new Intent(this, Kitchen_Light_Activity.class);
                    startActivity(kitchenLightIntent);
                } // end if else for case 2
                break;

        } // end of switch statement
    } // end of method onCreate

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
                Intent houseIntent = new Intent(Kitchen_Activity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(Kitchen_Activity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(Kitchen_Activity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(Kitchen_Activity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.kitchen_dialog, null))
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

} // end of class Kitchen_Activity
