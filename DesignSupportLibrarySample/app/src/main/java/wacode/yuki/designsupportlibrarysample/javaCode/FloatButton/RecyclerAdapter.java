package wacode.yuki.designsupportlibrarysample.javaCode.FloatButton;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import wacode.yuki.designsupportlibrarysample.R;

/**
 * Created by Riberd on 2016/04/14.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mDataList;

public RecyclerAdapter(Context context, ArrayList<String> dataList) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1
        View v = mLayoutInflater.inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // 4
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 3
        String data = (String) mDataList.get(position);
        holder.text.setText(data);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(View v) {
            super(v);
            // 2
            text = (TextView) v.findViewById(R.id.textView_recycler);
        }
    }
}