package wacode.yuki.designsupportlibrarysample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager.ViewPagerFloatButton_Activity;
import wacode.yuki.designsupportlibrarysample.java.CoordinatorLayout.javaCoordinator_Activity;
import wacode.yuki.designsupportlibrarysample.java.SnackBar.javaSnackBar_Activity;
import wacode.yuki.designsupportlibrarysample.java.TabLayout.TabLayout_Activity;
import wacode.yuki.designsupportlibrarysample.java.TextInputLayout.javaTextInputLayout_Activity;
import wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.ktCoordinatorLayoutActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.FloatActionButton.ktFABActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.InputTextLayout.ktInputTextActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.NavigationView.ktNavigationViewActivity;
import wacode.yuki.designsupportlibrarysample.java.FloatingActionButton.javaFloatButton_Activity;
import wacode.yuki.designsupportlibrarysample.kotCode.Snackbar.ktSnackBarActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.TabLayout.TabLayoutActivity;

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
            case R.id.button_kot_coordinator:
                intent = new Intent(this,ktCoordinatorLayoutActivity.class);
                break;
            case R.id.button_kot_input:
                intent = new Intent(this, ktInputTextActivity.class);
                break;
            case R.id.button_kot_snackbar:
                intent = new Intent(this,ktSnackBarActivity.class);
                break;
            case R.id.button_kot_tablayout:
                intent = new Intent(this,TabLayoutActivity.class);
                break;
            case R.id.button_kot_button:
                intent = new Intent(this,ktFABActivity.class);
                break;
            case R.id.button_java_floatButton:
                intent = new Intent(this,javaFloatButton_Activity.class);
                break;
            case R.id.button_java_inputLayout:
                intent = new Intent(this,javaTextInputLayout_Activity.class);
                break;
            case R.id.button_java_viewPager:
                intent = new Intent(this, ViewPagerFloatButton_Activity.class);
                break;
            case R.id.button_java_snackBar:
                intent = new Intent(this,javaSnackBar_Activity.class);
                break;
            case R.id.button_java_tabLayout:
                intent = new Intent(this, TabLayout_Activity.class);
                break;
            case R.id.button_java_coordinatorLayout:
                intent = new Intent(this,javaCoordinator_Activity.class);
                break;
            default:
                intent = null;
        }
        startActivity(intent);
    }

}
