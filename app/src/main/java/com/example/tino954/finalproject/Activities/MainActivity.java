package com.example.tino954.finalproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tino954.finalproject.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bSearch = (Button) findViewById(R.id.bSearch);
        final EditText etSearch = (EditText) findViewById(R.id.etSearch);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoListIntent = new Intent(MainActivity.this, VideoListActivity.class);
                videoListIntent.putExtra("request", etSearch.getText().toString());
                MainActivity.this.startActivity(videoListIntent);
            }
        });
    }
}
