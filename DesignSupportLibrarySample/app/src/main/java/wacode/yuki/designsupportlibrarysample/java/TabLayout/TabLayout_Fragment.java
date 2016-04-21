package wacode.yuki.designsupportlibrarysample.java.TabLayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wacode.yuki.designsupportlibrarysample.R;
import wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager.ViewPagerFloatButton_Activity;

/**
 * Created by Riberd on 2016/04/21.
 */
public class TabLayout_Fragment extends Fragment {
    private int mMode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        mMode = args.getInt(TabLayout_Activity.KEY_FRAGMENT_MODE);
        return inflater.inflate(R.layout.fragment_tablayout_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews();
    }

    public static TabLayout_Fragment newInstance(int mode) {
        TabLayout_Fragment fragment = new TabLayout_Fragment();
        Bundle args = new Bundle();
        args.putInt(TabLayout_Activity.KEY_FRAGMENT_MODE, mode);
        fragment.setArguments(args);
        return fragment;
    }

    private void setViews(){
        TextView textView = (TextView)getView().findViewById(R.id.textView_viewPager);
        textView.setText(String.valueOf(mMode + 1));
    }



}
