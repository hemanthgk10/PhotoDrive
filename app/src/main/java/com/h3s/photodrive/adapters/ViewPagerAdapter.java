package com.h3s.photodrive.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;

import com.h3s.photodrive.SampleFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT =4;
    private String titles[];
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, String[] titles2, Context context) {
        super(fm);
        this.titles=titles2;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SampleFragment.newInstance(position, context);
            case 1:
                return SampleFragment.newInstance(position, context);
            case 2:
                return SampleFragment.newInstance(position, context);
            case 3:
                return SampleFragment.newInstance(position, context);
        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}