package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import object.TaiKhoan;

public class MainActivity extends AppCompatActivity {

    EditText edName,edPass;
    Button btnDN;
    TextView txtQuen, txtDky;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(MainActivity.this);

        btnDN = (Button)findViewById(R.id.btnDangNhap);
        edName = (EditText)findViewById(R.id.txtName);
        edPass = (EditText)findViewById(R.id.txtPassword);
        txtQuen = (TextView)findViewById(R.id.txtQuenmk);
        txtDky = (TextView)findViewById(R.id.txtDangKi);


        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()){

                    String UserName = edName.getText().toString();
                    String Password = edPass.getText().toString();

                    Boolean check = db.checkUP( UserName,Password );
                    if(check == true){
                        Toast.makeText(getApplicationContext(), "Successed!", Toast.LENGTH_SHORT).show();
                        Intent dangnhap = new Intent(MainActivity.this, TrangChuAct.class);
                        startActivities(new Intent[]{dangnhap});
                    }else{
                        Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        txtDky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dki = new Intent(MainActivity.this, RegisterAct.class);
                startActivities(new Intent[]{dki});
            }
        });
//        txtQuen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent dki = new Intent(MainActivity.this, RegisterAct.class);
//                startActivities(new Intent[]{dki});
//            }
//        });



    }
    public boolean validate() {
        boolean valid = false;
        String UserName = edName.getText().toString();
        String Password = edPass.getText().toString();
        if( UserName.isEmpty() ){
            valid=false;
//            txtNoteU.setError("Mời nhập tên đăng nhập! VD : ABC");
        }else{
            if(UserName.length()>2) {
                valid = true;
//                txtNoteU.setError(null);
            }else{
                valid=false;
//                txtNoteU.setError("Tên đăng nhập cần it nhất 3 ký tự!");
            }
        }

        if( Password.isEmpty() ){
            valid=false;
//            txtNoteU.setError("Mời nhập mật khẩu!");
        }else{
            if(UserName.length()>5) {
                valid = true;
//                txtNoteU.setError(null);
            }else{
                valid=false;
//                txtNoteU.setError("Mật khẩu cần it nhất 5 ký tự!");
            }
        }
        return valid;
    }
}
