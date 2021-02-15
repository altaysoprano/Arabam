package com.example.arabamapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arabamapp.Model.CarModel;
import com.example.arabamapp.adapter.CarListAdapter;
import com.example.arabamapp.viewmodel.CarListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FilterBottomSheet.BottomSheetListener{

    private List<CarModel> carList;
    private CarListAdapter carListAdapter;
    private CarListViewModel carsViewModel;
    private ProgressBar progressBarMain;
    private NestedScrollView nestedScrollView;
    Integer sort = null;
    Integer sortDirection = null;
    String categoryId = null;
    Integer minYear = null;
    Integer maxYear = null;
    int limit = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Cars");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TextView noResultFound = findViewById(R.id.no_result_tv);
        progressBarMain = findViewById(R.id.progress_bar_main_activity);
        nestedScrollView = findViewById(R.id.nested_scroll_view);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(linearLayoutManager);
        noResultFound.setVisibility(View.GONE);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    progressBarMain.setVisibility(View.VISIBLE);
                    limit += 10;
                    carsViewModel.makeApiCall(categoryId, minYear, maxYear,
                            sort, sortDirection, limit);
                    progressBarMain.setVisibility(View.GONE);
                }
            }
        });

        carListAdapter = new CarListAdapter(this, carList);
        recyclerView.setAdapter(carListAdapter);

        carsViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CarListViewModel.class);
        carsViewModel.getCarList().observe(this, new Observer<List<CarModel>>() {
            @Override
            public void onChanged(List<CarModel> carModels) {
                if (carModels != null) {
                    carList = carModels;
                    progressBarMain.setVisibility(View.GONE);
                    carListAdapter.setCarList(carList);
                    carListAdapter.notifyDataSetChanged();
                } else {
                    progressBarMain.setVisibility(View.GONE);
                    noResultFound.setVisibility(View.VISIBLE);
                }
            }
        });
        carsViewModel.makeApiCall(categoryId, minYear, maxYear, sort, sortDirection, limit);

        carListAdapter.setOnClickListener(new CarListAdapter.OnClickListener() {
            @Override
            public void onClick(int id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ID, id);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_min_price :
                progressBarMain.setVisibility(View.VISIBLE);
                sort = 0;
                sortDirection = 0;
                carsViewModel.makeApiCall(categoryId, minYear, maxYear, sort,sortDirection, limit);
                progressBarMain.setVisibility(View.GONE);
                return true;

            case R.id.sort_newest_car :
                progressBarMain.setVisibility(View.VISIBLE);
                sort = 2;
                sortDirection = 1;
                carsViewModel.makeApiCall(categoryId, minYear, maxYear, sort,sortDirection, limit);
                progressBarMain.setVisibility(View.GONE);
                return true;

            case R.id.sort_newest_date :
                progressBarMain.setVisibility(View.VISIBLE);
                sort = 1;
                sortDirection = 1;
                carsViewModel.makeApiCall(categoryId, minYear, maxYear, sort,sortDirection, limit);
                progressBarMain.setVisibility(View.GONE);
                return true;

            case R.id.filter_item :
                FilterBottomSheet filterBottomSheet = new FilterBottomSheet();
                filterBottomSheet.show(getSupportFragmentManager(), "Filter Bottom Sheet");

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onButtonClicked(String mCategoryId, String mMaxYear, String mMinYear) {
        categoryId = mCategoryId;
        maxYear = Integer.parseInt(mMaxYear);
        minYear = Integer.parseInt(mMinYear);

        progressBarMain.setVisibility(View.VISIBLE);
        carsViewModel.makeApiCall(categoryId, minYear, maxYear, sort, sortDirection, limit);
        progressBarMain.setVisibility(View.GONE);

    }
}
