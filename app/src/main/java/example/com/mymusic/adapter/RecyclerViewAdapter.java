package example.com.mymusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import example.com.mymusic.R;
import example.com.mymusic.ui.ItemView;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new ItemView(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((ItemView)holder.itemView).getName().setText("hello");
        ((ItemView)holder.itemView).getAuther().setText("mymusic");
        ((ItemView)holder.itemView).getImageView().setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
