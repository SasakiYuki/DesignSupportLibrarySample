package wacode.yuki.designsupportlibrarysample.kotCode.com.Recycler

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import wacode.yuki.designsupportlibrarysample.R

/**
 * Created by Yuki on 2016/04/16.
 */
class ktRecyclerView(context: Context?, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    override fun onFinishInflate() {
        super.onFinishInflate()
        layoutManager = LinearLayoutManager(context)
        val adapter = ktRecyclerAdapter(context, R.layout.kt_recycler,resources.getStringArray(R.array.dummy))
        setAdapter(adapter)
    }

    fun setAdapters(){
        layoutManager = LinearLayoutManager(context)
        val adapter = ktRecyclerAdapter(context, R.layout.kt_recycler,resources.getStringArray(R.array.dummy))
        setAdapter(adapter)
    }
}