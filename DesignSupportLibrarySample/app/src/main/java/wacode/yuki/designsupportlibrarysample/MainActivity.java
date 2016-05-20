package wacode.yuki.designsupportlibrarysample;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager.ViewPagerFloatButton_Activity;
import wacode.yuki.designsupportlibrarysample.java.CoordinatorLayout.javaCoordinator_Activity;
import wacode.yuki.designsupportlibrarysample.java.FloatingActionButton.javaFloatButton_Activity;
import wacode.yuki.designsupportlibrarysample.java.NavigationView.javaNavigationView_Activity;
import wacode.yuki.designsupportlibrarysample.java.SnackBar.javaSnackBar_Activity;
import wacode.yuki.designsupportlibrarysample.java.TabLayout.TabLayout_Activity;
import wacode.yuki.designsupportlibrarysample.java.TextInputLayout.javaTextInputLayout_Activity;
import wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.ktCoordinatorLayoutActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.FloatActionButton.ktFABActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.InputTextLayout.ktInputTextActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.NavigationView.ktNavigationViewActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.Snackbar.ktSnackBarActivity;
import wacode.yuki.designsupportlibrarysample.kotCode.TabLayout.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setCardView();
    }

    private void setCardView() {
        for (int i = 0; i < 2; i++) {
            LinearLayout linearLayout_Card = null;
            String[] titleArray = null;
            switch (i) {
                case 0:
                    linearLayout_Card = (LinearLayout) findViewById(R.id.javaCardLinear);
                    titleArray = getResources().getStringArray(R.array.javaTitle);
                    break;
                case 1:
                    linearLayout_Card = (LinearLayout) findViewById(R.id.kotCardLinear);
                    titleArray = getResources().getStringArray(R.array.kotTitle);
                    break;
            }
            linearLayout_Card.removeAllViews();

            for (int ii = 0; ii < titleArray.length; ii++) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.item_card_view, null);
                CardView cardView = (CardView) linearLayout.findViewById(R.id.cardView);
                TextView textView_title = (TextView) linearLayout.findViewById(R.id.textView_Title);
                textView_title.setText(titleArray[ii]);
                cardView.setTag(ii);
                setCardIcon(linearLayout,titleArray[ii]);

                if (i == 0) {
                    cardView.setOnClickListener(javaClick);
                } else {
                    cardView.setOnClickListener(kotClick);
                }

                linearLayout_Card.addView(linearLayout, ii);
            }
        }
    }

    private void setCardIcon(LinearLayout linearLayout,String title) {
        int[] color = new int[]{
                getResources().getColor(R.color.color_Amber),getResources().getColor(R.color.color_Cyan),getResources().getColor(R.color.color_LightBlue)
                ,getResources().getColor(R.color.color_LightGreen),getResources().getColor(R.color.color_Pink),getResources().getColor(R.color.color_floatButton_blue),getResources().getColor(R.color.color_floatButton_red)
        };

        TextView textView_icon = (TextView) linearLayout.findViewById(R.id.textView_Icon);

        String beginningTitle = title.substring(0,1);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Random random = new Random();
        int i = random.nextInt(color.length);
        shapeDrawable.getPaint().setColor(color[i]);

        textView_icon.setBackground(shapeDrawable);
        textView_icon.setText(beginningTitle);

    }

    private CardView.OnClickListener javaClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch ((int) v.getTag()) {
                case 0:
                    intent = new Intent(MainActivity.this, javaFloatButton_Activity.class);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, javaNavigationView_Activity.class);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, javaCoordinator_Activity.class);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, javaTextInputLayout_Activity.class);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, javaSnackBar_Activity.class);
                    break;
                case 5:
                    intent = new Intent(MainActivity.this, TabLayout_Activity.class);
                    break;
                case 6:
                    intent = new Intent(MainActivity.this, ViewPagerFloatButton_Activity.class);
                    break;
                default:
                    intent = null;
            }
            startActivity(intent);
        }
    };

    private CardView.OnClickListener kotClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch ((int) v.getTag()) {
                case 0:
                    intent = new Intent(MainActivity.this, ktFABActivity.class);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, ktNavigationViewActivity.class);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, ktCoordinatorLayoutActivity.class);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, ktInputTextActivity.class);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, ktSnackBarActivity.class);
                    break;
                case 5:
                    intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                    break;
                default:
                    intent = null;
            }
            startActivity(intent);
        }
    };
}
