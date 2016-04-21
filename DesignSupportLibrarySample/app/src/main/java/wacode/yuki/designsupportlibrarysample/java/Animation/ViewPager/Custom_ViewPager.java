package wacode.yuki.designsupportlibrarysample.java.Animation.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Riberd on 2016/04/21.
 */
public class Custom_ViewPager extends ViewPager {

    Boolean mHold = false;
    public Custom_ViewPager(Context context) {
        super(context);
    }

    public void setSwipeHold(boolean swipeHold){
        mHold = swipeHold;
    }

    public Custom_ViewPager(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mHold){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mHold){
            return false;
        }
        return super.onTouchEvent(ev);
    }
}
