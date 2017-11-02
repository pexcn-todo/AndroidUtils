package me.pexcn.android.utils.samples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pexcn on 2017-04-18.
 */
public class MainActivity extends AppCompatActivity {
    boolean debug = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.show).setOnClickListener(view -> {

        });

        findViewById(R.id.cancel).setOnClickListener(view -> {

        });
    }
}
