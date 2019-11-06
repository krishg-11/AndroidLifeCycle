package traf1.ganotrakrish.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mPreferences;
    int startCount;
    int createCount;
    int resumeCount;
    int pauseCount;
    int stopCount;
    int restartCount;
    int destroyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("com.traf1.ganotrakrish.androidlifecycle", Context.MODE_PRIVATE);

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Create Count", mPreferences.getInt("Create Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Create Count: " + mPreferences.getInt("Create Count", 0));


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Start Count", mPreferences.getInt("Start Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Start Count: " + mPreferences.getInt("Start Count", 0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Resume Count", mPreferences.getInt("Resume Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Resume Count: " + mPreferences.getInt("Resume Count", 0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Pause Count", mPreferences.getInt("Pause Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Pause Count" + mPreferences.getInt("Pause Count", 0));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Stop Count", mPreferences.getInt("Stop Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Stop Count: " + mPreferences.getInt("Stop Count", 0));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Restart Count", mPreferences.getInt("Restart Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Restart Count: " + mPreferences.getInt("Restart Count", 0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt("Destroy Count", mPreferences.getInt("Destroy Count", 0) + 1);
        preferencesEditor.apply();
        System.out.println("Destroy Count: " + mPreferences.getInt("Destroy Count", 0));
    }
}
