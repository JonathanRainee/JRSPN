package com.example.blujekpharmacy.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.User;

public class Register extends AppCompatActivity {

    private Button btnRegister, btnLogin;
    private EditText etname, etemail, etpass, etconf, etphone;
    private String name, email, pass, conf, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.toRegBtn);

        btnRegister.setOnClickListener(view -> {
            set();
            Toast tst = err();
            if (tst!=null) tst.show();
            else {
                User.INSERT_USER(new User(User.id, name, email, pass, phone));
                tst = succ();
                tst.show();
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin = findViewById(R.id.toLoginPageBtn);
        btnLogin.setOnClickListener(view -> startActivity(new Intent(Register.this, Login.class)));
    }

    private void set(){
        etname = findViewById(R.id.regisName);
        name = etname.getText().toString();
        etemail = findViewById(R.id.regisMail);
        email = etemail.getText().toString();
        etpass = findViewById(R.id.regisPass);
        pass = etpass.getText().toString();
        etconf = findViewById(R.id.regisConfPass);
        conf = etconf.getText().toString();
        etphone = findViewById(R.id.regisPhone);
        phone = etphone.getText().toString();
    }

    private Toast err(){
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || conf.isEmpty() || phone.isEmpty())
            return Toast.makeText(this, "All fields should be filled", Toast.LENGTH_SHORT);
        else if (name.length()<5)
            return Toast.makeText(this, "Name length should be at least 5 characters", Toast.LENGTH_SHORT);
        else if (!email.endsWith(".com"))
            return Toast.makeText(this, "Email should ends with '.com'", Toast.LENGTH_SHORT);
        else if (!alphanum(pass))
            return Toast.makeText(this, "Password should have letters and numbers", Toast.LENGTH_SHORT);
        else if (!pass.equals(conf))
            return Toast.makeText(this, "Password and confirmed password should be the same", Toast.LENGTH_SHORT);
        return null;
    }

    private Toast succ(){
        return Toast.makeText(this, "User successfully registered.", Toast.LENGTH_SHORT);
    }

    private boolean alphanum(String str){
        boolean isChar = false, isNum = false;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) isChar = true;
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ) isChar = true;
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' ) isNum = true;
            if (isChar && isNum) break;
        }
        return isChar && isNum;
    }
}