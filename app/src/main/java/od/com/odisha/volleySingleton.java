package od.com.odisha;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by skmishra on 3/9/2017.
 */
public class volleySingleton {

    private static volleySingleton sInstance=null;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    public volleySingleton(){
        mRequestQueue= Volley.newRequestQueue(MyApplication.getAppContext());

    }
    public static volleySingleton getInstance(){
        if(sInstance==null)
        {
            sInstance=new volleySingleton();
        }
        return sInstance;
    }
    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
    public ImageLoader getImageLoader(){
        return mImageLoader;
    }
}
class volleyUsage {


    private volleySingleton VS;
    private StringRequest sRq;



    public void makeRequest(String url, final VolleyResponse callback) {



        VS = volleySingleton.getInstance();
        RequestQueue rq = VS.getRequestQueue();
        Log.e("URLS", url);
        sRq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {


                callback.onSuccess(s);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                    Log.e("Volley Erro",volleyError.toString());
            }
        });


        DefaultRetryPolicy retryPolicy = new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        sRq.setRetryPolicy(retryPolicy);

        sRq.setShouldCache(false);
        rq.add(sRq);
    }
}
