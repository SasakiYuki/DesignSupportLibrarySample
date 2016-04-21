package wacode.yuki.designsupportlibrarysample.java.SnackBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/21.
 */
public class javaSnackBar_Activity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_snackbar);

        setViews();
    }

    private void setViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Button button = (Button) findViewById(R.id.button_snackBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = "Hello,world";
            Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_SHORT)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                        }
                    }).
                    show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
