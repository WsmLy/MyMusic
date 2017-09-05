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
    private int width;
    private OnItemClick onItemClick;
    public RecyclerViewAdapter(Context context, int width) {
        this.context = context;
        this.width = width;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new ItemView(context,width));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ((ItemView)holder.itemView).getName().setText("hello");
        ((ItemView)holder.itemView).getAuther().setText("mymusic");
        ((ItemView)holder.itemView).getImageView().setImageResource(R.mipmap.ic_launcher);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                onItemClick.onClick(holder.itemView, position);
            }
        });
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

    public interface OnItemClick {
        void onClick(View view, int position);
    }
}
