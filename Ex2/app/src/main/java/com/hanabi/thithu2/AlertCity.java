package com.hanabi.thithu2;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.hanabi.thithu2.models.City;

public class AlertCity extends DialogFragment {

    private City city;
    private TextView tvTitle;
    private TextView tvContent;
    private Button btnOk;
    private ImageView imageView;

    public AlertCity(City city) {
        this.city = city;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.alert_city, container, false);
        btnOk = v.findViewById(R.id.btn_ok);
        tvTitle = v.findViewById(R.id.tv_title);
        tvContent = v.findViewById(R.id.tv_content);
        imageView = v.findViewById(R.id.iv_image);

        bindCity();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return v;
    }

    private void bindCity() {
        tvTitle.setText(city.getTitle());
        tvContent.setText(city.getContent());
        imageView.setImageResource(city.getImageId());
    }
}
