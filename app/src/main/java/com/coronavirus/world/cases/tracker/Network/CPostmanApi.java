package com.coronavirus.world.cases.tracker.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CPostmanApi
{
    String Base_Url = "https://api.covid19api.com/";

    @Headers("Content-Type: applicaiton/json")
    @GET("summary")
    Call<Worldwide> getCountrylist();
}
