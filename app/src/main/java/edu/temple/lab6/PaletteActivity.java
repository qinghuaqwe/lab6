package edu.temple.lab6;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;

public class PaletteActivity extends Activity {
    DetailFragment df;
    FragmentManager fm;

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("my", "6");
        singlePane = findViewById(R.id.Container_2) == null;
        df = new DetailFragment();

        fm = getFragmentManager();

        fm.beginTransaction()
                .replace(R.id.Container_1, new CanvasFragment())
                .commit();

        if (!singlePane) {
            fm.beginTransaction()
                    .replace(R.id.Container_2, df)
                    .commit();
        }

    }
}
