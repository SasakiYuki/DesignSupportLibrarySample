package wacode.yuki.designsupportlibrarysample.kotCode.TabLayout

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by Yuki on 2016/04/20.
 */
class ktPagerAdapter(private val context: Context,private val list:ArrayList<ktPagerView>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any? {
        container.addView(list[position])
        return list[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any?) {
        container.removeView(`object` as ktPagerView)
    }

    override fun isViewFromObject(p0: View?, p1: Any?): Boolean {
        return p0 == p1 as ktPagerView
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return position.toString()
    }
}