package com.h3s.photodrive.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import com.h3s.photodrive.layouts.SlidingTabLayout;

import com.h3s.photodrive.R;
import com.h3s.photodrive.adapters.ViewPagerAdapter;

/**
 * Created by hemanthgokavarapu on 9/17/15.
 */
public class HomeScreenFragment extends Fragment {

    private ViewPager pager;
    private SlidingTabLayout slidingTabLayout;
    private String titles[] = new String[]{"Flickr", "Tumblr","500px", "Pinterest"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_screen,container,false);
        pager = (ViewPager) rootView.findViewById(R.id.viewpager);
        pager.setAdapter(new ViewPagerAdapter(this.getChildFragmentManager(), titles, getActivity().getApplicationContext()));

        slidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(pager);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.WHITE;
            }
        });
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
        return rootView;
    }
}
