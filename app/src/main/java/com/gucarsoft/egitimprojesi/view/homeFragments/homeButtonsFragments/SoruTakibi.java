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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gucarsoft.egitimprojesi.R;
import com.gucarsoft.egitimprojesi.adapter.HomePagerAdapter;
import com.gucarsoft.egitimprojesi.adapter.SoruModelRCViewAdapter;
import com.gucarsoft.egitimprojesi.service.SoruTakipService;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment1;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment2;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment3;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.SoruTakibiFragments.SoruTakibiFragment1;
import com.gucarsoft.egitimprojesi.view.homeFragments.homeButtonsFragments.SoruTakibiFragments.SoruTakibiFragment2;

import java.util.ArrayList;
import java.util.List;

public class SoruTakibi extends Fragment {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.soru_takibi,container,false);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new SoruTakibiFragment1());
        fragmentList.add(new SoruTakibiFragment2());

        pager=rootView.findViewById(R.id.pager_soru_takibi);
        pagerAdapter = new HomePagerAdapter(getFragmentManager(),fragmentList);
        pager.setAdapter(pagerAdapter);

        tabLayout=rootView.findViewById(R.id.tabLayout_soru_takibi);
        tabLayout.setupWithViewPager(pager);

        return rootView;
    }
}
