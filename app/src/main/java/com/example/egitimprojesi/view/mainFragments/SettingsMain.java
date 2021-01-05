package com.example.egitimprojesi.view.mainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.egitimprojesi.R;
import com.example.egitimprojesi.adapter.HomePagerAdapter;
import com.example.egitimprojesi.view.homeFragments.HomeFragment1;
import com.example.egitimprojesi.view.homeFragments.HomeFragment2;
import com.example.egitimprojesi.view.homeFragments.HomeFragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SettingsMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.settings,container,false);
        return rootView;
    }
}
