package wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import wacode.yuki.designsupportlibrarysample.R;
import wacode.yuki.designsupportlibrarysample.java.FloatingActionButton.RecyclerAdapter;

/**
 * Created by Riberd on 2016/04/21.
 */
public class ViewPager_Fragment extends Fragment {
    private int mMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        mMode = args.getInt(ViewPagerFloatButton_Activity.KEY_FRAGMENT_MODE);
        return inflater.inflate(R.layout.fragment_viewpager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews();
    }

    public static ViewPager_Fragment newInstance(int mode) {
        ViewPager_Fragment fragment = new ViewPager_Fragment();
        Bundle args = new Bundle();
        args.putInt(ViewPagerFloatButton_Activity.KEY_FRAGMENT_MODE, mode);
        fragment.setArguments(args);
        return fragment;
    }

    private void setViews() {
        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.linearLayout_back);
        String color = null;
        setRecyclerView();
        switch (mMode) {
            case 0:
                color = "#ffffff";
                break;
            case 1:
                color = "#FFA9FFA3";
                break;
            case 2:
                color = "#FFD18CE0";
                break;
        }
        linearLayout.setBackgroundColor(Color.parseColor(color));
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            item.add("item" + String.valueOf(i));
        }
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getActivity(), item);
        recyclerView.setAdapter(recyclerAdapter);
    }

}

