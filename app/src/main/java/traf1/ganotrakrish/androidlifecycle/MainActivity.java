package traf1.ganotrakrish.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mPreferences;
    Counters count = new Counters();

    TextView createdInstallDisplay;
    TextView createdRestartDisplay;
    TextView startedInstallDisplay;
    TextView startedRestartDisplay;
    TextView resumedInstallDisplay;
    TextView resumedRestartDisplay;
    TextView pausedInstallDisplay;
    TextView pausedRestartDisplay;
    TextView stoppedInstallDisplay;
    TextView stoppedRestartDisplay;
    TextView restartedInstallDisplay;
    TextView restartedRestartDisplay;
    TextView destroyedInstallDisplay;
    TextView destroyedRestartDisplay;

    Button resetInstall;
    Button resetRestart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createdInstallDisplay = findViewById(R.id.created1Counter);
        createdRestartDisplay = findViewById(R.id.created2Counter);
        startedInstallDisplay = findViewById(R.id.started1Counter);
        startedRestartDisplay = findViewById(R.id.started2Counter);
        resumedInstallDisplay = findViewById(R.id.resumed1Counter);
        resumedRestartDisplay = findViewById(R.id.resumed2Counter);
        pausedInstallDisplay = findViewById(R.id.paused1Counter);
        pausedRestartDisplay = findViewById(R.id.paused2Counter);
        stoppedInstallDisplay = findViewById(R.id.stopped1Counter);
        stoppedRestartDisplay = findViewById(R.id.stopped2Counter);
        restartedInstallDisplay = findViewById(R.id.restarted1Counter);
        restartedRestartDisplay = findViewById(R.id.restarted2Counter);
        destroyedInstallDisplay = findViewById(R.id.destroyed1Counter);
        destroyedRestartDisplay = findViewById(R.id.destroyed2Counter);

        resetInstall = findViewById(R.id.resetInstall);
        resetRestart = findViewById(R.id.resetRestart);

        resetInstall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putInt("Create Count", 0);
                preferencesEditor.putInt("Start Count", 0);
                preferencesEditor.putInt("Resume Count", 0);
                preferencesEditor.putInt("Pause Count", 0);
                preferencesEditor.putInt("Stop Count", 0);
                preferencesEditor.putInt("Restart Count", 0);
                preferencesEditor.putInt("Destroy Count", 0);
                preferencesEditor.apply();
                display();
            }
        });
        resetRestart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                count = new Counters();
                display();
            }
        });

        mPreferences = getSharedPreferences("com.traf1.ganotrakrish.androidlifecycle", Context.MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Create Count", mPreferences.getInt("Create Count", 0) + 1);
        preferencesEditor.apply();


        count.setCreateCount(count.getCreateCount()+1);

        display();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Start Count", mPreferences.getInt("Start Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Start Count: " + mPreferences.getInt("Start Count", 0));

        count.setStartCount(count.getStartCount()+1);

        display();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Resume Count", mPreferences.getInt("Resume Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Resume Count: " + mPreferences.getInt("Resume Count", 0));

        count.setResumeCount(count.getResumeCount()+1);

        display();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Pause Count", mPreferences.getInt("Pause Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Pause Count" + mPreferences.getInt("Pause Count", 0));

        count.setPauseCount(count.getPauseCount()+1);

        display();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Stop Count", mPreferences.getInt("Stop Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Stop Count: " + mPreferences.getInt("Stop Count", 0));

        count.setStopCount(count.getStopCount() + 1);

        display();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        count = new Counters();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Restart Count", mPreferences.getInt("Restart Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Restart Count: " + mPreferences.getInt("Restart Count", 0));

        count.setRestartCount(count.getRestartCount() + 1);

        display();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Destroy Count", mPreferences.getInt("Destroy Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Destroy Count: " + mPreferences.getInt("Destroy Count", 0));

        count.setDestroyCount(count.getDestroyCount() + 1);

        display();
    }



    public void display(){
        createdInstallDisplay.setText("" + mPreferences.getInt("Create Count", 0));
        createdRestartDisplay.setText("" + count.getCreateCount());

        startedInstallDisplay.setText("" + mPreferences.getInt("Start Count", 0));
        startedRestartDisplay.setText("" + count.getStartCount());

        resumedInstallDisplay.setText("" + mPreferences.getInt("Resume Count", 0));
        resumedRestartDisplay.setText("" + count.getResumeCount());

        pausedInstallDisplay.setText("" + mPreferences.getInt("Pause Count", 0));
        pausedRestartDisplay.setText("" + count.getPauseCount());

        stoppedInstallDisplay.setText("" + mPreferences.getInt("Stop Count", 0));
        stoppedRestartDisplay.setText("" + count.getStopCount());

        restartedInstallDisplay.setText("" + mPreferences.getInt("Restart Count", 0));
        restartedRestartDisplay.setText("" + count.getRestartCount());

        destroyedInstallDisplay.setText("" + mPreferences.getInt("Destroy Count", 0));
        destroyedRestartDisplay.setText("" + count.getDestroyCount());
    }
}

