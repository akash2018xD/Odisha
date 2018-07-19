package od.com.odisha;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {


    RelativeLayout wild;
    RelativeLayout heritage;
    RelativeLayout beach;
    RelativeLayout defaultM;
    RelativeLayout shopping;
    RelativeLayout events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wild=(RelativeLayout)findViewById(R.id.wildlife);
        heritage=(RelativeLayout)findViewById(R.id.heritageandculture);
        beach=(RelativeLayout)findViewById(R.id.beaches);
        events=(RelativeLayout)findViewById(R.id.events);
        defaultM=(RelativeLayout)findViewById(R.id.mainattraction);

        defaultM.setVisibility(View.VISIBLE);
        setTitle("Top attractions");
        ImageView  map=(ImageView)findViewById(R.id.map);
        Glide.with(this).load(R.drawable.map).into(map);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cult)
        {
            Log.e("Culture","d");
            setTitle("Culture");
            wild.setVisibility(View.GONE);
            beach.setVisibility(View.GONE);
            events.setVisibility(View.GONE);
            defaultM.setVisibility(View.GONE);

            heritage.setVisibility(View.VISIBLE);
        }else if(id==R.id.nav_evnt)
        {
            Log.e("Culture","d");
            setTitle("Events");
            wild.setVisibility(View.GONE);
            beach.setVisibility(View.GONE);
            defaultM.setVisibility(View.GONE);
            heritage.setVisibility(View.GONE);

            events.setVisibility(View.VISIBLE);


        }
        else if(id==R.id.nav_beaches)
        {
            Log.e("Culture","d");
            setTitle("Beaches");
            wild.setVisibility(View.GONE);
            events.setVisibility(View.GONE);
            defaultM.setVisibility(View.GONE);
            heritage.setVisibility(View.GONE);
            beach.setVisibility(View.VISIBLE);
        }
        else if(id==R.id.nav_wild)
        {
            Log.e("WildLife","d");
            setTitle("Wildlife");
            beach.setVisibility(View.GONE);
            events.setVisibility(View.GONE);
            defaultM.setVisibility(View.GONE);

            heritage.setVisibility(View.GONE);


            wild.setVisibility(View.VISIBLE);

        }
        else
        {
            wild.setVisibility(View.GONE);
            beach.setVisibility(View.GONE);
            events.setVisibility(View.GONE);
            defaultM.setVisibility(View.GONE);

            heritage.setVisibility(View.GONE);
            defaultM.setVisibility(View.VISIBLE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

        public void map(View v)
        {
            Log.e("Ste",getResources().getResourceEntryName(v.getId())+"");

            dialog_details mdd=new dialog_details(this,getResources().getResourceEntryName(v.getId()));
            mdd.show();

        }
    @Override
    public void onClick(View v) {
        Log.e("Ste",v.getId()+"");
    }
}
