package wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Riberd on 2016/04/21.
 */
public class viewPager_Adapter extends FragmentPagerAdapter {
    private String[] mTitle;
    public viewPager_Adapter(FragmentManager fm, String title[] ){
        super(fm);mTitle = title;
    }
    @Override
    public Fragment getItem(int position) {
        return ViewPager_Fragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}

