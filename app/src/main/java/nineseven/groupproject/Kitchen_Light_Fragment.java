package nineseven.groupproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kitchen_Light_Fragment extends Fragment {

    private Switch kitchenSwitch;
    private ImageView kitchenImage;


    public Kitchen_Light_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.kitchen_light_fragment_layout, container, false);
    } // end of method onCreateView

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kitchenSwitch = (Switch) view.findViewById(R.id.Kitchen_Light_Switch);
        kitchenImage = (ImageView) view.findViewById(R.id.Kitchen_Light);

        kitchenSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    kitchenImage.setImageResource(R.drawable.kitchen_lights_on);
                    Snackbar.make(view.findViewById(R.id.Kitchen_Light_Fragment_Layout)
                            ,"Welcome !", Snackbar.LENGTH_SHORT).show();
                } else {
                    kitchenImage.setImageResource(R.drawable.kitchen_lights_off);
                    Snackbar.make(view.findViewById(R.id.Kitchen_Light_Fragment_Layout)
                            ,"See you later !", Snackbar.LENGTH_SHORT).show();
                }
            } // end of onCheckedChanged
        });

    } // end of method onViewCreated
} // end of class Kitchen_Light_Fragment
