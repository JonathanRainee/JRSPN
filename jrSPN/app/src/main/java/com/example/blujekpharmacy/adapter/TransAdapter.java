package com.example.blujekpharmacy.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.Game;
import com.example.blujekpharmacy.model.Transaction;

import java.util.ArrayList;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.TransVH> {

    ArrayList<Transaction> trans = new ArrayList<>();

    public TransAdapter(ArrayList<Transaction> trans){
        if (trans!=null && trans.size()>0) this.trans =trans;
    }

    @NonNull
    @Override
    public TransVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        return new TransVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransVH holder, int position) {
        holder.transDate.setText(trans.get(holder.getAdapterPosition()).getDate());

        Game game = Game.getGameData(trans.get(holder.getAdapterPosition()).getGameID());
        holder.tvHome.setText(game.getHomeTeam());
        holder.tvAway.setText(game.getAwayTeam());
        Log.d("hehe", String.valueOf(game.getPrice()));
        holder.tvPrice.setText(String.valueOf(game.getPrice()));
        holder.tvQty.setText(String.valueOf(trans.get(holder.getAdapterPosition()).getQuantity()));
        holder.tvTotal.setText(String.valueOf(game.getPrice() * trans.get(holder.getAdapterPosition()).getQuantity()));
    }
    @Override
    public int getItemCount() {
        return trans.size();
    }

    class TransVH extends RecyclerView.ViewHolder{
        TextView transDate, tvHome, tvAway, tvPrice, tvQty, tvTotal;

        public TransVH(@NonNull View itemView) {
            super(itemView);
            transDate = itemView.findViewById(R.id.transDate);
            tvHome = itemView.findViewById(R.id.tvHome);
            tvAway = itemView.findViewById(R.id.tvAway);
            tvQty = itemView.findViewById(R.id.tvQty);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvTotal = itemView.findViewById(R.id.tvTotal);
        }
    }
}
