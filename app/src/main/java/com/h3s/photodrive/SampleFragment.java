package com.h3s.photodrive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpardogo.listbuddies.lib.views.ListBuddiesLayout;
import com.h3s.photodrive.providers.ImagesUrls;
import com.h3s.photodrive.clients.FlickrClient;
import android.content.Context;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import com.loopj.android.http.JsonHttpResponseHandler;
import java.util.ArrayList;
import com.h3s.photodrive.models.FlickrPhoto;
import android.app.ProgressDialog;
import java.util.List;
import android.os.AsyncTask;
import android.widget.GridView;
import android.util.TypedValue;
import com.h3s.photodrive.utils.DeviceUtil;
import com.h3s.photodrive.adapters.ImageGridViewAdapter;
import java.io.InputStream;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;



public class SampleFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;
    private Context context;
    private GridView gridView;
    private ImagesUrls imagesUrls;
    private FlickrClient flickrClient;
    private ListBuddiesLayout listBuddies;
    private ArrayList<FlickrPhoto> photoList;
    private ImageGridViewAdapter imageGridViewAdapter;

    public SampleFragment() {
        this.context = context;
        imagesUrls = new ImagesUrls();
        photoList = new ArrayList<FlickrPhoto>();
        flickrClient = (FlickrClient) FlickrClient.getInstance(FlickrClient.class, context);
        System.out.println("IS Authenticated:" + flickrClient.isAuthenticated());
    }

    public static SampleFragment newInstance(int position, Context context) {
        context = context;
        SampleFragment f = new SampleFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    private void initializeComponents() {
        float spacing = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                Constants.GRIDVIEW_SPACING, getResources().getDisplayMetrics());
        gridView.setNumColumns(DeviceUtil.getDeviceDimensions(getActivity()).x / Constants.GRIDVIEW_COLUMN_WIDTH);
        gridView.setPadding((int) spacing, (int) spacing, (int) spacing, (int) spacing);
        gridView.setVerticalSpacing((int) spacing);
        gridView.setHorizontalSpacing((int) spacing);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView;
        if (flickrClient.isAuthenticated()) {
            System.out.println("DEBUG Authenticated: ");
            rootView = inflater.inflate(R.layout.page, container, false);
            gridView = (GridView) rootView.findViewById(R.id.gridView);
            imageGridViewAdapter = new ImageGridViewAdapter(getActivity(), getResources().getDimensionPixelSize(R.dimen.item_height_small));
            initializeComponents();
            gridView.setAdapter(imageGridViewAdapter);
            new LoadImagesFromFlickrTask(imageGridViewAdapter).execute();
        } else {
            rootView = inflater.inflate(R.layout.error, container, false);
        }
        return rootView;
    }


    class LoadImagesFromFlickrTask extends AsyncTask<String, Integer, List<FlickrPhoto>> {
        private ProgressDialog progressDialog;
        private ImageGridViewAdapter imageGridViewAdapter;

        public LoadImagesFromFlickrTask(ImageGridViewAdapter imageGridViewAdapter){
            this.imageGridViewAdapter = imageGridViewAdapter;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading images from Flickr. Please wait...");
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            imageGridViewAdapter.add(photoList.get(values[0]));
            imageGridViewAdapter.notifyDataSetChanged();
            super.onProgressUpdate(values);
            progressDialog.setMessage(String.format("Loading images from Flickr %s/%s. Please wait...", values[0], values[1]));
        }

        @Override
        protected List<FlickrPhoto> doInBackground(String... params) {
            flickrClient.getPhotoSetList(new JsonHttpResponseHandler() {
                public void onSuccess(JSONObject json) {
                    try {
                        JSONArray photos = json.getJSONObject("photos").getJSONArray("photo");
                        System.out.println("DEBUG result: " + photos.length());
                        for (int x = 0; x < photos.length(); x++) {
                            JSONObject object = photos.getJSONObject(x);
                            FlickrPhoto p = new FlickrPhoto(photos.getJSONObject(x));
                            ;
                            System.out.println("DEBUG URL:" + p.getUrl());
                            InputStream inputStreamThumbnail = null;
                            try {
                                inputStreamThumbnail = new URL(p.getUrl()).openStream();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //BitmapFactory.Options options = new BitmapFactory.Options();
                            //options.inSampleSize = 2;
                            //Bitmap bitmapThumbnail = BitmapFactory.decodeStream(inputStreamThumbnail, null, options);
                            Bitmap bitmapThumbnail = BitmapFactory.decodeStream(inputStreamThumbnail);
                            p.setThumbnailBitmap(bitmapThumbnail);
                            photoList.add(p);
                            publishProgress(x, photos.length());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        System.out.println("DEBUG" + e.toString());
                    }
                }
            });
            return photoList;
        }

        @Override
        protected void onPostExecute(List<FlickrPhoto> flickrPhotos) {
            //if(flickrPhotos.size() != 0) {
                progressDialog.dismiss();
                super.onPostExecute(flickrPhotos);
            //}
        }
    }
}