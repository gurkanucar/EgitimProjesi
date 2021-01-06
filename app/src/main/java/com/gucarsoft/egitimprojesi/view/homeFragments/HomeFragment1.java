package com.gucarsoft.egitimprojesi.view.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.gucarsoft.egitimprojesi.R;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.BilgiKartlari;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.DenemeTakibi;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.KonuTakibi;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.Odaklanma;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.SoruTakibi;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.YildizliSorular;

public class HomeFragment1 extends Fragment  {

    CardView btn1,btn2,btn3,btn4,btn5,btn6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_page_1,container,false);

        btn1=rootView.findViewById(R.id.homeBtn1);
        btn2=rootView.findViewById(R.id.homeBtn2);
        btn3=rootView.findViewById(R.id.homeBtn3);
        btn4=rootView.findViewById(R.id.homeBtn4);
        btn5=rootView.findViewById(R.id.homeBtn5);
        btn6=rootView.findViewById(R.id.homeBtn6);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new KonuTakibi()).commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SoruTakibi()).commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new DenemeTakibi()).commit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BilgiKartlari()).commit();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new YildizliSorular()).commit();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Odaklanma()).commit();
            }
        });

        return rootView;
    }
}
