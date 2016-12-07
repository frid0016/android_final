package nineseven.groupproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class OdometerActivity extends AppCompatActivity {

    TextView total;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odometer);

        total = (TextView)findViewById(R.id.total_show);

        SharedPreferences myPrefs = getSharedPreferences("Default km", MODE_PRIVATE);
        String kilom = myPrefs.getString("Default km", "km");

        int num = Integer.parseInt(kilom);


        list.add(num);

        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        total.setText(sum + "");
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStart(){
        super.onStart();
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
