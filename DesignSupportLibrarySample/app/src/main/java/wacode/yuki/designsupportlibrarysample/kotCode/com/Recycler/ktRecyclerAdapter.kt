package wacode.yuki.designsupportlibrarysample.kotCode.com.Recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import wacode.yuki.designsupportlibrarysample.R
import java.util.*

/**
 * Created by Yuki on 2016/04/16.
 */
class ktRecyclerAdapter(context: Context,private val resource:Int,private val objects:Array<String>) : RecyclerView.Adapter<ktRecyclerAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater


    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = objects[p1]
    }

    override fun getItemCount() = objects.size

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int)  = ViewHolder(layoutInflater.inflate(resource,p0,false))

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var textView: TextView
        init {
            textView= v.findViewById(R.id.textView) as TextView
        }
    }
}