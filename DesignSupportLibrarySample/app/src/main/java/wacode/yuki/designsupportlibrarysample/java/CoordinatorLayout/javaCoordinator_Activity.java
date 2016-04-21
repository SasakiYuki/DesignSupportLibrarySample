package wacode.yuki.designsupportlibrarysample.java.CoordinatorLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import wacode.yuki.designsupportlibrarysample.R;
import wacode.yuki.designsupportlibrarysample.java.FloatingActionButton.RecyclerAdapter;

/**
 * Created by Riberd on 2016/04/21.
 */
public class javaCoordinator_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_coordinatorlayout);

        setViews();
    }

    private void setViews(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRecyclerView();
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(javaCoordinator_Activity.this));
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            item.add("item" + String.valueOf(i));
        }
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(javaCoordinator_Activity.this,item);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

