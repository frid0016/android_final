/* File: GarageActivity.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Michael Palmer
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * This class extends AppCompatActivity and represents a garage door activity.
 */
public class GarageActivity extends AppCompatActivity {

    ImageView glImageView;
    Bitmap glBitmap;
    Switch glSwitch;

    /**
     * This method initializes garage activity; sets layout; handles switch changes,
     * button clicks, and snackbars.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        glBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);
        glImageView =(ImageView)findViewById(R.id.glImageView);
        glImageView.setImageBitmap(glBitmap);
        glImageView.setColorFilter(Color.parseColor("#99000000"));
        glSwitch = (Switch) findViewById(R.id.glSwitch);

        Button gdOpenButton = (Button) findViewById(R.id.gdOpenButton);
        Button gdCloseButton = (Button) findViewById(R.id.gdCloseButton);
        final ImageView garageImageView = (ImageView) findViewById(R.id.garageImageView);

        glSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    int color = Color.parseColor("#80ffff00");
                    glImageView.setColorFilter(color);
                }
                else{
                    int color = Color.parseColor("#90000000");
                    glImageView.setColorFilter(color);
                }
            }
        });

        gdOpenButton.setOnClickListener(new View.OnClickListener() {
            boolean isChecked;
            @Override
            public void onClick(View view) {
                garageImageView.setImageResource(R.drawable.garageopen);
                if(!glSwitch.isChecked()){
                    int color = Color.parseColor("#80ffff00");
                    glImageView.setColorFilter(color);
                    glSwitch.toggle();
                }
                Snackbar.make(view, "Garage Door Opens / Garage Light Turns On", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        gdCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garageImageView.setImageResource(R.drawable.garageclosed);
                Snackbar.make(view, "Garage Door Closes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
                Intent houseIntent = new Intent(GarageActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(GarageActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(GarageActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(GarageActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_garage, null))
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

} // end of class GarageActivity
