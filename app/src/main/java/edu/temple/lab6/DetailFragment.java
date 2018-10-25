package edu.temple.lab6;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    View qwe;
    String color = "";
    public static final String COLOR_KEY = "color_name";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String color) {
        Log.d("my", "3");
        DetailFragment df = new DetailFragment();
        /*Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY, color);
        df.setArguments(bundle);*/
        return df;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("my", "4");
        /*if (getArguments() != null)
            color = getArguments().getString(COLOR_KEY);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("my", "5");
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        qwe = v.findViewById(R.id.detaillayout);
        if (getArguments() != null)
            color = getArguments().getString(COLOR_KEY);
        Log.d("my", "9");
        changecolor(color);
        return v;
    }

    public void changecolorname(String color) {
        changecolor(color);
    }

    public void changecolor(String color){
        qwe.setBackgroundColor(Color.parseColor(color));
    }

}
