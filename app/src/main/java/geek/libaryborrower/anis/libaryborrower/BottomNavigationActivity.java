package geek.libaryborrower.anis.libaryborrower;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import adapter.PagerViewAdpter;

public class BottomNavigationActivity extends AppCompatActivity {
     BottomNavigationView navigation;

    private ViewPager mMainPager;

    private PagerViewAdpter mPagerViewAdpter;
    MenuItem prevMenuItem;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                 //   transaction.replace(R.id.container,new HomeFragment()).commit();
                    mMainPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_search:
                 //   transaction.replace(R.id.container,new SearchFragment()).commit();
                    mMainPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                 //   transaction.replace(R.id.container,new NotificationFragment()).commit();
                    mMainPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_profile:
                 //   transaction.replace(R.id.container,new ProfileFragment()).commit();
                    mMainPager.setCurrentItem(3);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

      /*  FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        transaction.replace(R.id.container,new HomeFragment()).commit();*/

        mMainPager = (ViewPager)findViewById(R.id.mainPager);

        mPagerViewAdpter = new PagerViewAdpter(getSupportFragmentManager());
        mMainPager.setAdapter(mPagerViewAdpter);
        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+i);
                navigation.getMenu().getItem(i).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    /*private void changeTab(int i) {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        switch (i){
            case 0 : navigation.setSelectedItemId(0);
                break;
            case 1 : navigation.setSelectedItemId(1);
                break;
            case 2 : navigation.setSelectedItemId(2);
                break;
            case 3: navigation.setSelectedItemId(3);
                break;
        }
    }*/
}
