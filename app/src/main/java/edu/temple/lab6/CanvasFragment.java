package edu.temple.lab6;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {
    GridView gridview;
    Context parents;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.parents = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("my", "1");
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        gridview = v.findViewById(R.id.gridview);
        Resources res = getResources();
        final String [] color1 = res.getStringArray(R.array.Color_1);
        ColorAdapter adapter = new ColorAdapter(parents, color1);
        gridview.setAdapter(adapter);
        //gridview.setAdapter(new ArrayAdapter<>(parents, android.R.layout.simple_list_item_1, parents,getResources().getStringArray(R.array.Color_1)));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String Color = (String) parentView.getItemAtPosition(position);
                Log.d("my", "2");
                String selectedColor = parent.getItemAtPosition(position).toString();
                ((GetColorInterface) parents).colorSelected(selectedColor);
            }
        });
        return v;
    }

    interface GetColorInterface{
        void colorSelected(String selectedColor);
    }

}
