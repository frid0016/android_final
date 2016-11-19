package nineseven.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AutomobileActivity extends AppCompatActivity {
    String[] Automobile = {"GPS", "Temperature", "Lights", "Radio", "Fuel", "Odometer"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile);

        listView = (ListView) findViewById(R.id.Automobile_List_View);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Automobile);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent GPSIntent = new Intent(AutomobileActivity.this, GPSActivity.class);
                        startActivity(GPSIntent);
                        break;

                    case 1:
                        Intent temperatureIntent = new Intent(AutomobileActivity.this, TemperatureActivity.class);
                        startActivity(temperatureIntent);
                        break;

                    case 2:
                        Intent lightsIntent = new Intent(AutomobileActivity.this, LightsActivity.class);
                        startActivity(lightsIntent);
                        break;
                    case 3:
                        Intent radioIntent = new Intent(AutomobileActivity.this, RadioActivity.class);
                        startActivity(radioIntent);
                        break;
                    case 4:
                        Intent fuelIntent = new Intent(AutomobileActivity.this, FuelActivity.class);
                        startActivity(fuelIntent);
                        break;
                    case 5:
                        Intent odometerIntent = new Intent(AutomobileActivity.this, OdometerActivity.class);
                        startActivity(odometerIntent);
                        break;
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
