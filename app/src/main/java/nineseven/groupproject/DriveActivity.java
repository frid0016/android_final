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
import android.widget.TextView;

import java.util.ArrayList;

public class DriveActivity extends AppCompatActivity {

    EditText km;
    Button save;
    TextView total;
    Button reset;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        km = (EditText)findViewById(R.id.drive_km);
        save = (Button)findViewById(R.id.save);
        total = (TextView)findViewById(R.id.total_show);
        reset = (Button) findViewById(R.id.reset);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Default km", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Default km", km.getText().toString());
                editor.commit();


                sum += Integer.parseInt(km.getText().toString());
                total.setText(sum + "");

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sum = 0;
                total.setText(sum + "");
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

