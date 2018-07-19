package od.com.odisha;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by skmishra on 3/9/2017.
 */
public class dialog_details extends Dialog {

    String main=null;
    TextView title,about,time;
    ImageView mainImage;
    public dialog_details(Context context,String id) {
        super(context);
        main=id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item);

        mainImage=(ImageView)findViewById(R.id.itemImage);
        title=(TextView)findViewById(R.id.textTitle);
        about=(TextView)findViewById(R.id.textAbout);
        time=(TextView)findViewById(R.id.time);

        volleyUsage vs=new volleyUsage();
        main=main.replace("item","");
        vs.makeRequest("http://192.168.219.1/Lumi/getDetails.php?itemID=" + main, new VolleyResponse() {
            @Override
            public void onSuccess(String resp) {
                try {
                    JSONObject msjOS=new JSONObject(resp);
                    Glide.with(MyApplication.getAppContext()).load(msjOS.getString("url")).into(mainImage);
                    title.setText(msjOS.getString("title"));
                    about.setText(msjOS.getString("about"));
                    time.setText(msjOS.getString("time"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
