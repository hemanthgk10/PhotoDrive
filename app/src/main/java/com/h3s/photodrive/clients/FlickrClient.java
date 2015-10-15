package com.h3s.photodrive.clients;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.FlickrApi;
import org.scribe.model.Token;

public class FlickrClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = FlickrApi.class;
    public static final String REST_URL = "http://www.flickr.com/services";
    public static final String REST_CONSUMER_KEY = "482e429f1960ae88ca3f9c0fc0c026f4";
    public static final String REST_CONSUMER_SECRET = "c2f1543ca0d116b7";
    public static final String REST_CALLBACK_URL = "oauth://photodriveflickr";

    public FlickrClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
        setBaseUrl("https://api.flickr.com/services/rest");
    }

    public void getPhotoSetList(AsyncHttpResponseHandler handler) {
        Token token = client.getAccessToken();
        String apiUrl = getApiUrl("?&format=json&nojsoncallback=1&api_key=" + REST_CONSUMER_KEY +"&method=flickr.interestingness.getList&per_page=30");
        Log.d("DEBUG", "Sending API call to " + apiUrl);
        client.get(apiUrl, null, handler);
    }

    public void getSetPhotos(long setId, AsyncHttpResponseHandler handler ) {
        String apiUrl = getApiUrl("?&format=json&nojsoncallback=1&api_key=" + REST_CONSUMER_KEY +"&method=flickr.photosets.getPhotos&photoset_id="+ setId);
        Log.d("DEBUG", "Sending API call to " + apiUrl);
        client.get(apiUrl, null, handler);
    }
}