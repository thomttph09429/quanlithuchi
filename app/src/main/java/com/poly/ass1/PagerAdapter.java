package com.poly.ass1;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.poly.ass1.ui.chi.chi_Fragment;
import com.poly.ass1.ui.thong_ke.thongke_Fragment;
import com.poly.ass1.ui.thu.thu_Fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
