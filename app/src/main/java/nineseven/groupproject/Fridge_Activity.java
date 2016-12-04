package nineseven.groupproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Fridge_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fridge_activity_layout);

        if (savedInstanceState == null) {
            Fridge_Fragment fridgeFragment = new Fridge_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fridge_Activity_Container, fridgeFragment)
                    .commit();
        } else {
            Fridge_Fragment fridgeFragment = new Fridge_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fridge_Activity_Container, fridgeFragment)
                    .commit();
        }
    }
}
