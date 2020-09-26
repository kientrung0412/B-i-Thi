package com.hanabi.thithu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hanabi.thithu2.adapter.CityAdapter;
import com.hanabi.thithu2.models.City;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CityAdapter.OnClickCityListener {

    private RecyclerView recyclerView;
    private CityAdapter adapter;
    private ArrayList<City> cities = new ArrayList<>();
    private AlertCity alertCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fillData();
        adapter.setData(cities);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rcv_main);
        adapter = new CityAdapter(getLayoutInflater());
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void fillData() {
        cities.add(new City(R.drawable.london, "London", getResources().getString(R.string.london)));
        cities.add(new City(R.drawable.madrid, "Madrid", getResources().getString(R.string.madrid)));
        cities.add(new City(R.drawable.iceland, "Iceland", getResources().getString(R.string.iceland)));
        cities.add(new City(R.drawable.new_york, "New York", getResources().getString(R.string.new_york)));
        cities.add(new City(R.drawable.paris, "Paris", getResources().getString(R.string.paris)));
        cities.add(new City(R.drawable.roma, "Roma", getResources().getString(R.string.roma)));

    }

    @Override
    public void onClickCity(City city) {
        alertCity = new AlertCity(city);
        alertCity.show(getSupportFragmentManager(), null);
    }

    @Override
    public void onClickLongCity(City city) {

    }


}