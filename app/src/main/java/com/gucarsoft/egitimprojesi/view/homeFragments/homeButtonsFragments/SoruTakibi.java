package com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gucarsoft.egitimprojesi.R;
import com.gucarsoft.egitimprojesi.adapter.SoruModelRCViewAdapter;
import com.gucarsoft.egitimprojesi.service.SoruTakipService;

public class SoruTakibi extends Fragment {
    RecyclerView rcView;
    SoruModelRCViewAdapter rcAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.soru_takibi,container,false);


        rcView=rootView.findViewById(R.id.soru_takip_rc_view);

        rcAdapter = new SoruModelRCViewAdapter(SoruTakipService.findAll(getContext()));
        rcView.setAdapter(rcAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }
}
