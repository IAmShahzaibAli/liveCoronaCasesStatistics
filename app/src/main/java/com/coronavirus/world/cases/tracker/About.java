package com.coronavirus.world.cases.tracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class About extends Fragment
{


    View view;
    ImageView Sad,Happy,Smily;
    Button FreeApps,ReadMore;
    public About() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about,container,false);
        Sad = view.findViewById(R.id.RatingFacesSad);
        Happy = view.findViewById(R.id.RatingFacesHappy);
        Smily = view.findViewById(R.id.RatingFacesSmiley);
        FreeApps = view.findViewById(R.id.DownloadOtherApp_Button);
        ReadMore = view.findViewById(R.id.who_Button);
        Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setTitle("ThankYou");
                builder1.setIcon(R.drawable.ratingthankyou);
                builder1.setCancelable(true);
                builder1.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doimtent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getActivity().getPackageName()));
                startActivity(doimtent);

            }
        });
        Smily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doimtent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getActivity().getPackageName()));
                startActivity(doimtent);

            }
        });



        FreeApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doimtent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getActivity().getPackageName()));
                startActivity(doimtent);

            }
        });
        ReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/advice-for-public"));
                startActivity(intent);


            }
        });













        return view;

    }
}
