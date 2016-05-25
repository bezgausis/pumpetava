package com.example.deniv.pumpetava;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    Button sakt;
    Chronometer pulkst;

    public GalleryFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    public void skaitit(View view) {
        sakt = (Button) getView().findViewById(R.id.main_button);
        pulkst = (Chronometer) getView().findViewById(R.id.chronometer);
        pulkst.setBase(SystemClock.elapsedRealtime());
        pulkst.start();
        return;
    }
}
