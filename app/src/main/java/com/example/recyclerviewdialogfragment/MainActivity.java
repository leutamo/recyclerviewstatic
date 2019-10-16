package com.example.recyclerviewdialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_dialogfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fm = getSupportFragmentManager();
        final ListItemFragment ls = new ListItemFragment();

        btn_dialogfragment = findViewById(R.id.btn_dialogfragment);

        btn_dialogfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ls.show(fm,"LS_Tag");
            }
        });
    }
}