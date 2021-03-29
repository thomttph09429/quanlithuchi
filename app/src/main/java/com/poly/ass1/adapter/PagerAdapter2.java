package com.poly.ass1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.ass1.Fragment.Fragment_KhoanChi;
import com.poly.ass1.Fragment.Fragment_LoaiChi;

public class PagerAdapter2  extends FragmentStatePagerAdapter {
    public PagerAdapter2(FragmentManager fragmentManager){
        super(fragmentManager);

    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(position==0){
           return new Fragment_LoaiChi();
        }
        if(position==1){
            return  new Fragment_KhoanChi();

        }else {
            return  null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "loại chi";
            case 1:return "khoản chi";
        }
        return null;
    }
}
