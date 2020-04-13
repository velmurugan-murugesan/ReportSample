package com.example.reportsample.features;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.reportsample.PagerAdapter;
import com.example.reportsample.R;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public HomeFragment(int someInt) {
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        setArguments(args);
    }

    @Override
    int getResource() { return  R.layout.fragment_home; }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int someInt = getArguments() != null ? getArguments().getInt("someInt") : 0;
        Log.d("someInt",someInt+"");

        tabLayout = view.findViewById(R.id.tabs_main);
        viewPager = view.findViewById(R.id.viewpager_main);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

   /* public static Fragment Ins(String fragmentName) {
        Fragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("name", fragmentName);
        fragment.setArguments(args);
        return fragment;
    }*/
}
