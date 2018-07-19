package od.com.odisha;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by skmishra on 3/9/2017.
 */
public class MyApplication extends Application {

    private static MyApplication ins;

    private static LruCache<String, Bitmap> mMemoryCache;

    public MyApplication() {
        ins=this;

    }
    @Override
    public void onCreate() {
        super.onCreate();
        ins=this;

        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };



    }


    public static MyApplication getInstance()
    {
        return ins;
    }

    public static Context getAppContext()
    {
        return ins.getApplicationContext();
    }
    public void printHashKey() {
                /*Hash Key*/
    }

    public static LruCache<String, Bitmap> getmMemoryCache() {
        return mMemoryCache;
    }
}
