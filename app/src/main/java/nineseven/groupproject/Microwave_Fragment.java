/* File: Microwave_Fragment.java
 * Course: CST2335
 * Lab Sections: 013 & 015
 * Author: Mahesh Bagde
 * Date: Dec 2017
 * Description: Final Project
 */

package nineseven.groupproject;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * This class manages the user interaction to operate a microwave
 */
public class Microwave_Fragment extends Fragment {

    private int hrs;
    private int mins;
    private int secs;
    private ProgressBar progressSpinner;
    private TextView timeDisplay;
    private Button plus10min;
    private Button plus1min;
    private Button plus5sec;
    private Button defrost;
    private Button bake;
    private Button quick30;
    private Button start;
    private Button stop;
    private Button reset;
    private Vibrator vibrator;

    private static MicrowaveCountDownTimer microwaveCountDownTimer;

    public Microwave_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.microwave_fragment_layout, container, false);

    } // end of method onCreateView

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressSpinner = (ProgressBar) view.findViewById(R.id.Progress_Spinner);
        timeDisplay = (TextView) view.findViewById(R.id.Time_Display);

        plus10min = (Button) view.findViewById(R.id.Plus_Ten_Mins_Button);
        plus1min = (Button) view.findViewById(R.id.Plus_One_Min_Button);
        plus5sec = (Button) view.findViewById(R.id.Plus_Five_Secs_Button);

        defrost = (Button) view.findViewById(R.id.Defrost_Button);
        bake = (Button) view.findViewById(R.id.Bake_Button);
        quick30 = (Button) view.findViewById(R.id.Quick_30_Button);

        start = (Button) view.findViewById(R.id.Start_Button);
        stop = (Button) view.findViewById(R.id.Stop_Button);
        reset = (Button) view.findViewById(R.id.Reset_Button);

        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        plus10min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mins <= 49) {
                    mins += 10;
                } else if (mins == 50){
                    hrs += 1;
                    mins = 0;
                } else if (mins > 50) {
                    hrs += 1;
                    mins = mins%10;
                }
                displayTime(hrs, mins, secs);
            }
        }); // end of method plus10min

        plus1min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mins <= 58) {
                    mins += 1;
                } else if (mins == 59){
                    hrs += 1;
                    mins = 0;
                } else if (mins > 59) {
                    hrs += 1;
                    mins += 1;
                }
                displayTime(hrs, mins, secs);
            }
        }); // end of method plus1min

        plus5sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secs <= 54) {
                    secs += 5;
                } else if (secs >= 55) {
                    if (mins <= 98) {
                        mins += 1;
                        secs = 0;
                    } else {
                        secs = 59;
                    }
                }
                displayTime(hrs, mins, secs);
            }
        }); // end of method plus5sec

        defrost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrs = 0;
                mins = 45;
                secs = 0;
                plus10min.setEnabled(false);
                plus1min.setEnabled(false);
                plus5sec.setEnabled(false);
                defrost.setEnabled(false);
                bake.setEnabled(false);
                quick30.setEnabled(false);
                reset.setEnabled(false);
                start.setEnabled(false);
                microwaveCountDownTimer = new MicrowaveCountDownTimer(
                        convertTimeToMilliseconds(hrs, mins, secs), 1000);
                microwaveCountDownTimer.start();
                progressSpinner.setVisibility(view.VISIBLE);
            }
        }); // end of method

        bake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrs = 0;
                mins = 90;
                secs = 0;
                plus10min.setEnabled(false);
                plus1min.setEnabled(false);
                plus5sec.setEnabled(false);
                defrost.setEnabled(false);
                bake.setEnabled(false);
                quick30.setEnabled(false);
                reset.setEnabled(false);
                start.setEnabled(false);
                microwaveCountDownTimer = new MicrowaveCountDownTimer(
                        convertTimeToMilliseconds(hrs, mins, secs), 1000);
                microwaveCountDownTimer.start();
                progressSpinner.setVisibility(view.VISIBLE);
            }
        }); // end of method

        quick30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrs = 0;
                mins = 0;
                secs = 30;
                plus10min.setEnabled(false);
                plus1min.setEnabled(false);
                plus5sec.setEnabled(false);
                defrost.setEnabled(false);
                bake.setEnabled(false);
                quick30.setEnabled(false);
                reset.setEnabled(false);
                start.setEnabled(false);
                microwaveCountDownTimer = new MicrowaveCountDownTimer(
                        convertTimeToMilliseconds(hrs, mins, secs), 1000);
                microwaveCountDownTimer.start();
                progressSpinner.setVisibility(view.VISIBLE);
            }
        }); // end of method

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus10min.setEnabled(false);
                plus1min.setEnabled(false);
                plus5sec.setEnabled(false);
                defrost.setEnabled(false);
                bake.setEnabled(false);
                quick30.setEnabled(false);
                reset.setEnabled(false);
                start.setEnabled(false);
                    microwaveCountDownTimer = new MicrowaveCountDownTimer(
                            convertTimeToMilliseconds(hrs, mins, secs), 1000);
                    microwaveCountDownTimer.start();
                progressSpinner.setVisibility(view.VISIBLE);
            }
        }); // end of method start

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus10min.setEnabled(true);
                plus1min.setEnabled(true);
                plus5sec.setEnabled(true);
                defrost.setEnabled(true);
                bake.setEnabled(true);
                quick30.setEnabled(true);
                reset.setEnabled(true);
                start.setEnabled(true);
                microwaveCountDownTimer.cancel();
                displayTime(hrs, mins, secs);
                progressSpinner.setVisibility(view.INVISIBLE);
            }
        }); // end of method stop

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrs = 0;
                mins = 0;
                secs = 0;
                microwaveCountDownTimer.cancel();
                displayTime(hrs, mins, secs);
                progressSpinner.setVisibility(view.INVISIBLE);
            }
        }); // end of method reset

    } // end of method onViewCreated

    // extends the CountDownTimer class to use the feature for microwave
    public class MicrowaveCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MicrowaveCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        } // end of constructor

        // displays the time remaining to cook
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            int hours = (int) ((millis / 3600000)% 24);
            int minutes = (int) ((millis / 60000) % 60);
            int seconds = (int) ((millis / 1000) % 60);
            hrs = hours;
            mins = minutes;
            secs = seconds;
            displayTime(hrs, mins, secs);
        } // end of method onTick

        @Override
        public void onFinish() {
            hrs = 0;
            mins = 0;
            secs = 0;
            timeDisplay.setText("Done!");
            plus10min.setEnabled(true);
            plus1min.setEnabled(true);
            plus5sec.setEnabled(true);
            defrost.setEnabled(true);
            bake.setEnabled(true);
            quick30.setEnabled(true);
            reset.setEnabled(true);
            start.setEnabled(true);
            progressSpinner.setVisibility(View.INVISIBLE);
            vibrator.vibrate(1000);
        } // end of method onFinish
    } // end of class MicrowaveCountDownTimer

    // converts time input into milliseconds
    public long convertTimeToMilliseconds(int h, int m, int s) {
        long hrs = h * 3600000;
        long min = m * 60000;
        long sec = s * 1000;
        return hrs + min + sec;
    } // end of method convertTimeToMilliseconds

    // displays time as per hh:mm:ss requirement or mm:ss requirement
    public void displayTime(int h, int m, int s) {
        if (hrs > 0) {
            timeDisplay.setText(String.format("%02d:%02d:%02d",hrs, mins, secs));
        } else {
            timeDisplay.setText(String.format("%02d:%02d", mins, secs));
        }
    } // end of method displayTime

} // end of Microwave_Fragment
