package com.example.blujekpharmacy.adapter;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

//import com.squareup.picasso.Picasso;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.model.Medicine;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.MedVH> {

    ArrayList<Medicine> meds = new ArrayList<>();
    private  MedClickListener listener;

    public MedAdapter(ArrayList<Medicine> medss, MedClickListener listener){
        this.meds = medss;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MedVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_item, parent, false);
        return new MedVH(v, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull MedVH holder, int position) {
        holder.medName.setText(meds.get(position).getName());
        holder.medManu.setText(meds.get(position).getManufacturer());
        holder.medPrice.setText("Rp" + meds.get(position).getPrice());
        holder.medImg.setImageResource(Integer.parseInt(meds.get(position).getImage()));
    }


    @Override
    public int getItemCount() {
        return meds.size();
    }

    class MedVH extends RecyclerView.ViewHolder{
        TextView medManu, medName, medPrice;
        ImageView medImg;
        CardView cvMed;
        public MedVH(@NonNull View itemView, MedClickListener listener) {
            super(itemView);
            medManu = itemView.findViewById(R.id.medManu);
            medName = itemView.findViewById(R.id.medName);
            medPrice = itemView.findViewById(R.id.medPrice);
            medImg = itemView.findViewById(R.id.medImg);
            cvMed = itemView.findViewById(R.id.cvMed);
            cvMed.setOnClickListener(x -> {
                listener.onMedClicked(getAdapterPosition());
            });
        }
    }
    public interface MedClickListener{
        void onMedClicked(int pos);
    }
}
