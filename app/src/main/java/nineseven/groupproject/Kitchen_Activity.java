package nineseven.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class Kitchen_Activity extends AppCompatActivity
        implements Kitchen_List_Fragment.callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_activity_layout);

        Kitchen_List_Fragment kitchenListFragment = new Kitchen_List_Fragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.Kitchen_List_Container, kitchenListFragment)
                .commit();
    }

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

} // end of class Kitchen_Activity
