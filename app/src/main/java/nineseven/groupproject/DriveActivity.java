package nineseven.groupproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DriveActivity extends AppCompatActivity {

    EditText km;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        km = (EditText)findViewById(R.id.drive_km);
        save = (Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Default km", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Default km", km.getText().toString());
                editor.commit();

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("Default km", Context.MODE_PRIVATE);
        km.setText( prefs.getString("Default km", "km"));
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}

