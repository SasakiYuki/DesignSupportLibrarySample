package wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.enterAlways

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import butterknife.bindView
import wacode.yuki.designsupportlibrarysample.R
import wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.ktCoordinatorLayoutActivity

/**
 * Created by Yuki on 2016/04/18.
 */
class enterAlwaysLayout(context: Context?, attrs: AttributeSet?) : CoordinatorLayout(context, attrs) {
    private val toolBar: Toolbar by bindView(R.id.toolbar)

    override fun onFinishInflate() {
        super.onFinishInflate()
        initToolBar()
    }

    private fun initToolBar(){
        val activity = context as ktCoordinatorLayoutActivity
        activity.setSupportActionBar(toolBar)
    }
}