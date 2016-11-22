package nineseven.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class KitchenActivity extends AppCompatActivity {
    ListView listView;
    String[] kitchenItems = {"Microwave", "Fridge", "Light"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Kitchen_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        listView = (ListView) findViewById(R.id.Kitchen_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kitchenItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent microwaveIntent = new Intent(KitchenActivity.this, MicrowaveActivity.class);
                        startActivity(microwaveIntent);
                        break;

                    case 1:
                        Intent fridgeIntent = new Intent(KitchenActivity.this, FridgeActivity.class);
                        startActivity(fridgeIntent);
                        break;

                    case 2:
                        Intent lightIntent = new Intent(KitchenActivity.this, LightActivity.class);
                        startActivity(lightIntent);
                        break;

                } // end of switch statement

            } // end of method onItemClick
        });



    } // end of method onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    } // end of method onCreateOptionsMenu

} // end of class KitchenActivity
