package wacode.yuki.designsupportlibrarysample.java.NavigationView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/21.
 */
public class javaNavigationView_Activity extends AppCompatActivity{
    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private TextView mTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        setViews();
        setDrawer();
    }

    private void setViews(){
        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mTextView = (TextView)findViewById(R.id.textView);
        setSupportActionBar(mToolBar);
    }

    private void setDrawer(){
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,mDrawerLayout,mToolBar,R.string.navigation_open,R.string.navigation_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(select);
    }

    private NavigationView.OnNavigationItemSelectedListener select = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            mTextView.setText(item.getTitle());
            mDrawerLayout.closeDrawers();
            return true;
        }
    };
}
