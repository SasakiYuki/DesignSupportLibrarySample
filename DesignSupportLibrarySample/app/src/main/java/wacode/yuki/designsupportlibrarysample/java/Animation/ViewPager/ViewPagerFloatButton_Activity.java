package wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wacode.yuki.designsupportlibrarysample.R;
import wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager.Custom_ViewPager;
import wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager.viewPager_Adapter;

/**
 * Created by Riberd on 2016/04/21.
 */
public class ViewPagerFloatButton_Activity extends AppCompatActivity {
    public static final String KEY_FRAGMENT_MODE = "key_fragment_mode";
    private boolean mIsAnimating = false;
    private FloatingActionButton mFb;
    private int mPosition;
    private Custom_ViewPager mCustomViewPager;
    private int mState;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_floatbutton);

        setViews();
    }

    private void setViews() {
        setViewPager();

        mFb = (FloatingActionButton) findViewById(R.id.fb_viewPager);
        mFb.setImageResource(R.mipmap.ic_done_white_24dp);
        mFb.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.color_floatButton_blue)));
    }

    private void setViewPager() {
        String[] title = {"Tab1", "Tab2", "Tab3"};
        FragmentManager fm = getSupportFragmentManager();
        viewPager_Adapter adapter = new viewPager_Adapter(fm, title);

        mCustomViewPager = (Custom_ViewPager) findViewById(R.id.viewPager);
        mCustomViewPager.setAdapter(adapter);
        mCustomViewPager.setOnPageChangeListener(change);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout_viewPager);
        mTabLayout.setupWithViewPager(mCustomViewPager);
        mTabLayout.setOnTabSelectedListener(select);
    }

    private ViewPager.OnPageChangeListener change = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            mPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            mState = state;
            if (!mIsAnimating) {
                if (state == 1) {
                    animateHide();
                }
            }
        }
    };

    private TabLayout.OnTabSelectedListener select = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mCustomViewPager.setCurrentItem(tab.getPosition());
            setFloatButtonDetail();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    private void animateShow() {
        setFloatButtonDetail();
        ViewCompat.animate(mFb).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(180)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        mIsAnimating = true;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        mCustomViewPager.setSwipeHold(false);
                        mIsAnimating = false;
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        mIsAnimating = false;
                    }
                });
    }


    private void animateHide() {
        ViewCompat.animate(mFb).scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(180)
                .setInterpolator(new FastOutSlowInInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        mIsAnimating = true;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        mIsAnimating = false;
                        if (mState != 1) {
                            mCustomViewPager.setSwipeHold(true);
                            animateShow();
                        } else {
                            animateHide();
                        }
                    }

                    @Override
                    public void onAnimationCancel(View view) {
                        mIsAnimating = false;
                    }
                });
    }


    private void setFloatButtonDetail() {
        switch (mPosition) {
            case 0:
                mFb.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.color_floatButton_blue)));
                mFb.setImageResource(R.mipmap.ic_done_white_24dp);
                break;
            case 1:
                mFb.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.color_floatButton_red)));
                mFb.setImageResource(R.mipmap.ic_search_white_24dp);
                break;
            case 2:
                mFb.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.color_floatButton_green)));
                mFb.setImageResource(R.mipmap.ic_room_white_24dp);
                break;
        }
    }

}

