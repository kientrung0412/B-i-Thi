package com.hanabi.thithu2.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanabi.thithu2.models.City;
import com.hanabi.thithu2.R;


import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.HolderCity> {

    private LayoutInflater layoutInflater;
    private ArrayList<City> data;
    private OnClickCityListener listener;

    public CityAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setListener(OnClickCityListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<City> city) {
        this.data = city;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderCity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new HolderCity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCity holder, int position) {
        final City city = data.get(position);
        holder.bindView(city);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickCity(city);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class HolderCity extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvContent;
        private ImageView image;

        public HolderCity(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTitle = itemView.findViewById(R.id.tv_title);
            image = itemView.findViewById(R.id.iv_image);
        }

        private void bindView(City city) {
            tvContent.setText(city.getContent());
            tvTitle.setText(city.getTitle());
            image.setImageResource(city.getImageId());
        }
    }

    public interface OnClickCityListener {
        void onClickCity(City city);

        void onClickLongCity(City city);
    }

}
