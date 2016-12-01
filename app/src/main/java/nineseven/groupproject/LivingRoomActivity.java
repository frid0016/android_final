package nineseven.groupproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LivingRoomActivity extends AppCompatActivity {
    ListView listView;
    String[] livingRoom = {"Lamp", "TV", "Blinds"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        listView = (ListView) findViewById(R.id.Living_Room_List);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, livingRoom);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Context appContext = getApplicationContext();
                Configuration configuration = getResources().getConfiguration();
                if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                    switch (position) {
                        case 0:
                            Intent lamp = new Intent(LivingRoomActivity.this, Lamp.class);
                            startActivity(lamp);
                            break;

                        case 1:
                            Intent tv = new Intent(LivingRoomActivity.this, TelevisionActivity.class);
                            startActivity(tv);
                            break;

                        case 2:
                            Intent blinds = new Intent(LivingRoomActivity.this, BlindsActivity.class);
                            startActivity(blinds);
                            break;
                    }
                }
                else {
                    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){

                        //FragmentManager fragmentManager = getSupportFragmentManager();
                        //Fragment fragment = (Fragment) fragmentManager.findFragmentById(R.id.fragment4);

                        switch (position) {
                            case 0:
                                TextView text = (TextView)findViewById(R.id.description);
                                text.setText("Contains 3 lamps: simple lamp, dimmable light and smart light");
                                break;
                            case 1:
                                TextView text1 = (TextView)findViewById(R.id.description);
                                text1.setText("Interface for turning on/off the TV, channel entry and a direction pad");
                                break;
                            case 2:
                                TextView text3 = (TextView)findViewById(R.id.description);
                                text3.setText("Smart window blinds");
                                break;
                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    }
}
