package com.example.blujekpharmacy.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.controller.home.Home;
import com.example.blujekpharmacy.model.Game;
import com.example.blujekpharmacy.model.Medicine;
import com.example.blujekpharmacy.model.News;
import com.example.blujekpharmacy.model.Transaction;
import com.example.blujekpharmacy.model.User;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private Button btnRegister, btnLogin;
    private EditText etemail, etpass;
    private String email, pass;

    private boolean executed = false;

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Transaction> transactionList = new ArrayList<>();

    public static ArrayList<News> newsList = new ArrayList<>();
    public static ArrayList<Medicine> dbMed = new ArrayList<>();
    public  static  ArrayList<Game>  gameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.toLoginBtn);
        if(executed == false){
            Medicine.initMedicine();
            executed = true;
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set();
                Toast tst = err();
                if (tst!=null){
                    Log.d("tst", "testing123");
                    tst.show();
                }else{
                    startActivity(new Intent(Login.this, Home.class));
                    finish();
                }
            }
        });

        btnRegister = findViewById(R.id.toRegPageBtn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    private void set(){
        etemail = findViewById(R.id.loginMail);
        email = etemail.getText().toString();
        etpass = findViewById(R.id.loginPass);
        pass = etpass.getText().toString();
    }

    private Toast err(){
        if (email.isEmpty() || pass.isEmpty())
            return Toast.makeText(this, "All fields should be filled", Toast.LENGTH_SHORT);
        else {
            User user = User.GET_USER(email, pass);
            if (user==null)
                return Toast.makeText(this, "User is not registered yet", Toast.LENGTH_SHORT);
            else if (!user.getPassword().equals(pass))
                return Toast.makeText(this, "Credential is invalid", Toast.LENGTH_SHORT);
            else User.curr = user;
        }
        return null;
    }
}