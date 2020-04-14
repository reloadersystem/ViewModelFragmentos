package com.reloader.viewmodelfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new FragmentA())
                .add(R.id.container_b, new FragmentB())
                .commit();

       noteViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
       noteViewModel.getText().observe(this, new Observer<CharSequence>() {
           @Override
           public void onChanged(CharSequence charSequence) {
               Log.v("CONSOLE", "activity "+ charSequence.toString());
           }
       });

    }
}
