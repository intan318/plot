package com.example.intanyoshanaoewen.plot;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private PlanFragment planFragment;
    private SearchFragment searchFragment;
    private SavedFragment savedFragment;
    private MenuFragment menuFragment;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        planFragment = new PlanFragment();
        searchFragment = new SearchFragment();
        savedFragment = new SavedFragment();
        menuFragment = new MenuFragment();

        setFragment (searchFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_plan :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(planFragment);
                        return true;

                    case R.id.nav_search :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(searchFragment);
                        return true;

                    case R.id.nav_saved :
                        mMainNav.setItemBackgroundResource(R.color.colorPlot);
                        setFragment(savedFragment);
                        return true;

                    /*case R.id.nav_menu :
                      mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                      setFragment(menuFragment);
                      return true;*/

                        default:
                            return false;
                }

            }

            private void setFragment(android.support.v4.app.Fragment fragment) {
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                android.support.v4.app.FragmentTransaction replace = fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    public void setFragment(SearchFragment fragment) {
        this.searchFragment = searchFragment;
    }
}
