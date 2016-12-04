package nineseven.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);

    } // end of method onOptionsItemSelected

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

} // end of class LaunchScreenActivity
