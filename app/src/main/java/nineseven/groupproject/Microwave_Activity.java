package nineseven.groupproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Microwave_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.microwave_activity_layout);

        if (savedInstanceState == null) {
            Microwave_Fragment microwaveFragment = new Microwave_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Microwave_Activity_Container, microwaveFragment)
                    .commit();
        } else {
            Microwave_Fragment microwaveFragment = new Microwave_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Microwave_Activity_Container, microwaveFragment)
                    .commit();
        }
    }
}
