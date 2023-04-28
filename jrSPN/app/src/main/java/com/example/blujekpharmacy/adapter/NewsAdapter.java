package com.example.blujekpharmacy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.Medicine;
import com.example.blujekpharmacy.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH>{

    ArrayList<News> news = new ArrayList<>();
    private NewsClickListener listener;

    public NewsAdapter(ArrayList<News> news){
        this.news = news;
    }

    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsVH(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsVH holder, int position) {
        holder.tvTitle.setText(news.get(position).getTitle());
        holder.tvNews.setText(news.get(position).getNews());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class NewsVH extends RecyclerView.ViewHolder{
        TextView tvTitle, tvNews;
        CardView cvNews;

        public NewsVH(@NonNull View itemView, NewsClickListener listener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvNews = itemView.findViewById(R.id.tvNews);
            cvNews = itemView.findViewById(R.id.cvNews);
            cvNews.setOnClickListener(x -> {
                listener.onNewsClicked(getAdapterPosition());
            });
        }
    }

    public interface NewsClickListener{
        void onNewsClicked(int pos);
    }
}
