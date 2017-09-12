package example.com.mymusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.mymusic.R;
import example.com.mymusic.entity.ItemLeft;

/**
 * @author Wang Shaoming
 * @create 2017/9/11
 * @description
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {

    private Context context;
    private List<ItemLeft> items;
    private OnItemClick onItemClick;

    public LeftAdapter(Context context, List<ItemLeft> items) {
        this.context = context;
        this.items = items;
        System.out.println(items.size());
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_left, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(items.get(position).getImageId());
        holder.textView.setText(items.get(position).getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getLayoutPosition();
                onItemClick.onItemClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.left_item_image);
            textView = (TextView)itemView.findViewById(R.id.left_item_text);
        }
    }

    public interface OnItemClick{
        void onItemClick(View view, int position);
    }
}
