package wacode.yuki.designsupportlibrarysample.java.FloatingActionButton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/14.
 */
public class javaFloatButton_Activity extends AppCompatActivity{

    protected FloatingActionButton mFb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_button);

        setViews();
    }

    private void setViews(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRecyclerView();
        setFloatButton();
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(javaFloatButton_Activity.this));
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            item.add("item" + String.valueOf(i));
        }
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(javaFloatButton_Activity.this,item);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setFloatButton(){
        mFb = (FloatingActionButton)findViewById(R.id.first_fab);
        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hello world!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
