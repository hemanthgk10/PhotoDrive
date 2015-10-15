package com.h3s.photodrive;

/**
 * Created by hemanthgokavarapu on 9/3/15.
 */
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.h3s.photodrive.fragments.*;
import android.support.v4.app.FragmentTransaction;

public class HomeScreenActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView mDrawerList;
    private Toolbar toolbar;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_screen);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }

        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        String[] values = new String[]{
                "Home", "Link Accounts", "About us", "Settings"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        mDrawerList.setAdapter(adapter);
        mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
        toolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        HomeScreenFragment homeScreenFragment = new HomeScreenFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, homeScreenFragment);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 1:
                        LinkAccountsFragment linkAccountsFragment = new LinkAccountsFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,linkAccountsFragment);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 2:
                        AboutUsFragment aboutUsFragment = new AboutUsFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,aboutUsFragment);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case 3:
                        SettingsFragment settingsFragment = new SettingsFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        //fragmentTransaction.replace(R.id.frame, getSupportFragmentManager().findFragmentById(R.id.fragment_flickr_login));
                        fragmentTransaction.replace(R.id.frame, settingsFragment);
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
