package com.example.deniv.pumpetava;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    List<Vingrinajumi> Vingrinajumi = new ArrayList<Vingrinajumi>();////////////////////
    ListView vingrListWiev;
    //////

    /*
    EditText nametxt, koments;
    nametxt = (EditText) findViewById(R.id.editText);
    koments = (EditText) findViewById(R.id.editText2);
    final Button addBtn = (Button) findViewById(R.id.create_btn);
    nametxt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            addBtn.setEnabled(!nametxt.getText().toString().trim().isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });
    */

    // Inflate the layout for this fragment

    //////
    public void populateList(){
        vingrListWiev = (ListView) findViewById(R.id.listView);
        ArrayAdapter<Vingrinajumi> adapter = new VingrinajumiListAdapter();
        vingrListWiev.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




                //set the fragment initialy
        mainFragment fragment = new mainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction=
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //set the fragment initialy
            mainFragment fragment = new mainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_gallery) {


            //set the fragment initialy
            GalleryFragment fragment = new GalleryFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_slideshow) {
            SlideFragment fragment = new SlideFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_manage) {
            ToolsFragment fragment = new ToolsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    Button sakt;
    Chronometer pulkst;
    long timeWhenStopped = 0;
    Boolean running=false;

    public void skaitit(View view) {

        if (!running){
            pulkst = (Chronometer) findViewById(R.id.chronometer);
            pulkst.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
            pulkst.start();
            pulkst.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            running =true;
        }else{
            pulkst = (Chronometer) findViewById(R.id.chronometer);
            timeWhenStopped = pulkst.getBase() - SystemClock.elapsedRealtime();
            pulkst.setBackgroundColor(getResources().getColor(R.color.colorDivider));
            pulkst.stop();
            running =false;
        }
    }
    public void stop(View view) {
        pulkst = (Chronometer) findViewById(R.id.chronometer);
        timeWhenStopped = pulkst.getBase() - SystemClock.elapsedRealtime();
        pulkst.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        pulkst.stop();
        running =false;
    }
/*

* */
    public void vingrinajumiOnClick(View view) {

        EditText nametxt, koments;
        nametxt = (EditText) findViewById(R.id.editText);
        koments = (EditText) findViewById(R.id.editText2);

        addVingr(nametxt.getText().toString(),koments.getText().toString());

        populateList();
        Toast.makeText(getApplicationContext(),
                "Vingrinājums "+nametxt.getText().toString()+" pievienots :)", Toast.LENGTH_LONG).show();
    }

    /////////////////////////////////////

    private void addVingr(String nosauk, String koments){
        Vingrinajumi.add(new Vingrinajumi (nosauk, koments) );
    }

    private class VingrinajumiListAdapter extends ArrayAdapter<Vingrinajumi> {


        public VingrinajumiListAdapter(){
            super (MainActivity.this, R.layout.listview_item,Vingrinajumi); // Mainactivity.this getact vietaaa!!!!!!
        }
        @Override
        public View getView(int position, View view, ViewGroup parent){
            if (view == null){
                view= getLayoutInflater().inflate(R.layout.listview_item,parent,false);
            }

            Vingrinajumi currentVingrinajumi = Vingrinajumi.get(position);

            TextView nosauk = (TextView) view.findViewById(R.id.textViewVingrinajums);
            nosauk.setText(currentVingrinajumi.getNosauk());
            TextView koment = (TextView) view.findViewById(R.id.textViewkoments);
            koment.setText(currentVingrinajumi.getKoments());

            return view;
        }
    }



}
