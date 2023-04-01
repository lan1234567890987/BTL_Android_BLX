package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import object.TaiKhoan;

public class RegisterAct extends AppCompatActivity {
    EditText edName,edPass;
    Button btnluu;
    TextView txtNoteU,txtNoteP;

    DBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(RegisterAct.this);
//        db.createTaiKhoan();
        btnluu = (Button) findViewById(R.id.btnLuu);
        edName = (EditText) findViewById(R.id.editTextName);
        edPass = (EditText) findViewById(R.id.editTextPassword);
        txtNoteU = (TextView) findViewById(R.id.txtNoteU);
        txtNoteP = (TextView) findViewById(R.id.txtNoteP);
        txtNoteU.setVisibility(View.GONE);
        txtNoteP.setVisibility(View.GONE);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    String UserName = edName.getText().toString();
                    String Password = edPass.getText().toString();

                    if (!db.isUsernameExists(UserName)){
                        db.insertDbTaiKhoan(new TaiKhoan(UserName,Password));
                        Toast.makeText(getApplicationContext(), "Successed!", Toast.LENGTH_SHORT).show();
                        Intent dangky = new Intent(RegisterAct.this, MainActivity.class);
                        startActivities(new Intent[]{dangky});
                    }else{
                        Toast.makeText(getApplicationContext(), "Tên đăng nhập đã tồn tại!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
    public boolean validate() {
        boolean valid = false;
        String UserName = edName.getText().toString();
        String Password = edPass.getText().toString();
        if( UserName.isEmpty() ){
            valid=false;
            txtNoteU.setError("Mời nhập tên đăng nhập! VD : ABC");
        }else{
            if(UserName.length()>2) {
                valid = true;
                txtNoteU.setError(null);
            }else{
                valid=false;
                txtNoteU.setError("Tên đăng nhập cần it nhất 3 ký tự!");
            }
        }

        if( Password.isEmpty() ){
            valid=false;
            txtNoteU.setError("Mời nhập mật khẩu!");
        }else{
            if(UserName.length()>5) {
                valid = true;
                txtNoteU.setError(null);
            }else{
                valid=false;
                txtNoteU.setError("Mật khẩu cần it nhất 5 ký tự!");
            }
        }

        return valid;
    }
}



















