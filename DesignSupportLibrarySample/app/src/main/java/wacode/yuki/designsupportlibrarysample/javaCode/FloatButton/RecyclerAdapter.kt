package wacode.yuki.designsupportlibrarysample.javaCode.FloatButton

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import wacode.yuki.designsupportlibrarysample.R

/**
 * Created by Riberd on 2016/04/14.
 */
class RecyclerAdapter(context: Context, private val mDataList: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        // 1
        val v = mLayoutInflater.inflate(R.layout.item_recycler_view, parent, false)
        val viewHolder = ViewHolder(v)
        return viewHolder
    }

    // 4
    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 3
        holder.text.text = mDataList[position]
    }

    inner  class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var text: TextView

        init {
            // 2
            text = v.findViewById(R.id.textView_recycler) as TextView
        }
    }
}