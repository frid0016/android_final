package nineseven.groupproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Microwave_Fragment extends Fragment {

    private EditText cookingTimeInput;
    private TextView timeRemaining;
    private Button start;
    private Button stop;
    private Button reset;

    private MicrowaveCountDownTimer microwaveCountDownTimer;


    public Microwave_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.microwave_fragment_layout, container, false);

    } // end of method onCreateView

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cookingTimeInput = (EditText) view.findViewById(R.id.Cooking_Time_Input);
        timeRemaining = (TextView) view.findViewById(R.id.Time_Remaining_View);
        start = (Button) view.findViewById(R.id.Start_Button);
        stop = (Button) view.findViewById(R.id.Stop_Button);
        reset = (Button) view.findViewById(R.id.Reset_Button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                microwaveCountDownTimer = new MicrowaveCountDownTimer
                        (Long.parseLong(cookingTimeInput.getText().toString()) * 1000, 1000, timeRemaining);
                microwaveCountDownTimer.start();
            }
        });
    }

    public class MicrowaveCountDownTimer extends CountDownTimer {
        TextView timeRemaining;

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MicrowaveCountDownTimer(long millisInFuture, long countDownInterval, TextView timeRemaining) {
            super(millisInFuture, countDownInterval);
            this.timeRemaining = timeRemaining;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timeRemaining.setText(String.valueOf(millisUntilFinished));

        }

        @Override
        public void onFinish() {
            timeRemaining.setText("Done!");
        }
    } // end of class MicrowaveCountDownTimer

} // end of Microwave_Fragment
