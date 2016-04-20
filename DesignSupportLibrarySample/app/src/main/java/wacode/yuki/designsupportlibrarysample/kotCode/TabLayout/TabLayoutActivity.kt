package wacode.yuki.designsupportlibrarysample.kotCode.TabLayout

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager

import wacode.yuki.designsupportlibrarysample.R
import java.util.*

class TabLayoutActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        setViewPager()
    }

    private fun setViewPager(){
        val view:ktPagerView = ktPagerView(this,null)
        var list:ArrayList<ktPagerView> = ArrayList()
        list.add(view.bindViews(resources.getColor(R.color.colorAccent),"1"))
        list.add(view.bindViews(resources.getColor(R.color.colorPrimary),"2"))
        list.add(view.bindViews(resources.getColor(R.color.colorPrimaryDark),"3"))
        val viewPager = findViewById(R.id.viewPager) as ViewPager
        viewPager.adapter = ktPagerAdapter(this,list)

        val tabLayout = findViewById(R.id.tablayout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

}
