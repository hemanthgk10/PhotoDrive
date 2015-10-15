package com.h3s.photodrive.adapters;

import android.view.View;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import com.h3s.photodrive.models.FlickrPhoto;
import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by hemanthgokavarapu on 9/27/15.
 */
public class ImageGridViewAdapter extends BaseAdapter {

    private Activity activity;
    private int mRowHeight;
    private ArrayList<FlickrPhoto> itemList = new ArrayList<FlickrPhoto>();

    public ImageGridViewAdapter(Activity activity, int rowHeight) {
        this.activity = activity;
        this.mRowHeight = rowHeight;
    }

    public void add(FlickrPhoto photo){
        itemList.add(photo);
    }

    public void clear(){
        itemList.clear();
    }

    public void remove(int index){
        itemList.remove(index);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(activity);
            imageView.setMinimumHeight(mRowHeight);
        }else
            imageView = (ImageView) convertView;


        imageView.setScaleType(ImageView.ScaleType.CENTER);
        //Bitmap bitmapThumbnail = decodeSampledBitmapFromUri(itemList.get(position).getUrl(),220,220);
        //imageView.setImageBitmap(bitmapThumbnail);
        imageView.setImageBitmap(itemList.get(position).getThumbnailBitmap());
        //imageView.setOnClickListener(new ImageGridViewCellOnClickListener(position));

        return imageView;
    }

    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

        Bitmap bm = null;
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height
                        / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }

        return inSampleSize;
    }

    /*class ImageGridViewCellOnClickListener implements View.OnClickListener {
        private int position;

        public ImageGridViewCellOnClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            currentAppData.setCurrentPosition(position);
            Intent intent = new Intent(activity, MediumViewActivity.class);
            activity.startActivity(intent);
        }
    }*/
}
