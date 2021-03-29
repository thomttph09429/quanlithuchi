package com.poly.ass1.ui.thu;

import android.os.Bundle;
import android.os.ParcelUuid;
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
import com.poly.ass1.PagerAdapter;
import com.poly.ass1.R;
import com.poly.ass1.adapter.PagerAdapter1;

public class thu_Fragment extends Fragment {
public  thu_Fragment(){};
TabLayout tabLayout;
ViewPager pager;
PagerAdapter1 pagerAdapter1;
View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_1, container,false);
        initview();
         return  view;
    }
    private void  initview(){
        pagerAdapter1 =new PagerAdapter1(getActivity().getSupportFragmentManager());
        tabLayout=view.findViewById(R.id.tab_layout);
        pager=view.findViewById(R.id.view_pager);
        pager.setAdapter(pagerAdapter1);
        tabLayout.setupWithViewPager(pager);

    }
}
