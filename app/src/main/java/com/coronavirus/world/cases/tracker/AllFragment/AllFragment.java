package com.coronavirus.world.cases.tracker.AllFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.coronavirus.world.cases.tracker.Last24Hour.Adapter.RecyclerViewAdapter;

import com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork.GWorldwide;
import com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork.PostmanApi;
import com.coronavirus.world.cases.tracker.R;
import com.google.android.material.card.MaterialCardView;

import retrofit2.Call;
import retrofit2.Callback;
import  retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllFragment extends Fragment {

    View view;
    TextView ConfirmedText, RecoveredText, DeathsText;
    static final String Base_Url = "https://api.covid19api.com/";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_all, container, false);
        ConfirmedText = view.findViewById(R.id.global_confirmed);
        RecoveredText = view.findViewById(R.id.global_recovieries);
        DeathsText = view.findViewById(R.id.global_deaths);



        getGlobalData();



        return view;
    }


    public void getGlobalData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        PostmanApi api = retrofit.create(PostmanApi.class);
        Call<GWorldwide> call = api.getdata();
        call.enqueue(new Callback<GWorldwide>() {
            @Override
            public void onResponse(Call<GWorldwide> call, Response<GWorldwide> response) {

                GWorldwide GWorldwide = response.body();
                Integer integerconfirmed = new Integer(GWorldwide.getTotalConfirmed());
                Integer integerrecovered = new Integer(GWorldwide.getTotalRecovered());
                Integer integerdeaths = new Integer(GWorldwide.getTotalDeaths());
                ConfirmedText.setText(String.valueOf(integerconfirmed));
                RecoveredText.setText(String.valueOf(integerrecovered));
                DeathsText.setText(String.valueOf(integerdeaths));



            }
            @Override
            public void onFailure(Call<GWorldwide> call, Throwable t) {
             Toast.makeText(getContext(),"Some Thing Went Wrong",Toast.LENGTH_SHORT).show();



            }
        });



    }

}
