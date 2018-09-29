package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import geek.libaryborrower.anis.libaryborrower.HomeFragment;
import geek.libaryborrower.anis.libaryborrower.NotificationFragment;
import geek.libaryborrower.anis.libaryborrower.ProfileFragment;
import geek.libaryborrower.anis.libaryborrower.SearchFragment;

public class PagerViewAdpter extends FragmentPagerAdapter {
    public PagerViewAdpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 :
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                SearchFragment searchFragment = new SearchFragment();
                return searchFragment;
            case 2:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 3:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
