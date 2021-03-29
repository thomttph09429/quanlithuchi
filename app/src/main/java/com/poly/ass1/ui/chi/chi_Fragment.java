package com.poly.ass1.ui.chi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.poly.ass1.R;
import com.poly.ass1.adapter.PagerAdapter2;

public class chi_Fragment extends Fragment {
    PagerAdapter2 pagerAdapter2;
    ViewPager pager2 ;
    View view;
    TabLayout tabLayout2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_2, container, false);

        intv();

        return  view;



    }
    private  void intv(){
        pagerAdapter2 = new PagerAdapter2(getActivity().getSupportFragmentManager());
        pager2 = view.findViewById(R.id.view_pager2);
        tabLayout2 = view.findViewById(R.id.tab_layout2);
        pager2.setAdapter(pagerAdapter2);
        tabLayout2.setupWithViewPager(pager2);


    }
}
