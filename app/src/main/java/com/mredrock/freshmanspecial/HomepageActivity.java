package com.mredrock.freshmanspecial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomepageActivity extends AppCompatActivity {

    private ImageButton a1;
    private ImageButton b1;
    private ImageButton c1;
    private ImageButton d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_main);

        a1 = (ImageButton) findViewById(R.id.a1);
        b1 = (ImageButton) findViewById(R.id.b1);
        c1 = (ImageButton) findViewById(R.id.c1);
        d1 = (ImageButton) findViewById(R.id.d1);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
