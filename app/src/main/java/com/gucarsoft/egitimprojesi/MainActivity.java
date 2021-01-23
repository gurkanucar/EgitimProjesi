package com.gucarsoft.egitimprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.gucarsoft.egitimprojesi.adapter.MainTabsPagerAdapter;
import com.gucarsoft.egitimprojesi.view.mainFragments.ForumMain;
import com.gucarsoft.egitimprojesi.view.mainFragments.HomeMain;
import com.gucarsoft.egitimprojesi.view.mainFragments.ProgramMain;
import com.gucarsoft.egitimprojesi.view.mainFragments.SettingsMain;
import com.gucarsoft.egitimprojesi.view.mainFragments.ToDoMain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeMain()).commit();
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment seleceted = null;
                switch (item.getItemId()) {
                    case R.id.item1:
                        seleceted = new HomeMain();
                        break;
                    case R.id.item2:
                        seleceted = new ToDoMain();
                        break;
                    case R.id.item3:
                        seleceted = new ProgramMain();
                        break;
                    case R.id.item4:
                        seleceted = new ForumMain();
                        break;
                    case R.id.item5:
                        seleceted = new SettingsMain();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, seleceted).commit();
                return true;
            }
        });


    }
}