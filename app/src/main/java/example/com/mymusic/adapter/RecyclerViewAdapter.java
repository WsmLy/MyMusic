package example.com.mymusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.entity.BaseMusic;
import example.com.mymusic.ui.ItemView;

/**
 * @author Wang Shaoming
 * @create 2017/9/4
 * @description
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private int width;
    private List<BaseMusic> musicList;
    private OnItemClick onItemClick;
    private boolean itemClickable = true;

    public RecyclerViewAdapter(Context context, int width, List<BaseMusic> musicList) {
        this.context = context;
        this.width = width;
        this.musicList = musicList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setItemClickable(boolean itemClickable) {
        this.itemClickable = itemClickable;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new ItemView(context,width));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ((ItemView)holder.itemView).getName().setText(musicList.get(position).getName());
        ((ItemView)holder.itemView).getAuther().setText(musicList.get(position).getAuthor());
        ((ItemView)holder.itemView).getImageView().setImageResource(musicList.get(position).getImage());
        holder.itemView.setOnClickListener(view -> {
            if (itemClickable) {
//                    int position = holder.getAdapterPosition();
                onItemClick.onClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList.size();
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
