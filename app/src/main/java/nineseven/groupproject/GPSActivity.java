package nineseven.groupproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GPSActivity extends AppCompatActivity {

    Button gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        gps = (Button) findViewById(R.id.navigator);

        gps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.ca/maps/place/ottawa"));
        startActivity(intent);
            }
        });

    }
}
