package wacode.yuki.designsupportlibrarysample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wacode.yuki.designsupportlibrarysample.kotCode.NavigationView.ktNavigationViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, ktNavigationViewActivity.class);
        startActivity(intent);
    }
}
