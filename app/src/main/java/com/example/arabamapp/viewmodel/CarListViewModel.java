package com.example.arabamapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.arabamapp.Model.CarModel;
import com.example.arabamapp.Model.CarModelDetail;
import com.example.arabamapp.Network.APIService;
import com.example.arabamapp.Network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarListViewModel extends ViewModel {

    private MutableLiveData<List<CarModel>> carList;
    private MutableLiveData<CarModelDetail> carModelDetail;

    public CarListViewModel() {
        carList = new MutableLiveData<>();
        carModelDetail = new MutableLiveData<>();
    }

    public MutableLiveData<List<CarModel>> getCarList() {
        return carList;
    }

    public MutableLiveData<CarModelDetail> getCar() {return carModelDetail;}

    public void makeApiCall(String categoryId, Integer minYear, Integer maxYear, Integer sort, Integer sortDirection,
                            int take) {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<CarModel>> call = apiService.getCarList(categoryId, minYear, maxYear,
                sort, sortDirection, take);
        call.enqueue(new Callback<List<CarModel>>() {
            @Override
            public void onResponse(Call<List<CarModel>> call, Response<List<CarModel>> response) {
                carList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CarModel>> call, Throwable t) {
                carList.postValue(null);
            }
        });
    }

    public void makeApiCallwithId(int id) {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<CarModelDetail> call = apiService.getCar(id);
        call.enqueue(new Callback<CarModelDetail>() {
            @Override
            public void onResponse(Call<CarModelDetail> call, Response<CarModelDetail> response) {
                carModelDetail.postValue(response.body());
            }

            @Override
            public void onFailure(Call<CarModelDetail> call, Throwable t) {
                carModelDetail = null;
            }
        });
    }


}
