package com.example.arabamapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.arabamapp.MainActivity;
import com.example.arabamapp.Model.CarModel;
import com.example.arabamapp.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyViewHolder>{

    private Context context;
    private OnClickListener onClickListener;
    private List<CarModel> carModelList;

    public CarListAdapter(Context context, List<CarModel> carModelList) {
        this.context = context;
        this.carModelList = carModelList;
    }

    public void setCarList(List<CarModel> carModelList) {
        this.carModelList = carModelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CarListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carlist_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.modelNameTV.setText(this.carModelList.get(position).getModelName());
        holder.carTitleTV.setText(this.carModelList.get(position).getTitle());
        holder.townNameTV.setText(this.carModelList.get(position).getLocation().getTownName() + ", ");
        holder.cityNameTV.setText(this.carModelList.get(position).getLocation().getCityName());
        holder.dateTV.setText(this.carModelList.get(position).getDateFormatted());
        holder.carColorTV.setText(this.carModelList.get(position).getProperties().get(0).getName().substring(0, 1).toUpperCase()
                + this.carModelList.get(position).getProperties().get(0).getName().substring(1)
                + ": " + this.carModelList.get(position).getProperties().get(0).getValue());
        holder.carKmTV.setText(this.carModelList.get(position).getProperties().get(1).getName().substring(0, 1).toUpperCase()
                + this.carModelList.get(position).getProperties().get(1).getName().substring(1)
                + ": " + this.carModelList.get(position).getProperties().get(1).getValue());
        holder.carYearTV.setText(this.carModelList.get(position).getProperties().get(2).getName().substring(0, 1).toUpperCase()
                + this.carModelList.get(position).getProperties().get(2).getName().substring(1)
                + ": " + this.carModelList.get(position).getProperties().get(2).getValue());
        holder.carPriceTV.setText("" + this.carModelList.get(position).getPriceFormatted());
        Glide.with(context)
                .load(this.carModelList.get(position).getPhoto().replace("{0}", "800x600"))
                .centerCrop()
                .placeholder(R.drawable.carplaceholder)
                .into(holder.carImageView);
    }

    @Override
    public int getItemCount() {
        if(this.carModelList != null) {
            return this.carModelList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView carImageView;
        TextView modelNameTV;
        TextView carTitleTV;
        TextView townNameTV;
        TextView cityNameTV;
        TextView dateTV;
        TextView carColorTV;
        TextView carKmTV;
        TextView carYearTV;
        TextView carPriceTV;
        public MyViewHolder(View itemView) {
            super(itemView);
            carImageView = itemView.findViewById(R.id.car_image);
            modelNameTV = itemView.findViewById(R.id.model_name);
            carTitleTV = itemView.findViewById(R.id.car_title);
            townNameTV = itemView.findViewById(R.id.town_name);
            cityNameTV = itemView.findViewById(R.id.city_name);
            dateTV = itemView.findViewById(R.id.date);
            carColorTV = itemView.findViewById(R.id.car_color);
            carKmTV = itemView.findViewById(R.id.car_km);
            carYearTV = itemView.findViewById(R.id.car_year);
            carPriceTV = itemView.findViewById(R.id.car_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(onClickListener != null && position != RecyclerView.NO_POSITION) {
                        int id = Math.round(carModelList.get(position).getId());
                        onClickListener.onClick(id); //ID'LERİ TEKRAR KONTROL ET
                    }
                }
            });

        }
    }

    public interface OnClickListener {
        void onClick(int id);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


}
