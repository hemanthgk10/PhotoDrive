package com.h3s.photodrive;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.FlickrApi;

/**
 * Created by hemanthgokavarapu on 9/20/15.
 */
public class Constants {
    public static final String FLICKR_REST_URL = "http://www.flickr.com/services";
    public static final String FLICKR_REST_CONSUMER_KEY = "482e429f1960ae88ca3f9c0fc0c026f4";
    public static final String FLICKR_REST_CONSUMER_SECRET = "c2f1543ca0d116b7";
    public static final String FLICKR_REST_CALLBACK_URL = "oauth://photodrive";
    public static final Class<? extends Api> FLICKR_REST_API_CLASS = FlickrApi.class;
    public static final int GRIDVIEW_SPACING = 3;
    public static final int GRIDVIEW_COLUMN_WIDTH = 220;
}
