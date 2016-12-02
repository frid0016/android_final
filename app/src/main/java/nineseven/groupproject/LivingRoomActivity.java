package nineseven.groupproject;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class LivingRoomActivity extends AppCompatActivity {
    ListView listView;
    String[] livingRoom = {"Lamp", "TV", "Blinds"};
    FrameLayout container;
    FragmentManager myFragmentManager= getFragmentManager();

    TV_fragment tv1 = new TV_fragment();
    Blinds_Fragment bl1 = new Blinds_Fragment();
    Lamp_Fragment lamp = new Lamp_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        container = (FrameLayout) findViewById(R.id.container);
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
                else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    switch (position) {
                        case 0:
                            Lamp_Fragment lamp2 = new Lamp_Fragment();
                            if (lamp2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, lamp);
                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, lamp);
                                fragmentTransaction.commit();
                            }

                            break;
                        case 1:
                            TV_fragment tv2 = new TV_fragment();
                            if (tv2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, tv1);
                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, tv1);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 2:
                            Blinds_Fragment bl2 = new Blinds_Fragment();
                            if (bl2 == null) {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.add(R.id.container, bl1);
                                fragmentTransaction1.commit();
                            } else {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.container, bl1);
                                fragmentTransaction1.commit();
                            }
                            break;
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
