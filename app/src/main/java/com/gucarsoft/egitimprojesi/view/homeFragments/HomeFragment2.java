package com.gucarsoft.egitimprojesi.view.homeFragments;

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
import com.gucarsoft.egitimprojesi.adapter.LogModelRCViewAdapter;
import com.gucarsoft.egitimprojesi.repository.LoggingRepository;

public class HomeFragment2 extends Fragment {

    RecyclerView rcView;
    LogModelRCViewAdapter rcAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_page_2,container,false);

        rcView=rootView.findViewById(R.id.home_page_2_rc_view);

        LoggingRepository loggingRepository = new LoggingRepository(getContext());
        rcAdapter = new LogModelRCViewAdapter(loggingRepository.listAll());
        rcView.setAdapter(rcAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));


        return rootView;
    }
}
