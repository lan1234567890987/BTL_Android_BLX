package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuyCheAct extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quy_che);


//        ActionBarSetting();
        start = (Button) findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuyCheAct.this, ThiAct.class);
                startActivity(intent);
            }
        });
    }
//    private void ActionBarSetting() {
//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Quy chế thi");
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
//    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}