package com.example.stevenwoo.appsupporttest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        mProgressBar = (ProgressBar)toolbar.findViewById(R.id.testProgress);

        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            PlaceholderFragment pf = new PlaceholderFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, pf)
                    .commit();
            pf.setProgressBar(mProgressBar);

        }
    }


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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.support.v4.app.Fragment {
        ProgressBar mProgressBar;
        public void setProgressBar(ProgressBar inputProgressBar){
            mProgressBar = inputProgressBar;

        }
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button hideButton =(Button)rootView.findViewById(R.id.hideButton);
            hideButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProgressBar.setVisibility(View.INVISIBLE);

                }
            });
            Button showButton=(Button)rootView.findViewById(R.id.showButton);
            showButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
            });
            return rootView;
        }
    }
}
