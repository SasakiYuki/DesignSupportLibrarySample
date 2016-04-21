package wacode.yuki.designsupportlibrarysample.java.TabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/21.
 */
public class TabLayout_Activity extends AppCompatActivity{
    public static final String KEY_FRAGMENT_MODE = "key_fragment_mode";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_tablayout);
        setViews();
    }

    private void setViews(){
        String[] title = {"Tab1", "Tab2", "Tab3"};

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        TabLayout_ViewPagerAdapter adapter = new TabLayout_ViewPagerAdapter(fm, title);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
