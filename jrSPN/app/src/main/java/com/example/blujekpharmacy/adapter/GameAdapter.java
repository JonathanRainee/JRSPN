package com.example.blujekpharmacy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.Game;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameVH> {

    ArrayList<Game> games = new ArrayList<>();

    private GameClickListener listener;

    public GameAdapter(ArrayList<Game> games, GameClickListener listener){
        this.games = games;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GameVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        return new GameVH(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull GameVH holder, int position) {
        holder.tvDate.setText(games.get(position).getDate());
        holder.tvHome.setText(games.get(position).getHomeTeam());
        holder.tvAway.setText(games.get(position).getAwayTeam());
        holder.tvPricenSeat.setText(games.get(position).getPrice() +"$ || "+games.get(position).getSeatType());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class GameVH extends RecyclerView.ViewHolder{
        TextView tvDate, tvHome, tvVs, tvAway, tvPricenSeat;
        CardView cvGame;


        public GameVH(@NonNull View itemView, GameClickListener listener) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvHome = itemView.findViewById(R.id.tvHome);
            tvVs = itemView.findViewById(R.id.tvVs);
            tvAway = itemView.findViewById(R.id.tvAway);
            tvPricenSeat = itemView.findViewById(R.id.tvPricenSeat);
            cvGame = itemView.findViewById(R.id.cvGame);
            cvGame.setOnClickListener(x -> {
                listener.onGameClicked(getAdapterPosition());
            });
        }
    }

    public interface GameClickListener{
        void onGameClicked(int pos);
    }

}
