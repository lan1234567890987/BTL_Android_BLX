package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class TrangChuAct extends AppCompatActivity {
    LinearLayout LL_thi, LL_on, LL_luat, LL_bien;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LL_thi=(LinearLayout) findViewById(R.id.ll_thi);
        LL_on=(LinearLayout) findViewById(R.id.ll_on);
        LL_bien=(LinearLayout) findViewById(R.id.ll_bien);
        LL_luat=(LinearLayout) findViewById(R.id.ll_luat);


        LL_thi.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(TrangChuAct.this, QuyCheAct.class);
                startActivity(intent);
            }

        });

        LL_on.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuAct.this, OnThiAct.class);
                startActivity(intent);
            }

        });

        LL_bien.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuAct.this, TraBienAct.class);
                startActivity(intent);
            }

        });

        LL_luat.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChuAct.this, TraLuatAct.class);
                startActivity(intent);
            }

        });

    }
}