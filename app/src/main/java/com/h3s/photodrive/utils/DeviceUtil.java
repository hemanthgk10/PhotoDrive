package com.h3s.photodrive.utils;

/**
 * Created by hemanthgokavarapu on 9/27/15.
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.os.Build;

public class DeviceUtil
{
    public static Point getDeviceDimensions(Context context)
    {
        Point result = new Point();
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 11)
        {
            try {
                display.getRealSize(result);
                return result;
            }
            catch (NoSuchMethodError e)
            {
                result.x = display.getWidth();

                result.y = display.getHeight();
            }
        }
        else {
            DisplayMetrics metrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(metrics);
            result.x = metrics.widthPixels;
            result.y = metrics.heightPixels;
        }
        return result;
    }
}
