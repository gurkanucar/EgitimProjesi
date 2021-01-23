package com.gucarsoft.egitimprojesi.view.mainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gucarsoft.egitimprojesi.R;
import com.gucarsoft.egitimprojesi.adapter.HomePagerAdapter;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment1;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment2;
import com.gucarsoft.egitimprojesi.view.homeFragments.HomeFragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeMain extends Fragment {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home,container,false);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment1());
        fragmentList.add(new HomeFragment2());
        fragmentList.add(new HomeFragment3());

        pager=rootView.findViewById(R.id.pager);
        pagerAdapter = new HomePagerAdapter(getFragmentManager(),fragmentList);
        pager.setAdapter(pagerAdapter);

        tabLayout=rootView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
        return rootView;
    }
}
