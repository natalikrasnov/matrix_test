package com.app.matrix_natali;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.app.matrix_natali.ui.main.DataListCatFragment;
import com.app.matrix_natali.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, DataListCatFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void messageFromParentFragment(Uri uri) {

    }

    @Override
    public void messageFromChildFragment(Uri uri) {

    }
}