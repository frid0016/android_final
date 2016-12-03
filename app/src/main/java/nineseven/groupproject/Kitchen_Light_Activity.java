package nineseven.groupproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Kitchen_Light_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_light_activity_layout);

        if (savedInstanceState == null) {
            Kitchen_Light_Fragment kitchenLightFragment = new Kitchen_Light_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Kitchen_Light_Activity_Container, kitchenLightFragment)
                    .commit();
        } else {
            Kitchen_Light_Fragment kitchenLightFragment = new Kitchen_Light_Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Kitchen_Light_Activity_Container, kitchenLightFragment)
                    .commit();
        }
    }
}
