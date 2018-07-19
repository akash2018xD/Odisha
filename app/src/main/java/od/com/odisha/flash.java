package od.com.odisha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by skmishra on 3/9/2017.
 */
public class flash extends Activity {


    TextView odt;
    TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.flash);
        odt=(TextView)findViewById(R.id.odt);
        temp=(TextView)findViewById(R.id.temp);
        fonts f=new fonts();
        f.setRalewayBold(this,odt);
        f.setRobotoLight(this,temp);
        Animation fade= AnimationUtils.loadAnimation(this, R.anim.fade_in);
        odt.setAnimation(fade);
        Animation fade2= AnimationUtils.loadAnimation(this, R.anim.fade_in);
        temp.setAnimation(fade2);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(flash.this,MainActivity.class);
                flash.this.startActivity(mainIntent);
                flash.this.finish();
            }
        }, 3000);
    }
}
