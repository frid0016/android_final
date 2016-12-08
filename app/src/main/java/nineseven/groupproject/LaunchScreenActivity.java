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
import android.view.View;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Launch_Screen_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

    } // end of method onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu


    public void launchHouseOnClick (View view) {
        Intent intent = new Intent(LaunchScreenActivity.this, HouseActivity.class);
        startActivity(intent);
    } // end of method launchHouseOnClick

    public void launchLivingRoomOnClick (View view) {
        Intent intent = new Intent(LaunchScreenActivity.this, LivingRoomActivity.class);
        startActivity(intent);
    } // end of method launchLivingRoomOnClick

    public void launchKitchenOnClick (View view) {
        Intent intent = new Intent(LaunchScreenActivity.this, Kitchen_Activity.class);
        startActivity(intent);
    } // end of method launchKitchenOnClick

    public void launchAutomobileOnClick (View view) {
        Intent intent = new Intent(LaunchScreenActivity.this, AutomobileActivity.class);
        startActivity(intent);
    } // end of method launchAutomobileOnClick

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder;
        switch(item.getItemId()) {
            case R.id.House_Menu_Item:
                Intent houseIntent = new Intent(LaunchScreenActivity.this, HouseActivity.class);
                startActivity(houseIntent);
                break;
            case R.id.Living_Room_Menu_Item:
                Intent livingRoomIntent = new Intent(LaunchScreenActivity.this, LivingRoomActivity.class);
                startActivity(livingRoomIntent);
                break;
            case R.id.Kitchen_Menu_Item:
                Intent kitchenIntent = new Intent(LaunchScreenActivity.this, Kitchen_Activity.class);
                startActivity(kitchenIntent);
                break;
            case R.id.Automobile_Menu_Item:
                Intent automobileIntent = new Intent(LaunchScreenActivity.this, AutomobileActivity.class);
                startActivity(automobileIntent);
                break;
            case R.id.Help_Menu_Item:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                builder.setTitle(R.string.dialog_help_title);
                builder.setView(inflater.inflate(R.layout.dialog_launch, null))
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

