package com.caoxing.listdialog.listdialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by caoxing on 2017/3/16.
 */

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> list;
    private ContentItemListener contentItemListener;

    public ContentAdapter(Context context, List<String> list, ContentItemListener contentItemListener) {
        this.context = context;
        this.list = list;
        this.contentItemListener = contentItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_item, null);
        ContentViewHolder contentViewHolder = new ContentViewHolder(view, contentItemListener);
        return contentViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).textView.setText(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ContentItemListener contentItemListener;

        public ContentViewHolder(View itemView, ContentItemListener contentItemListener) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.content_item_tv);
            this.contentItemListener = contentItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            contentItemListener.onItemClick(v, getPosition());

        }
    }


}
