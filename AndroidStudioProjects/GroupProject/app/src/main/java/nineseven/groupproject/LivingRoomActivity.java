package nineseven.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_launch_screen, menu);
        return true;
    }
}
