package wacode.yuki.designsupportlibrarysample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import wacode.yuki.designsupportlibrarysample.kotCode.NavigationView.ktNavigationViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.button_kot_navigation:
                intent = new Intent(this,ktNavigationViewActivity.class);
                break;
            default:
                intent = null;
        }
        startActivity(intent);
    }
}
