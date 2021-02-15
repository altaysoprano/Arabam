package com.example.arabamapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arabamapp.Model.CarModelDetail;
import com.example.arabamapp.adapter.ImageAdapter;
import com.example.arabamapp.viewmodel.CarListViewModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "package com.example.arabamapp.EXTRA_ID";
    private CarListViewModel carListViewModel;
    private ImageView carImageView;
    private MutableLiveData<CarModelDetail> carModelDetail;
    ViewPager viewPager;
    TextView titleTV;
    TextView locationTV;
    TextView modelNameTV;
    TextView priceTV;
    TextView dateTV;
    TextView kmTV;
    TextView colorTV;
    TextView yearTV;
    TextView gearTV;
    TextView fuelTV;
    TextView textTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTitle("Car Detail");

        viewPager = findViewById(R.id.view_pager);
        titleTV = findViewById(R.id.title_tv);
        locationTV = findViewById(R.id.location_tv);
        modelNameTV = findViewById(R.id.model_name_tv);
        priceTV = findViewById(R.id.price_tv);
        dateTV = findViewById(R.id.date_tv);
        kmTV = findViewById(R.id.km_tv);
        colorTV = findViewById(R.id.color_tv);
        yearTV = findViewById(R.id.year_tv);
        gearTV = findViewById(R.id.gear_tv);
        fuelTV = findViewById(R.id.fuel_tv);
        textTV = findViewById(R.id.text_tv);

        carListViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CarListViewModel.class);

        Intent intent = getIntent();
        int id = intent.getIntExtra(EXTRA_ID, -1);
        carListViewModel.makeApiCallwithId(id);
        carListViewModel.getCar().observe(this, new Observer<CarModelDetail>() {
            @Override
            public void onChanged(CarModelDetail carModelDetail) {

                String[] carImages = new String[carModelDetail.getPhotos().size()];
                String title = carModelDetail.getTitle();
                String location = carModelDetail.getLocation().getTownName() + ", " + carModelDetail.getLocation().getCityName();;
                String modelName = carModelDetail.getModelName();
                String price = carModelDetail.getPriceFormatted();
                String date = carModelDetail.getDateFormatted();
                String km = carModelDetail.getProperties().get(0).getValue();
                String color = carModelDetail.getProperties().get(1).getValue();
                String year = carModelDetail.getProperties().get(2).getValue();
                String gear = carModelDetail.getProperties().get(3).getValue();
                String fuel = carModelDetail.getProperties().get(4).getValue();
                String text = carModelDetail.getText();

                for(int i = 0; i < carModelDetail.getPhotos().size(); i++) {
                    carImages[i] = carModelDetail.getPhotos().get(i).replace("{0}", "800x600");
                }

                ImageAdapter imageAdapter = new ImageAdapter(DetailActivity.this, carImages);
                viewPager.setAdapter(imageAdapter);

                titleTV.setText(title);
                locationTV.setText(location);
                modelNameTV.setText(modelName);
                priceTV.setText(price);
                dateTV.setText(date);
                kmTV.setText(km);
                colorTV.setText(color);
                yearTV.setText(year);
                gearTV.setText(gear);
                fuelTV.setText(fuel);
                textTV.setText(text);

            }
        });
    }
}
