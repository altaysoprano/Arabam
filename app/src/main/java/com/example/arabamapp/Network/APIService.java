package com.example.arabamapp.Network;

import com.example.arabamapp.Model.CarModel;
import com.example.arabamapp.Model.CarModelDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("listing")
    Call<List<CarModel>> getCarList(@Query("categoryId") String categoryId,
                                    @Query("minYear") Integer minYear,
                                    @Query("maxYear") Integer maxYear,
                                    @Query("sort") Integer sort,
                                    @Query("sortDirection") Integer sortDirection,
                                    @Query("take") int take
    );

    @GET("detail")
    Call<CarModelDetail> getCar(@Query("id") int id);
}
