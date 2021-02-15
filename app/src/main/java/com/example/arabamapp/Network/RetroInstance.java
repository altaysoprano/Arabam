package com.example.arabamapp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String LIST_URL = "https://sandbox.arabamd.com/api/v1/";

    private static Retrofit retrofit;

    public static Retrofit getRetroClient() {

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(LIST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
