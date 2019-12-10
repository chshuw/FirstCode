package com.wang.firstcode;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wang.materialdesign.R;

import java.util.List;

/**
 * Created by wangchangshu on 2019-12-02.
 * Describe:
 */
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {

    private Context context;
    private List<Title> mTitleName;
    private Class[] classes;

    public TitleAdapter(Context context, List<Title> mTitleName, Class[] classes) {
        this.context = context;
        this.mTitleName = mTitleName;
        this.classes = classes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION){
                Intent intent = new Intent(context, classes[position]);
                context.startActivity(intent);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Title title = mTitleName.get(position);
        holder.textView.setText(title.getName());
    }

    @Override
    public int getItemCount() {
        return mTitleName.size();
    }

}
