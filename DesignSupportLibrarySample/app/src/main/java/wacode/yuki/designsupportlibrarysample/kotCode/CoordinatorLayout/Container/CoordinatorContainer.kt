package wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.Container

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.widget.LinearLayout
import butterknife.bindView
import wacode.yuki.designsupportlibrarysample.R
import wacode.yuki.designsupportlibrarysample.kotCode.CoordinatorLayout.ktCoordinatorLayoutActivity

/**
 * Created by Yuki on 2016/04/16.
 */
class CoordinatorContainer(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs),CoordinatorContainerListener {

    private val euc:CoordinatorLayout by bindView(R.id.euc)
    private val ea:CoordinatorLayout by bindView(R.id.ea)
    private val eac:CoordinatorLayout by bindView(R.id.eac)
    private val buttonLayout:LinearLayout by bindView(R.id.buttonLayout)
    var backKeyLeadTheEnd = true

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    override fun showEA() {
        euc.visibility = GONE
        ea.visibility = VISIBLE
        eac.visibility = GONE
        buttonLayout.visibility = GONE
        backKeyLeadTheEnd = false
    }

    override fun showEAC() {
        euc.visibility = GONE
        ea.visibility = GONE
        eac.visibility = VISIBLE
        buttonLayout.visibility = GONE
        backKeyLeadTheEnd = false
    }

    override fun showEUC() {
        euc.visibility = VISIBLE
        ea.visibility = GONE
        eac.visibility = GONE
        buttonLayout.visibility = GONE
        backKeyLeadTheEnd = false
    }
    override fun showButtonLayout() {
        euc.visibility = GONE
        ea.visibility = GONE
        eac.visibility = GONE
        buttonLayout.visibility = VISIBLE
        backKeyLeadTheEnd = true
    }
    override fun leadTheEnd():Boolean {
        return backKeyLeadTheEnd
    }
}