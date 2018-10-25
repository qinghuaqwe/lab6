package edu.temple.lab6;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;

public class PaletteActivity extends Activity implements CanvasFragment.GetColorInterface {
    DetailFragment df;
    FragmentManager fm;
    public static final String COLOR_KEY = "color_name";

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void colorSelected(String selectedColor){
        if(singlePane){
            Log.d("my", "6");
            DetailFragment newFragment = DetailFragment.newInstance(selectedColor);
            Bundle bundle = new Bundle();
            bundle.putString(COLOR_KEY, "red");
            newFragment.setArguments(bundle);
            fm.beginTransaction()
                    .replace(R.id.Container_1, newFragment)
                    .addToBackStack(null)
                    .commit();
        }else{
            df.changecolorname(selectedColor);
        }

    }
}
