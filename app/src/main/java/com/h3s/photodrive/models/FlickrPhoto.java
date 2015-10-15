package com.h3s.photodrive.models;

import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Bitmap;

public class FlickrPhoto  {
	private String uid;
	private String name;
	private String url;
	private Bitmap thumbnailBitmap;

	public FlickrPhoto(JSONObject object){

		try {
			this.uid = object.getString("id");
			this.name = object.getString("title");
			this.thumbnailBitmap = thumbnailBitmap;
			// http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
			this.url = "http://farm" + object.getInt("farm") + ".staticflickr.com/" + object.getInt("server") +
					"/" + uid + "_" + object.getString("secret") + ".jpg";
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}
	
	public String getName() {
		return name;
	}

	public void setThumbnailBitmap(Bitmap thumbnailBitmap) {
		this.thumbnailBitmap = thumbnailBitmap;
	}
	public Bitmap getThumbnailBitmap() {
		return thumbnailBitmap;
	}
}