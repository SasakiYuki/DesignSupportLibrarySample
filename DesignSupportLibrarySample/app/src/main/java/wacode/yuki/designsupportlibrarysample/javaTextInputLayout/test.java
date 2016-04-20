package wacode.yuki.designsupportlibrarysample.javaTextInputLayout;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.LinearLayout;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Yuki on 2016/04/19.
 */
public class test extends Activity{
    private void setgg(){
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);
        String text = "Hello wolrd";
        Snackbar.make(layout,text,Snackbar.LENGTH_SHORT).
                setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }
}
