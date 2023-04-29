package com.example.blujekpharmacy.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.Game;
import com.example.blujekpharmacy.model.Transaction;
import com.example.blujekpharmacy.model.User;

public class DetailGame extends AppCompatActivity {

    Game game;
    ImageView detailImg;
    TextView tvDate, tvHome, tvAway, tvPricenSeat;

    EditText buyQty;
    Button goBuy;
    int qty = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_game);
        goBuy = findViewById(R.id.goBuy);

        tvDate = findViewById(R.id.tvDate);
        tvHome = findViewById(R.id.tvHome);
        tvAway = findViewById(R.id.tvAway);
        tvPricenSeat = findViewById(R.id.tvPricenSeat);

        game = (Game) getIntent().getSerializableExtra("game");

        tvDate.setText(game.getDate());
        tvHome.setText(game.getHomeTeam());
        tvAway.setText(game.getAwayTeam());
        tvPricenSeat.setText(game.getPrice()+"$ || "+game.getSeatType());

        goBuy.setOnClickListener(view -> {
            buyQty = findViewById(R.id.buyQty);
            try{
                qty = Integer.parseInt(buyQty.getText().toString());
            } catch (Exception e){
                qty = 1;
            }
            Toast tst = err();
            if (tst!=null) tst.show();
            else {
                Transaction.insertTransaction(new Transaction(User.curr.getID(), game.getId(), qty));
                tst = succ();
                tst.show();
                buyQty.setText("0");
            }
        });
    }
    private Toast err(){
        if (qty <=0) return Toast.makeText(this, "Quantity should be more than 0.", Toast.LENGTH_SHORT);
        return null;
    }

    private Toast succ(){
        return Toast.makeText(this, "Transaction successfully made.", Toast.LENGTH_SHORT);
    }
}