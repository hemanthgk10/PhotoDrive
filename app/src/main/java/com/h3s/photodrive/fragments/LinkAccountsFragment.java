package com.h3s.photodrive.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.h3s.photodrive.R;


/**
 * Created by hemanthgokavarapu on 9/17/15.
 */
public class LinkAccountsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.link_accounts, container, false);
        return v;
    }
}