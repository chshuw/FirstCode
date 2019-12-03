package com.wang.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wang.materialdesign.materialdesign.MaterialDesignActivity;
import com.wang.materialdesign.recycleview.RecycleViewActivity;
import com.wang.materialdesign.recycleview.RecycleViewActivity1;
import com.wang.materialdesign.recycleview.RecycleViewActivity2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Title[] titles = {new Title("Material Design"), new Title("recyclerview-线性布局纵向滚动"),
                              new Title("recyclerview1-线性布局横向滚动"), new Title("recyclerview2-瀑布流布局")};
    private Class[] classes = new Class[]{MaterialDesignActivity.class, RecycleViewActivity.class,
                                RecycleViewActivity1.class, RecycleViewActivity2.class};

    private List<Title> titleName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerview= findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        TitleAdapter adapter = new TitleAdapter(this, titleName,classes);
        TitleAdapter adapter = new TitleAdapter(this,titleName);
        recyclerview.setAdapter(adapter);

    }

    private void initData() {
//        titleName.clear();
//        for (int i = 0; i < titles.length; i++){
//            titleName.add(titles[i]);
//        }
        titleName.addAll(Arrays.asList(titles));
    }

    public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {

        private Context context;
        private List<Title> mTitleName;

        public TitleAdapter(Context context, List<Title> mTitleName) {
            this.context = context;
            this.mTitleName = mTitleName;
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
}
