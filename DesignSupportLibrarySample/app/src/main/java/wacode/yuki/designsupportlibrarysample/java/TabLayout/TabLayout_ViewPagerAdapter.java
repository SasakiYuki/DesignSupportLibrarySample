package wacode.yuki.designsupportlibrarysample.java.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by Riberd on 2016/04/21.
 */
public class TabLayout_ViewPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitle;
    public TabLayout_ViewPagerAdapter(FragmentManager fm, String title[] ){
        super(fm);mTitle = title;
    }
    @Override
    public Fragment getItem(int position) {
        return TabLayout_Fragment.newInstance(position);
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

