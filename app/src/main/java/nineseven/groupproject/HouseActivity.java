package nineseven.groupproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class HouseActivity extends AppCompatActivity {
    ListView listView;
    String[] houseItems = {"Garage Door", "Garage Light", "House Temperature", "Outside Weather"};
    FrameLayout container;
    FragmentManager myFragmentManager = getFragmentManager();

    Garage_Door_Fragment GDFrag1 = new Garage_Door_Fragment();
    Garage_Light_Fragment GLFrag1 = new Garage_Light_Fragment();
    House_Temperature_Fragment HTFrag1 = new House_Temperature_Fragment();
    Outside_Weather_Fragment OWFrag1 = new Outside_Weather_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        container = (FrameLayout) findViewById(R.id.container);
        listView = (ListView) findViewById(R.id.House_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, houseItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Context appContext = getApplicationContext();
                Configuration configuration = getResources().getConfiguration();
                if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                    switch (position) {
                        case 0:
                            Intent garageDoorIntent = new Intent(HouseActivity.this, GarageDoorActivity.class);
                            startActivity(garageDoorIntent);
                            break;

                        case 1:
                            Intent garageLightIntent = new Intent(HouseActivity.this, GarageLightActivity.class);
                            startActivity(garageLightIntent);
                            break;

                        case 2:
                            Intent houseTemperatureIntent = new Intent(HouseActivity.this, HouseTemperatureActivity.class);
                            startActivity(houseTemperatureIntent);
                            break;

                        case 3:
                            Intent outsideWeatherIntent = new Intent(HouseActivity.this, OutsideWeatherActivity.class);
                            startActivity(outsideWeatherIntent);
                            break;
                    }
                }
                else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    switch (position) {
                        case 0:
                            Garage_Door_Fragment GDFrag2 = new Garage_Door_Fragment();
                            if (GDFrag2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, GDFrag1);
                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, GDFrag1);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 1:
                            Garage_Light_Fragment GLFrag2 = new Garage_Light_Fragment();
                            if (GLFrag2 == null) {
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.add(R.id.container, GLFrag1);
                                fragmentTransaction.commit();
                            } else{
                                FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, GLFrag1);
                                fragmentTransaction.commit();
                            }
                            break;
                        case 2:
                            House_Temperature_Fragment HTFrag2 = new House_Temperature_Fragment();
                            if (HTFrag2 == null) {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.add(R.id.container, HTFrag1);
                                fragmentTransaction1.commit();
                            } else {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.container, HTFrag1);
                                fragmentTransaction1.commit();
                            }
                            break;
                        case 3:
                            Outside_Weather_Fragment OWFrag2 = new Outside_Weather_Fragment();
                            if (OWFrag2 == null) {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.add(R.id.container, OWFrag1);
                                fragmentTransaction1.commit();
                            } else {
                                FragmentTransaction fragmentTransaction1 = myFragmentManager.beginTransaction();
                                fragmentTransaction1.replace(R.id.container, OWFrag1);
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
    } // end of method onCreateOptionsMenu

}
