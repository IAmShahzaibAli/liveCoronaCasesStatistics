package com.coronavirus.world.cases.tracker.Last24Hour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coronavirus.world.cases.tracker.Last24Hour.Adapter.RecyclerViewAdapter;
import com.coronavirus.world.cases.tracker.Network.CPostmanApi;
import com.coronavirus.world.cases.tracker.Network.Country;
import com.coronavirus.world.cases.tracker.Network.Worldwide;
import com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork.GWorldwide;
import com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork.PostmanApi;
import com.coronavirus.world.cases.tracker.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HourFragment extends Fragment
{


    RecyclerView recyclerView;
    RecyclerViewAdapter hRecyclerViewAdapter;
    LinearLayoutManager linearLayout;
    View view;
    static final String Base_Url = "https://api.covid19api.com/";
    TextView ConfirmedText,RecoveredText,DeathsText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hour,container,false);
        getHourData();


        return view;
    }
    private void generateDataList(List<Country> modelList) {
        recyclerView = view.findViewById(R.id.recyclerview_hour);
        hRecyclerViewAdapter = new RecyclerViewAdapter(getContext(),modelList);
        linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(hRecyclerViewAdapter);
    }
    public void getHourData() {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        CPostmanApi api = retrofit1.create(CPostmanApi.class);
        Call<Worldwide> listCall = api.getCountrylist();
        listCall.enqueue(new Callback<Worldwide>() {
            @Override
            public void onResponse(Call<Worldwide> call, Response<Worldwide> response) {
                Worldwide worldwideList = response.body();
                List<Country> list = response.body().getCountries();
                generateDataList(list);


            }

            @Override
            public void onFailure(Call<Worldwide> call, Throwable t) {




            }
        });





    }


    }