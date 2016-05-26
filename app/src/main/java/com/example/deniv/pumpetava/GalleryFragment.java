package com.example.deniv.pumpetava;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TabHost;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    //priekš vingrinajjumi (galeeryFragmenta)
    private View mRoot;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_gallery, null);

            TabHost tabHost = (TabHost)mRoot.findViewById(R.id.tabHost);
            tabHost.setup();

            TabHost.TabSpec tabSpec = tabHost.newTabSpec("izveidot");
            tabSpec.setContent(R.id.izveidot);
            tabSpec.setIndicator("Izveidot");
            tabHost.addTab(tabSpec);

            tabSpec = tabHost.newTabSpec("saraksts");
            tabSpec.setContent(R.id.saraksts);
            tabSpec.setIndicator("Saraksts");
            tabHost.addTab(tabSpec);

        return mRoot;
    }

}
