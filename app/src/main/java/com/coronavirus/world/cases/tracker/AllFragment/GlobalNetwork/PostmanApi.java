package com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PostmanApi
{
     String Base_Url = "https://api.covid19api.com/";

    @Headers("Content-Type: applicaiton/json")
    @GET("world/total")
    Call<GWorldwide> getdata();


}
