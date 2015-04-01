package spqrlol.cmpshw1;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    int count;
    int sec=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;

        //timer = (Chronometer) findViewById(R.id.timer);

        // Watch for button clicks.
        button = (Button) findViewById(R.id.start);
        button.setOnClickListener(Starting);

        button = (Button) findViewById(R.id.stop);
        button.setOnClickListener(Stopped);

        button = (Button) findViewById(R.id.reset);
        button.setOnClickListener(Reseting);

        button = (Button) findViewById(R.id.plus);
        button.setOnClickListener(adding);

        button = (Button) findViewById(R.id.minus);
        button.setOnClickListener(subtracting);


        //text = (TextView) this.findViewById(R.id.timer);
        //timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        //countDownTimer = new CountTimer(startTime, interval);
        //text.setText(text.getText() + String.valueOf(startTime));

        // Prevents the screen from dimming and going to sleep.
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


//        new CountDownTimer(30000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                timertext.setText("seconds remaining: " + millisUntilFinished / 1000);
//            }
//
//            public void onFinish()
//            {
//                timertext.setText("done!");
//            }
//        }.start();


    }

    private static final String TAG = "MyActivity";

    // Respond to button clicks
    View.OnClickListener Starting = new OnClickListener() {
        public void onClick(View v) {
//            Log.v(TAG, "HELLO" + count);

//            sec=60000;
            countdown();



        }

    };

    View.OnClickListener Stopped = new OnClickListener() {
        public void onClick(View v) {

//            EditText timer = (EditText)findViewById(R.id.timertext);
//            timer.setText("Stop ");

            // If stopped, count =1
            count = 1;
            Log.v(TAG, "HELLO" + count);

        }
    };

    View.OnClickListener Reseting = new OnClickListener() {
        public void onClick(View v) {
//            EditText timer = (EditText)findViewById(R.id.timertext);
//            timer.setText("Reset ");

            // If Reset, count=2
            count = 2;
            Log.v(TAG, "HELLO" + count);

        }
    };

    View.OnClickListener adding = new OnClickListener() {
        public void onClick(View v) {
            //timer.setBase(SystemClock.elapsedRealtime());
//            count = count + 60;

            EditText timer = (EditText) findViewById(R.id.timertext);

            if (timer.getText().toString().equals(""))
            {
                // This should work!

                timer.setText("");
            }

            sec=sec+60000;

            countdown();
        }
    };

    View.OnClickListener subtracting = new OnClickListener() {
        public void onClick(View v) {
            //timer.setBase(SystemClock.elapsedRealtime());
//            count = count - 60;

            EditText timer = (EditText) findViewById(R.id.timertext);

            if (timer.getText().toString().equals(""))
            {
                // This should work!

                timer.setText("");
            }

            sec=sec-60000;

            if (sec<=0){
                sec=0;
            }
            countdown();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



//    private void startCounter() {
//        if (timertext != null) {
//            timertext.cancel();
//        }
//        displayCount(count);
//        if (count > 0) {
//            timer = new CountDownTimer(count, 1000) {
//                public void onTick(long remainingTimeMillis) {
//                    count = remainingTimeMillis;
//                    displayCount(count);
//                }
//
//                public void onFinish() {
//                    displayCount(0);
//                    count = 0;
//                }
//            };
//            timer.start();
//        }
//    }



public void countdown()

    {
        EditText timer = (EditText) findViewById(R.id.timertext);

        if (timer.getText().toString().equals(""))
        {
            // This should work!

            timer.setText("");
        }


        new CountDownTimer(sec, 1000) {
            EditText timer = (EditText) findViewById(R.id.timertext);



            public void onTick(long millisUntilFinished) {
                timer.setText((millisUntilFinished/1000)/60 + ":" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("0:00");
            }
        }.start();

        sec=0;
    }





}









//        // CountDownTimer class
//        public class CountTimer extends CountDownTimer {
//
//            public CountTimer(long startTime, long interval) {
//                super(startTime, interval);
//            }
//
//            @Override
//            public void onFinish() {
//                text.setText("Time's up!");
//                timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
//            }
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                text.setText("Time remain:" + millisUntilFinished);
//                timeElapsed = startTime - millisUntilFinished;
//                timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
//            }
//        }