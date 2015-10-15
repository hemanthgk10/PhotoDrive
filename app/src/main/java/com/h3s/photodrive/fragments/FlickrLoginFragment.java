package com.h3s.photodrive.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h3s.photodrive.clients.FlickrClient;
import com.h3s.photodrive.R;

public class FlickrLoginFragment extends BaseServiceLoginFragment<FlickrClient> {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_flickr_login, container);
	}
	
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		setServiceName("Flickr");
		setButtonResId(R.id.btnFlickrLogin);
	}
}
