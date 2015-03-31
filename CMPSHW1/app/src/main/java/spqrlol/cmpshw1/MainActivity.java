package spqrlol.cmpshw1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends Activity {

    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;

        timer = (Chronometer) findViewById(R.id.timer);

        // Watch for button clicks.
        button = (Button) findViewById(R.id.start);
        button.setOnClickListener(Starting);

        button = (Button) findViewById(R.id.stop);
        button.setOnClickListener(Stopped);

        button = (Button) findViewById(R.id.reset);
        button.setOnClickListener(Reseting);

//        button = (Button) findViewById(R.id.plus);
//        button.setOnClickListener(mResetListener);
//
//        button = (Button) findViewById(R.id.minus);
//        button.setOnClickListener(mResetListener);



        // Prevents the screen from dimming and going to sleep.
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


    View.OnClickListener Starting = new OnClickListener() {
        public void onClick(View v) {
            timer.start();
        }
    };

    View.OnClickListener Stopped = new OnClickListener() {
        public void onClick(View v) {
            timer.stop();
        }
    };

    View.OnClickListener Reseting = new OnClickListener() {
        public void onClick(View v) {
            timer.setBase(SystemClock.elapsedRealtime());
        }
    };

//    View.OnClickListener Stopped = new OnClickListener() {
//        public void onClick(View v) {
//            timer.stop();
//        }
//    };
//
//    View.OnClickListener Reseting = new OnClickListener() {
//        public void onClick(View v) {
//            timer.setBase(SystemClock.elapsedRealtime());
//        }
//    };

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
}
