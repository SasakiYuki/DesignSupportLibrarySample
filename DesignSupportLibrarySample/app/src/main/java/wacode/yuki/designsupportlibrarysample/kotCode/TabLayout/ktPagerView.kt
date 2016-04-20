package wacode.yuki.designsupportlibrarysample.kotCode.TabLayout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.bindView
import wacode.yuki.designsupportlibrarysample.R

/**
 * Created by Yuki on 2016/04/20.
 */
class ktPagerView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val layoutInflater:LayoutInflater

    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindViews(background:Int, text:String):ktPagerView{
        val v = layoutInflater.inflate(R.layout.kt_pager_view,null) as ktPagerView
        val textView = v.findViewById(R.id.textView) as TextView
        textView.setBackgroundColor(background)
        textView.text = text
        Log.d("sarusaru",background.toString())
        return v
    }
}